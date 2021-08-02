package it.unibo.pyxis.model.element.factory;

import it.unibo.pyxis.model.element.ball.Ball;
import it.unibo.pyxis.model.element.ball.BallImpl;
import it.unibo.pyxis.model.element.ball.BallType;
import it.unibo.pyxis.model.element.brick.Brick;
import it.unibo.pyxis.model.element.brick.BrickImpl;
import it.unibo.pyxis.model.element.brick.BrickType;
import it.unibo.pyxis.model.util.Coord;

public final class ElementFactoryImpl implements ElementFactory {

    /**
     * Create a new {@link Brick} specifying a {@link BrickType}.
     * @param type
     *              The type of {@link Brick} that should be created
     * @param position
     *              A {@link Coord} indicating the {@link Brick} position
     * @return
     *          A new {@link Brick}
     */
    private Brick brickFromType(final BrickType type, final Coord position) {
        return new BrickImpl(type, position);
    }

    @Override
    public Brick createRedBrick(final Coord position) {
        return this.brickFromType(BrickType.RED, position);
    }

    @Override
    public Brick createOrangeBrick(final Coord position) {
        return this.brickFromType(BrickType.ORANGE, position);
    }

    @Override
    public Brick createYellowBrick(final Coord position) {
        return this.brickFromType(BrickType.YELLOW, position);
    }

    @Override
    public Brick createGreenBrick(final Coord position) {
        return this.brickFromType(BrickType.GREEN, position);
    }

    @Override
    public Brick createBlueBrick(final Coord position) {
        return this.brickFromType(BrickType.BLUE, position);
    }

    @Override
    public Brick createPurpleBrick(final Coord position) {
        return this.brickFromType(BrickType.PURPLE, position);
    }

    @Override
    public Brick createIndestructibleBrick(final Coord position) {
        return this.brickFromType(BrickType.INDESTRUCTIBLE, position);
    }

    @Override
    public Ball copyBallWithType(final Ball ball, final double angle, final int id, final BallType type) {
        return new BallImpl.Builder()
                .ballType(type)
                .id(id)
                .pace(ball.getPace().rotationBy(angle))
                .initialPosition(ball.getPosition())
                .build();
    }

    @Override
    public Ball copyBallWithAngle(final Ball ball, final double angle, final int id) {
        return this.copyBallWithType(ball, angle, id, ball.getType());
    }
}
