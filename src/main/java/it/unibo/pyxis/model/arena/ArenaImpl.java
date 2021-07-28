package it.unibo.pyxis.model.arena;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import it.unibo.pyxis.model.element.ball.Ball;
import it.unibo.pyxis.model.element.ball.BallImpl;
import it.unibo.pyxis.model.element.ball.BallType;
import it.unibo.pyxis.model.element.brick.Brick;
import it.unibo.pyxis.model.element.brick.BrickType;
import it.unibo.pyxis.model.element.pad.Pad;
import it.unibo.pyxis.model.element.pad.PadImpl;
import it.unibo.pyxis.model.element.powerup.Powerup;
import it.unibo.pyxis.model.element.powerup.PowerupImpl;
import it.unibo.pyxis.model.event.notify.PowerupActivationEvent;
import it.unibo.pyxis.model.hitbox.HitEdge;
import it.unibo.pyxis.model.powerup.effect.PowerupEffectType;
import it.unibo.pyxis.model.powerup.handler.PowerupHandler;
import it.unibo.pyxis.model.powerup.handler.PowerupHandlerImpl;
import it.unibo.pyxis.model.powerup.handler.PowerupHandlerPolicy;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.CoordImpl;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.element.powerup.PowerupType;
import it.unibo.pyxis.model.event.Events;
import it.unibo.pyxis.model.event.notify.BrickDestructionEvent;
import it.unibo.pyxis.model.util.VectorImpl;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public final class ArenaImpl implements Arena {

    private Coord startingPadPosition;
    private Coord startingBallPosition;

    private final Dimension dimension;
    private final Map<Coord, Brick> brickMap;
    private final Set<Ball> ballSet;
    private final Set<Powerup> powerupSet;
    private final PowerupHandler powerupHandler;
    private Pad pad;

    private static final double POWERUP_SPAWN_PROBABILITY = (3.0 / 10);
    private final Random rng;

    public ArenaImpl(final Dimension inputDimension) {
        this.brickMap = new HashMap<>();
        this.ballSet = new HashSet<>();
        this.powerupSet = new HashSet<>();
        this.rng = new Random();
        this.dimension = inputDimension;
        // Configuring the powerup handler.
        final PowerupHandlerPolicy policy = (type, map) -> {
            if (type == PowerupEffectType.BALL_POWERUP) {
                map.values().forEach(Thread::interrupt);
            }
        };
        this.powerupHandler = new PowerupHandlerImpl(policy, this);
        // Register the Arena to the event bus
        EventBus.getDefault().register(this);
    }

    /**
     * Spawn a new {@link Powerup} in a specified position.
     * Add a new instance of {@link Powerup} inside the set of powerups.
     *
     * @param spawnCoord
     *                  The starting position of newly created {@link Powerup}.
     */
    private void spawnPowerup(final Coord spawnCoord) {
        final PowerupType selectedType = PowerupType.values()[rangeNextInt(PowerupType.values().length)];
        final Powerup powerup = new PowerupImpl(selectedType, spawnCoord);
        this.addPowerup(powerup);
    }

    @Override
    public void update(final double delta) {
        this.ballSet.forEach(b -> b.update(delta));
        this.powerupSet.forEach(p -> p.update(delta));
    }

    @Override
    @Subscribe
    public void handleBrickDestruction(final BrickDestructionEvent event) {
        this.brickMap.remove(event.getBrickCoord());
        if (calculateSpawnPowerup()) {
            this.spawnPowerup(event.getBrickCoord());
        }
    }

    private boolean calculateSpawnPowerup() {
        final int multiplier = 100;
        int randNum = rangeNextInt(multiplier);
        System.out.println(randNum + " <= " + Math.floor(multiplier * POWERUP_SPAWN_PROBABILITY) + " ? " + (randNum <= Math.floor(multiplier * POWERUP_SPAWN_PROBABILITY)));
        return randNum <= Math.floor(multiplier * POWERUP_SPAWN_PROBABILITY);
    }

    @Override
    @Subscribe
    public void handlePowerupActivation(final PowerupActivationEvent event) {
        this.powerupHandler.addPowerup(event.getPowerup().getType().getEffect());
        this.powerupSet.remove(event.getPowerup());
    }

    @Override
    @Subscribe
    public void checkBorderCollision() {
        for (final Ball b: getBalls()) {
            if (b.getHitbox().isCollidingWithLowerBorder(this.getDimension())) {
                this.ballSet.remove(b);
                if (this.ballSet.isEmpty()) {
                    //EventBus.getDefault().post(Events.newDecreaseLifeEvent());
                    this.powerupHandler.stop();
                    this.resetStartingPosition();
                }
            } else {
                final Optional<HitEdge> hitEdge = b.getHitbox().collidingEdgeWithBorder(this.getDimension());
                hitEdge.ifPresent(edge -> EventBus.getDefault().post(Events.newCollisionEvent(edge)));
            }
        }
        for (final Powerup p: getPowerups()) {
            if (p.getHitbox().isCollidingWithLowerBorder(this.getDimension())) {
                this.powerupSet.remove(p);
            }
        }
    }

    /**
     * Resets the {@link Pad} and the {@link Ball} to the starting {@link Coord}.
     */
    private void resetStartingPosition() {
        this.getPad().setPosition(this.startingPadPosition);
        //this.ballSet.add(new BallImpl());
    }

    /**
     * Returns a pseudorandom {@link Integer} value between 0 (inclusive) and the specified value (exclusive). 
     * @param upperBound
     *                   The upper bound of the range.
     * @return
     *          the pseudorandom {@link Integer} value between 0 (inclusive) and the specified value (exclusive)
     *          from the {@link Random} rng sequence.
     */
    private Integer rangeNextInt(final int upperBound) {
        return rng.nextInt(upperBound);
    }

    /**
     * Return the last {@link Ball} id inserted in the {@link Arena}.
     * @return
     *          The integer representing the last id inserted
     *          in the {@link Arena}
     */
    private int getLastBallId() {
        return this.ballSet.stream()
                .mapToInt(Ball::getId)
                .max()
                .orElse(0);
    }

    @Override
    public Dimension getDimension() {
        return this.dimension.copyOf();
    }

    @Override
    public Set<Ball> getBalls() {
        return Set.copyOf(this.ballSet);
    }

    @Override
    public Set<Brick> getBricks() {
        return new HashSet<>(this.brickMap.values());
    }

    @Override
    public Set<Powerup> getPowerups() {
        return Set.copyOf(this.powerupSet);
    }

    @Override
    public Pad getPad() {
        return this.pad;
    }

    @Override
    public void setPad(final Pad inputPad) {
        if (Objects.isNull(this.startingPadPosition)) {
            this.startingPadPosition = inputPad.getPosition();
        }
        this.pad = inputPad;
    }

    @Override
    public void setDefaultPad() {
        final double posX = this.getDimension().getWidth() / 2;
        final double posY = this.getDimension().getHeight() * 0.7;
        final Pad defaultPad = new PadImpl(new CoordImpl(posX, posY));
        this.setPad(defaultPad);
    }

    @Override
    public void addBrick(final Brick brick) {
        this.brickMap.put(brick.getPosition(), brick);
    }

    @Override
    public void addBall(final Ball ball) {
        if (Objects.isNull(this.startingBallPosition)) {
            this.startingBallPosition = ball.getPosition();
        }
        this.ballSet.add(ball);
    }

    @Override
    public void addDefaultBall() {
        final double posX = this.getDimension().getWidth() / 2;
        final double posY = this.getDimension().getHeight() * 0.7;
        final int ballId = this.getLastBallId() + 1;
        final Ball defaultBall = new BallImpl.Builder()
                .ballType(BallType.NORMAL_BALL)
                .initialPosition(new CoordImpl(posX, posY))
                .id(ballId)
                .pace(new VectorImpl(1.0, 1.0))
                .build();
        this.addBall(defaultBall);
    }

    @Override
    public void addPowerup(final Powerup powerup) {
        this.powerupSet.add(powerup);
    }

    @Override
    public boolean isCleared() {
        return this.getBricks().stream().noneMatch(b -> b.getBrickType() != BrickType.INDESTRUCTIBLE);
    }

    @Override
    public void cleanup() {
        final EventBus bus = EventBus.getDefault();
        this.getBalls().forEach(bus::unregister);
        this.ballSet.clear();
        this.getBricks().forEach(bus::unregister);
        this.brickMap.clear();
        bus.unregister(this.getPad());
        this.powerupHandler.stop();
        this.powerupHandler.shutdown();
    }

    @Override
    public String toString() {
        final int ballsNumber = this.getBalls().size();
        final int powerupsNumber = this.getPowerups().size();
        final int brickNumbers = this.getBricks().size();
        final int totalElements = ballsNumber + powerupsNumber + brickNumbers;
        return "Arena[Total elements : " + totalElements
                + ", #Ball : " + ballsNumber
                + ", #Powerup : " + powerupsNumber
                + ", #Brick : " + brickNumbers
                + "]";
    }
}
