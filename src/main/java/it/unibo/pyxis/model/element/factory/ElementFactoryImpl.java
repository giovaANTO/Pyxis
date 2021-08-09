package it.unibo.pyxis.model.element.factory;

import it.unibo.pyxis.model.element.ball.Ball;
import it.unibo.pyxis.model.element.ball.BallImpl;
import it.unibo.pyxis.model.element.ball.BallType;
import it.unibo.pyxis.model.element.brick.Brick;
import it.unibo.pyxis.model.element.brick.BrickImpl;
import it.unibo.pyxis.model.element.brick.BrickType;
import it.unibo.pyxis.model.element.pad.Pad;
import it.unibo.pyxis.model.element.pad.PadImpl;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.Vector;
import it.unibo.pyxis.model.util.VectorImpl;

import java.util.Random;

public final class ElementFactoryImpl implements ElementFactory {

    private static final double MIN_ANGLE = -40;
    private static final double MAX_ANGLE = 40;

    /**
     * Generate a random angle between two values.
     * @return a dobule representing the value of an angle.
     */
    private double randomAngle() {
        Random random = new Random();
        return MIN_ANGLE + (MAX_ANGLE - MIN_ANGLE) * random.nextDouble();
    }
    /**
     * Creates a new pace {@link Vector} with a random angle direction.
     * @param module The module of the {@link Vector}
     * @return A new {@link Vector} instance.
     */
    private Vector paceWithRandomAngle(final double module) {
        final double randomAngle = this.randomAngle();
        final double componentX = module * Math.cos(randomAngle);
        final double componentY = module * Math.sin(randomAngle);
        return new VectorImpl(componentX, componentY);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Ball copyBallWithType(final Ball ball, final double angle, final int id, final BallType type) {
        return new BallImpl.Builder()
                .ballType(type)
                .id(id)
                .pace(ball.getPace().rotationBy(angle))
                .initialPosition(ball.getPosition())
                .build();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Ball createBallWithRandomPace(final int id, final BallType type, final Coord pos, final double module) {
        return new BallImpl.Builder()
                .ballType(type)
                .id(id)
                .pace(this.paceWithRandomAngle(module))
                .initialPosition(pos)
                .build();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Ball copyBallWithAngle(final Ball ball, final double angle, final int id) {
        return this.copyBallWithType(ball, angle, id, ball.getType());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Ball copyBallWithRandomAngle(final Ball ball, final int id) {
        return this.copyBallWithAngle(ball, this.randomAngle(), id);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Brick createBlueBrick(final Coord position) {
        return this.createBrickFromType(BrickType.BLUE, position);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Brick createBrickFromType(final BrickType type, final Coord position) {
        return new BrickImpl(type, position);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Pad createDefaultPad(final Coord position) {
        return new PadImpl(position);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Brick createGreenBrick(final Coord position) {
        return this.createBrickFromType(BrickType.GREEN, position);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Brick createIndestructibleBrick(final Coord position) {
        return this.createBrickFromType(BrickType.INDESTRUCTIBLE, position);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Brick createOrangeBrick(final Coord position) {
        return this.createBrickFromType(BrickType.ORANGE, position);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Pad createPad(final Dimension dimension, final Coord position) {
        return new PadImpl(dimension, position);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Brick createPurpleBrick(final Coord position) {
        return this.createBrickFromType(BrickType.PURPLE, position);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Brick createRedBrick(final Coord position) {
        return this.createBrickFromType(BrickType.RED, position);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Brick createYellowBrick(final Coord position) {
        return this.createBrickFromType(BrickType.YELLOW, position);
    }
}
