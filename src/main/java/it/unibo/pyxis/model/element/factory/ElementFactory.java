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
     * Creates a copy of a {@link Ball} maintaining the same properties of this but
     * with the {@link it.unibo.pyxis.model.util.Vector} pace rotated by a certain
     * angle.
     *
     * @param ball The {@link Ball} to copy.
     * @param angle The angle to apply to the {@link Ball}'s
     *              {@link it.unibo.pyxis.model.util.Vector} pace.
     * @param id The id to assign to the new {@link Ball}.
     * @return A new {@link Ball} instance.
     */
    Ball copyBallWithAngle(Ball ball, double angle, int id);
    /**
     * Creates a copy of a {@link Ball} maintaining the same properties of this but
     * with the {@link it.unibo.pyxis.model.util.Vector} pace rotated by a random
     * angle.
     *
     * @param ball The {@link Ball} to copy.
     * @param id The id to assign to the new {@link Ball}.
     * @return A new {@link Ball} instance.
     */
    Ball copyBallWithRandomAngle(Ball ball, int id);
    /**
     * Creates a copy of a {@link Ball} maintaining the same properties of this but
     * with the {@link it.unibo.pyxis.model.util.Vector} pace rotated by a certain
     * angle and with a specified angle.
     *
     * @param ball The {@link Ball} to copy.
     * @param angle The angle to apply to the {@link Ball}
     *              {@link it.unibo.pyxis.model.util.Vector} pace.
     * @param id The id to assign to the new {@link Ball}.
     * @param type The type of {@link Ball} to assign.
     * @return A new {@link Ball} instance.
     */
    Ball copyBallWithType(Ball ball, double angle, int id, BallType type);
    /**
     * Creates a new {@link Ball} with a random pace {@link it.unibo.pyxis.model.util.Vector}.
     *
     * @param id  The id of the {@link Ball}
     * @param type The {@link BallType} to assign
     * @param position The initial position of the {@link Ball}
     * @param module The module of the pace's
     *               {@link it.unibo.pyxis.model.util.Vector}
     * @return
     *          A new {@link Ball} instance.
     */
    Ball createBallWithRandomAngle(int id, BallType type, Coord position, double module);
    /**
     * Creates a {@link Brick} of blue {@link BrickType}.
     *
     * @param position The {@link Brick} position's {@link Coord}.
     * @return The new {@link Brick} instance.
     */
    Brick createBlueBrick(Coord position);
    /**
     * Creates a {@link Brick} of a given {@link BrickType}.
     *
     * @param type The {@link BrickType} to assign to the new {@link Brick}.
     * @param position The {@link Coord} position of the {@link Brick}.
     * @return The new {@link Brick} instance.
     */
    Brick createBrickFromType(BrickType type, Coord position);
    /**
     * Creates a {@link Pad} with default {@link Dimension}.
     *
     * @param position The {@link Coord} of the {@link Pad}.
     * @return A new {@link Pad} instance.
     */
    Pad createDefaultPad(Coord position);
    /**
     * Creates a {@link Brick} of green {@link BrickType}.
     *
     * @param position The {@link Brick} position's {@link Coord}.
     * @return The new {@link Brick} instance.
     */
    Brick createGreenBrick(Coord position);
    /**
     * Creates a {@link Brick} of indestructible {@link BrickType}.
     *
     * @param position The {@link Brick} position's {@link Coord}.
     * @return The new {@link Brick} instance.
     */
    Brick createIndestructibleBrick(Coord position);
    /**
     * Creates a {@link Brick} of orange {@link BrickType}.
     *
     * @param position The {@link Brick} position's {@link Coord}.
     * @return The new {@link Brick} instance.
     */
    Brick createOrangeBrick(Coord position);
    /**
     * Creates a new {@link Pad}.
     *
     * @param dimension The {@link Dimension} of the {@link Pad}.
     * @param position The {@link Coord} of the {@link Pad}.
     * @return A new {@link Pad} instance.
     */
    Pad createPad(Dimension dimension, Coord position);
    /**
     * Creates a {@link Brick} of purple {@link BrickType}.
     * @param position The {@link Brick} position's {@link Coord}.
     * @return The new {@link Brick} instance.
     */
    Brick createPurpleBrick(Coord position);
    /**
     * Creates a {@link Brick} of red {@link BrickType}.
     * @param position The {@link Brick} position's {@link Coord}.
     * @return The new {@link Brick} instance.
     */
    Brick createRedBrick(Coord position);
    /**
     * Creates a {@link Brick} of yellow {@link BrickType}.
     * @param position The {@link Brick} position's {@link Coord}.
     * @return The new {@link Brick} instance.
     */
    Brick createYellowBrick(Coord position);
}
