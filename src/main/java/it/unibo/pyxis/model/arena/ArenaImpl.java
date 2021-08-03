package it.unibo.pyxis.model.arena;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

import it.unibo.pyxis.model.arena.component.ArenaPhysicsComponent;
import it.unibo.pyxis.model.ecs.component.physics.PhysicsComponent;
import it.unibo.pyxis.model.ecs.entity.AbstractEntity;
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
import it.unibo.pyxis.model.powerup.effect.PowerupEffectType;
import it.unibo.pyxis.model.powerup.handler.PowerupHandler;
import it.unibo.pyxis.model.powerup.handler.PowerupHandlerImpl;
import it.unibo.pyxis.model.powerup.handler.PowerupHandlerPolicy;
import it.unibo.pyxis.model.element.powerup.PowerupType;
import it.unibo.pyxis.model.event.notify.BrickDestructionEvent;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.CoordImpl;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.Vector;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public final class ArenaImpl extends AbstractEntity implements Arena {

    private Pad pad;
    private Coord startingPadPosition;
    private Coord startingBallPosition;
    private Vector startingBallPace;
    private final Set<Ball> ballSet;
    private final Map<Coord, Brick> brickMap;
    private final Set<Powerup> powerupSet;
    private final PowerupHandler powerupHandler;
    private final Dimension dimension;

    private static final double POWERUP_SPAWN_PROBABILITY = 2.0 / 10;
    private final Random randomNumberGenerator;

    public ArenaImpl(final Dimension inputDimension) {
        this.brickMap = new HashMap<>();
        this.ballSet = new HashSet<>();
        this.powerupSet = new HashSet<>();
        this.randomNumberGenerator = new Random();
        this.dimension = inputDimension;
        final PowerupHandlerPolicy policy = (type, map) -> {
            if (type == PowerupEffectType.BALL_POWERUP) {
                map.values().forEach(Thread::interrupt);
            }
        };
        this.powerupHandler = new PowerupHandlerImpl(policy, this);
        EventBus.getDefault().register(this);
        this.registerComponent(new ArenaPhysicsComponent(this));
    }

    /**
     * Resets the {@link Pad} and the {@link Ball} to the starting {@link Coord}.
     */
    @Override
    public void resetStartingPosition() {
        this.getPad().setPosition(this.startingPadPosition.copyOf());
        final Ball newBall = new BallImpl.Builder()
                .initialPosition(this.startingBallPosition.copyOf())
                .pace(this.startingBallPace.copyOf())
                .ballType(BallType.NORMAL_BALL)
                .id(1)
                .build();
        this.ballSet.clear();
        this.ballSet.add(newBall);
    }

    /**
     * Returns a pseudorandom {@link Integer} value between 0 (inclusive) and the specified value (exclusive).
     * @return
     *          the pseudorandom {@link Integer} value between 0 (inclusive) and the specified value (exclusive)
     *          from the {@link Random} rng sequence.
     */
    private Integer rangeNextInt(final int upperBound) {
        return randomNumberGenerator.nextInt(upperBound);
    }

    /**
     * Calculate the new position of the {@link Pad}.
     * @param directionalVector
     *                          The directional {@link Vector} used for setting the new {@link Coord}.
     * @return
     *          The new position of the {@link Pad}
     */
    private Coord calcPadNewXCoord(final double dx) {
        final Coord updatedCoord = this.pad.getPosition();
        updatedCoord.sumXValue(dx);
        return updatedCoord;
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

    /**
     * Determine if a {@link Powerup} should be created.
     * @return
     *          True if the {@link Powerup} can be created false otherwise.
     */
    private boolean calculateSpawnPowerup() {
        final int multiplier = 100;
        return rangeNextInt(multiplier) <= Math.floor(multiplier * POWERUP_SPAWN_PROBABILITY);
    }

    /**
     * Remove all the {@link Ball}s in the {@link Arena} unsubscribing them
     * from the {@link EventBus}.
     */
    private void clearBalls() {
        this.getBalls().forEach(ball -> {
            if (EventBus.getDefault().isRegistered(ball)) {
                EventBus.getDefault().unregister(ball);
            }
        });
        this.ballSet.clear();
    }

    /**
     * Remove all the {@link Brick}s in the {@link Arena} unsubscribing them
     * from the {@link EventBus}.
     */
    private void clearBricks() {
        this.getBricks().forEach(brick -> {
            if (EventBus.getDefault().isRegistered(brick)) {
                EventBus.getDefault().unregister(brick);
            }
        });
        this.brickMap.clear();
    }

    /**
     * Modify the {@link Pad} width dimension of a certain amount.
     * @param amount
     *               The modifying amount
     */
    private synchronized void modifyPadWidth(final double amount) {
        final double padWidth = this.pad.getDimension().getWidth();
        final Coord padPosition = this.getPad().getPosition();
        final double halfIncrement = (padWidth + amount) / 2;
        double offset = 0;
        if (padPosition.getX() + halfIncrement > this.getDimension().getWidth()) {
            offset = (this.getDimension().getWidth() - (padPosition.getX() + halfIncrement));
        } else if (padPosition.getX() - halfIncrement < 0) {
            offset = -(padPosition.getX() - halfIncrement);
        }
        final Coord newPadPosition = new CoordImpl(padPosition.getX() + offset, padPosition.getY());
        this.pad.increaseWidth(amount);
        this.pad.setPosition(newPadPosition);

    }

    @Override
    @Subscribe
    public void handleBrickDestruction(final BrickDestructionEvent event) {
        this.brickMap.remove(event.getBrickCoord());
        if (this.calculateSpawnPowerup()) {
            this.spawnPowerup(event.getBrickCoord());
        }
    }

    @Override
    @Subscribe
    public void handlePowerupActivation(final PowerupActivationEvent event) {
        this.powerupHandler.addPowerup(event.getPowerup().getType().getEffect());
        this.removePowerup(event.getPowerup());
    }

    @Override
    public void update(final double delta) {
        this.getComponent(PhysicsComponent.class).update(delta);
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
    public int getLastBallId() {
        return this.ballSet.stream()
                .mapToInt(Ball::getId)
                .max()
                .orElse(0);
    }

    @Override
    public Ball getRandomBall() {
        final List<Ball> ballList = new ArrayList<>(this.ballSet);
        Collections.shuffle(ballList);
        return ballList.get(0);
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
    public PowerupHandler getPowerupHandler() {
        return this.powerupHandler;
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
    public void movePadLeft() {
        final Coord oldPosition = this.pad.getPosition();
        Coord newPosition = this.calcPadNewXCoord(-PadImpl.PAD_X_MOVEMENT);
        if (newPosition.getX() < this.pad.getDimension().getWidth() / 2) {
            newPosition = new CoordImpl(
                    this.pad.getDimension().getWidth() / 2,
                    this.pad.getPosition().getY());
        }
        this.pad.setPosition(newPosition);
        if (this.getBalls().stream()
                .anyMatch(b -> b.getHitbox().isCollidingWithHB(this.pad.getHitbox()))) {
            this.pad.setPosition(oldPosition);
        }
    }

    @Override
    public void movePadRight() {
        final Coord oldPosition = this.pad.getPosition();
        Coord newPosition = this.calcPadNewXCoord(PadImpl.PAD_X_MOVEMENT);
        if (newPosition.getX() > this.dimension.getWidth() - this.pad.getDimension().getWidth() / 2) {
            newPosition = new CoordImpl(
                    this.dimension.getWidth() - this.pad.getDimension().getWidth() / 2,
                    this.pad.getPosition().getY());
        }
        this.pad.setPosition(newPosition);
        if (this.getBalls().stream()
                .anyMatch(b -> b.getHitbox().isCollidingWithHB(this.pad.getHitbox()))) {
            this.pad.setPosition(oldPosition);
        }
    }

    @Override
    public void increasePadWidth(final double amount) {
        this.modifyPadWidth(amount);
    }

    @Override
    public void decreasePadWidth(final double amount) {
        this.modifyPadWidth(-amount);
    }

    @Override
    public void addBrick(final Brick brick) {
        this.brickMap.put(brick.getPosition(), brick);
    }

    @Override
    public void removeBrick(final Coord brickCoord) {
        final Brick removedBrick = this.brickMap.remove(brickCoord);
        if (EventBus.getDefault().isRegistered(removedBrick)) {
            EventBus.getDefault().unregister(removedBrick);
        }
    }

    @Override
    public void addBall(final Ball ball) {
        if (Objects.isNull(this.startingBallPosition)) {
            this.startingBallPosition = ball.getPosition();
            this.startingBallPace = ball.getPace();
        }
        this.ballSet.add(ball);
    }

    @Override
    public void removeBall(final Ball ball) {
        this.ballSet.remove(ball);
        if (EventBus.getDefault().isRegistered(ball)) {
            EventBus.getDefault().unregister(ball);
        }
    }

    @Override
    public void addPowerup(final Powerup powerup) {
        this.powerupSet.add(powerup);
    }

    @Override
    public void removePowerup(final Powerup powerup) {
        this.powerupSet.remove(powerup);
        if (EventBus.getDefault().isRegistered(powerup)) {
            EventBus.getDefault().unregister(powerup);
        }
    }

    @Override
    public void clearPowerups() {
        this.powerupSet.forEach(powerup -> {
            if (EventBus.getDefault().isRegistered(powerup)) {
                EventBus.getDefault().unregister(powerup);
            }
        });
        this.powerupSet.clear();
        this.powerupHandler.stop();
    }

    @Override
    public boolean isCleared() {
        return this.getBricks().stream().noneMatch(b -> b.getBrickType() != BrickType.INDESTRUCTIBLE);
    }

    @Override
    public void cleanUp() {
        this.clearBalls();
        this.clearBricks();
        this.clearPowerups();
        this.powerupHandler.shutdown();
        if (EventBus.getDefault().isRegistered(this.getPad())) {
            EventBus.getDefault().unregister(this.getPad());
        }
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
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
