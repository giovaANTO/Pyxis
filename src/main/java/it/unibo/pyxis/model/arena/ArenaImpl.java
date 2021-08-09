package it.unibo.pyxis.model.arena;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import it.unibo.pyxis.model.arena.component.ArenaEventComponent;
import it.unibo.pyxis.model.arena.component.ArenaPhysicsComponent;
import it.unibo.pyxis.ecs.component.event.EventComponent;
import it.unibo.pyxis.ecs.component.physics.PhysicsComponent;
import it.unibo.pyxis.ecs.EntityImpl;
import it.unibo.pyxis.model.element.ball.Ball;
import it.unibo.pyxis.model.element.ball.BallType;
import it.unibo.pyxis.model.element.brick.Brick;
import it.unibo.pyxis.model.element.brick.BrickType;
import it.unibo.pyxis.model.element.factory.ElementFactory;
import it.unibo.pyxis.model.element.factory.ElementFactoryImpl;
import it.unibo.pyxis.model.element.pad.Pad;
import it.unibo.pyxis.model.element.powerup.Powerup;
import it.unibo.pyxis.model.powerup.handler.PowerupHandler;
import it.unibo.pyxis.model.powerup.handler.PowerupHandlerImpl;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.CoordImpl;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.Vector;
import org.greenrobot.eventbus.EventBus;

public final class ArenaImpl extends EntityImpl implements Arena {

    private static final double PAD_X_MOVEMENT = 10;
    private final Set<Ball> ballSet;
    private final Map<Coord, Brick> brickMap;
    private final Set<Powerup> powerupSet;
    private final PowerupHandler powerupHandler;
    private final Dimension dimension;
    private Pad pad;
    private Coord startingPadPosition;
    private Coord startingBallPosition;
    private Vector startingBallPace;

    public ArenaImpl(final Dimension inputDimension) {
        this.brickMap = new HashMap<>();
        this.ballSet = new HashSet<>();
        this.powerupSet = new HashSet<>();
        this.dimension = inputDimension;

        this.powerupHandler = new PowerupHandlerImpl(this);
        this.registerComponent(new ArenaPhysicsComponent(this));
        this.registerComponent(new ArenaEventComponent(this));
    }

    /**
     * Calculates new {@link Pad}'s {@link Coord}.
     *
     * @param dx The value to add to the x value of the {@link Pad}'s {@link Coord}.
     * @return The new position of the {@link Pad}.
     */
    private Coord calcPadNewXCoord(final double dx) {
        final Coord updatedCoord = this.pad.getPosition();
        updatedCoord.sumXValue(dx);
        return updatedCoord;
    }
    /**
     * Modifies the {@link Pad}'s width dimension of a certain amount.
     *
     * @param amount The amount.
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
    /**
     * {@inheritDoc}
     */
    @Override
    public void addBall(final Ball ball) {
        if (Objects.isNull(this.startingBallPosition)) {
            this.startingBallPosition = ball.getPosition();
            this.startingBallPace = ball.getPace();
        }
        this.ballSet.add(ball);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void addBrick(final Brick brick) {
        if (this.brickMap.containsKey(brick.getPosition())) {
            throw new IllegalArgumentException("Can't insert the brick " + brick);
        }
        this.brickMap.put(brick.getPosition(), brick);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void addPowerup(final Powerup powerup) {
        this.powerupSet.add(powerup);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void cleanUp() {
        this.clearBalls();
        this.clearBricks();
        this.clearPowerups();
        this.powerupHandler.shutdown();
        this.getPad().removeComponent(EventComponent.class);
        this.removeComponent(EventComponent.class);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void clearBalls() {
        this.getBalls().forEach(this::removeBall);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void clearBricks() {
        this.getBricks().forEach(brick -> this.removeBrick(brick.getPosition()));
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void clearPowerups() {
        this.getPowerups().forEach(this::removePowerup);
        this.powerupSet.clear();
        this.powerupHandler.stop();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void decreasePadWidth(final double amount) {
        this.modifyPadWidth(-amount);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Ball> getBalls() {
        return Set.copyOf(this.ballSet);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Brick> getBricks() {
        return new HashSet<>(this.brickMap.values());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Dimension getDimension() {
        return this.dimension.copyOf();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getLastBallId() {
        return this.ballSet.stream()
                .mapToInt(Ball::getId)
                .max()
                .orElse(0);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Pad getPad() {
        return this.pad;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public PowerupHandler getPowerupHandler() {
        return this.powerupHandler;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Powerup> getPowerups() {
        return Set.copyOf(this.powerupSet);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Ball getRandomBall() {
        final List<Ball> ballList = new ArrayList<>(this.ballSet);
        Collections.shuffle(ballList);
        return ballList.get(0);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void increasePadWidth(final double amount) {
        this.modifyPadWidth(amount);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCleared() {
        return this.getBricks().stream().noneMatch(b -> b.getBrickType() != BrickType.INDESTRUCTIBLE);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void movePadLeft() {
        final Coord oldPosition = this.pad.getPosition();
        Coord newPosition = this.calcPadNewXCoord(-PAD_X_MOVEMENT);
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
    /**
     * {@inheritDoc}
     */
    @Override
    public void movePadRight() {
        final Coord oldPosition = this.pad.getPosition();
        Coord newPosition = this.calcPadNewXCoord(PAD_X_MOVEMENT);
        final double maxX = this.dimension.getWidth() - this.pad.getDimension().getWidth() / 2;
        if (newPosition.getX() > maxX) {
            final double yCoord = this.pad.getPosition().getY();
            newPosition = new CoordImpl(maxX, yCoord);
        }
        this.pad.setPosition(newPosition);
        final boolean anyCollsion = this.getBalls().stream()
                .anyMatch(b -> b.getHitbox().isCollidingWithHB(this.pad.getHitbox()));
        if (anyCollsion) {
            this.pad.setPosition(oldPosition);
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void removeBall(final Ball ball) {
        this.ballSet.remove(ball);
        if (ball.hasComponent(EventComponent.class)) {
            ball.removeComponent(EventComponent.class);
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void removeBrick(final Coord brickCoord) {
        final Brick removedBrick = this.brickMap.remove(brickCoord);
        if (removedBrick.hasComponent(EventComponent.class)) {
            removedBrick.removeComponent(EventComponent.class);
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void removePowerup(final Powerup powerup) {
        this.powerupSet.remove(powerup);
        if (EventBus.getDefault().isRegistered(powerup)) {
            EventBus.getDefault().unregister(powerup);
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void resetStartingPosition() {
        final ElementFactory factory = new ElementFactoryImpl();
        this.getPad().setPosition(this.startingPadPosition.copyOf());
        final double compX = Math.pow(this.startingBallPace.getX(), 2);
        final double compY = Math.pow(this.startingBallPace.getY(), 2);
        final double module = Math.sqrt(compX + compY);
        System.out.println(module);
        this.ballSet.clear();
        this.ballSet.add(factory.createBallWithRandomPace(1, BallType.NORMAL_BALL, this.startingBallPosition.copyOf(), module));
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setPad(final Pad inputPad) {
        if (Objects.isNull(this.startingPadPosition)) {
            this.startingPadPosition = inputPad.getPosition();
        }
        this.pad = inputPad;
    }
    /**
     * {@inheritDoc}
     */
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
    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double delta) {
        this.getComponent(PhysicsComponent.class).update(delta);
    }
}
