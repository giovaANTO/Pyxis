package it.unibo.pyxis.model.element.factory;

import it.unibo.pyxis.model.element.ball.Ball;
import it.unibo.pyxis.model.element.ball.BallType;
import it.unibo.pyxis.model.element.brick.Brick;
import it.unibo.pyxis.model.element.brick.BrickType;
import it.unibo.pyxis.model.element.pad.Pad;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;


public interface ElementFactory {
    /**
     * Create a copy of a {@link Ball} maintaining the same properties of this but with the pace
     * rotated by a certain angle.
     *
     * @param ball
     *              The {@link Ball} to copy.
     * @param angle
     *              The angle to apply to the {@link Ball} pace.
     * @param id
     *              The id to assign to the new ball.
     * @return
     *              A new {@link Ball} instance
     */
    Ball copyBallWithAngle(Ball ball, double angle, int id);
    /**
     * Create a copy of a {@link Ball} maintaining the same properties of this but with the pace
     * rotated by a certain angle and with a specified angle.
     *
     * @param ball
     *              The {@link Ball} to copy.
     * @param angle
     *              The angle to apply to the {@link Ball} pace.
     * @param id
     *              The id to assign to the new ball.
     * @param type
     *              The type of {@link Ball} to assign.
     * @return
     *              A new {@link Ball} instance
     */
    Ball copyBallWithType(Ball ball, double angle, int id, BallType type);
    /**
     * Create a {@link Brick} of blue type.
     * @param position
     *                  The {@link Brick} positions's {@link Coord}
     * @return
     *                  The new {@link Brick} instance
     */
    Brick createBlueBrick(Coord position);
    /**
     * Create a {@link Brick} of a given type.
     * @param type
     *              The {@link BrickType} to assign to the new {@link Brick}
     * @param position
     *              The {@link Coord} position of the {@link Brick}
     * @return
     *              The new {@link Brick} instance
     */
    Brick createBrickFromType(BrickType type, Coord position);
    /**
     * Create a {@link Pad} with default dimensions.
     * @param position
     *                 The {@link Coord} of the {@link Pad}
     * @return
     *          A new {@link Pad} instance.
     */
    Pad createDefaultPad(Coord position);
    /**
     * Create a {@link Brick} of green type.
     * @param position
     *                  The {@link Brick} positions's {@link Coord}
     * @return
     *                  The new {@link Brick} instance
     */
    Brick createGreenBrick(Coord position);
    /**
     * Create a {@link Brick} of indestructible type.
     * @param position
     *                  The {@link Brick} positions's {@link Coord}
     * @return
     *                  The new {@link Brick} instance
     */
    Brick createIndestructibleBrick(Coord position);
    /**
     * Create a {@link Brick} of orange type.
     * @param position
     *                  The {@link Brick} positions's {@link Coord}
     * @return
     *                  The new {@link Brick} instance
     */
    Brick createOrangeBrick(Coord position);
    /**
     * Create a new {@link Pad}.
     * @param dimension
     *                  The {@link Dimension} of the {@link Pad}
     * @param position
     *                  The {@link Coord} of the {@link Pad}
     *
     * @return
     *          A new {@link Pad} instance.
     */
    Pad createPad(Dimension dimension, Coord position);
    /**
     * Create a {@link Brick} of purple type.
     * @param position
     *                  The {@link Brick} positions's {@link Coord}
     * @return
     *                  The new {@link Brick} instance
     */
    Brick createPurpleBrick(Coord position);
    /**
     * Create a {@link Brick} of red type.
     * @param position
     *                  The {@link Brick} positions's {@link Coord}
     * @return
     *                  The new {@link Brick} instance
     */
    Brick createRedBrick(Coord position);
    /**
     * Create a {@link Brick} of yellow type.
     * @param position
     *                  The {@link Brick} positions's {@link Coord}
     * @return
     *                  The new {@link Brick} instance
     */
    Brick createYellowBrick(Coord position);
}
