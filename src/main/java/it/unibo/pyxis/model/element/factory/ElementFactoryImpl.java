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

public final class ElementFactoryImpl implements ElementFactory {

    @Override
    public Brick createBrickFromType(final BrickType type, final Coord position) {
        return new BrickImpl(type, position);
    }

    @Override
    public Brick createRedBrick(final Coord position) {
        return this.createBrickFromType(BrickType.RED, position);
    }

    @Override
    public Brick createOrangeBrick(final Coord position) {
        return this.createBrickFromType(BrickType.ORANGE, position);
    }

    @Override
    public Brick createYellowBrick(final Coord position) {
        return this.createBrickFromType(BrickType.YELLOW, position);
    }

    @Override
    public Brick createGreenBrick(final Coord position) {
        return this.createBrickFromType(BrickType.GREEN, position);
    }

    @Override
    public Brick createBlueBrick(final Coord position) {
        return this.createBrickFromType(BrickType.BLUE, position);
    }

    @Override
    public Brick createPurpleBrick(final Coord position) {
        return this.createBrickFromType(BrickType.PURPLE, position);
    }

    @Override
    public Brick createIndestructibleBrick(final Coord position) {
        return this.createBrickFromType(BrickType.INDESTRUCTIBLE, position);
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
    public Pad createPad(final Dimension dimension, final Coord position) {
        return new PadImpl(dimension, position);
    }

    @Override
    public Pad createDefaultPad(final Coord position) {
        return new PadImpl(position);
    }

    @Override
    public Ball copyBallWithAngle(final Ball ball, final double angle, final int id) {
        return this.copyBallWithType(ball, angle, id, ball.getType());
    }
}
