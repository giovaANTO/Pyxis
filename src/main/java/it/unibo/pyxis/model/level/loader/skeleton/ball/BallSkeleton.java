package it.unibo.pyxis.model.level.loader.skeleton.ball;

public interface BallSkeleton {
    /**
     * Returns the string representing the
     * {@link it.unibo.pyxis.model.element.ball.BallType}.
     *
     * @return A string containing the {@link it.unibo.pyxis.model.element.ball.BallType}
     *  of the {@link it.unibo.pyxis.model.element.ball.Ball}.
     */
    String getBallType();
    /**
     * Returns the ID of the {@link it.unibo.pyxis.model.element.ball.Ball}.
     *
     * @return The integer representing the
     * {@link it.unibo.pyxis.model.element.ball.Ball} ID.
     */
    int getId();
    /**
     * Returns the X component of the {@link it.unibo.pyxis.model.element.ball.Ball}'s
     * pace {@link it.unibo.pyxis.model.util.Vector}.
     *
     * @return The X component of the pace {@link it.unibo.pyxis.model.util.Vector}
     * of the {@link it.unibo.pyxis.model.element.ball.Ball}.
     */
    int getPaceX();
    /**
     * Returns the Y component of the {@link it.unibo.pyxis.model.element.ball.Ball}'s
     * pace {@link it.unibo.pyxis.model.util.Vector}.
     *
     * @return The Y component of the pace {@link it.unibo.pyxis.model.util.Vector}
     * of the {@link it.unibo.pyxis.model.element.ball.Ball}.
     */
    int getPaceY();
    /**
     * Returns the X {@link it.unibo.pyxis.model.util.Coord} of the
     * {@link it.unibo.pyxis.model.element.ball.Ball}.
     *
     * @return The X {@link it.unibo.pyxis.model.util.Coord}.
     */
    int getX();
    /**
     * Returns the Y {@link it.unibo.pyxis.model.util.Coord} of the
     * {@link it.unibo.pyxis.model.element.ball.Ball}.
     *
     * @return The Y {@link it.unibo.pyxis.model.util.Coord}.
     */
    int getY();
    /**
     * Sets the {@link it.unibo.pyxis.model.element.ball.BallType} of the
     * {@link it.unibo.pyxis.model.element.ball.Ball}.
     *
     * @param ballType A String which value represent a
     *                 {@link it.unibo.pyxis.model.element.ball.BallType}.
     */
    void setBallType(String ballType);
    /**
     * Sets the ID of the {@link it.unibo.pyxis.model.element.ball.Ball}.
     *
     * @param id The ID of the {@link it.unibo.pyxis.model.element.ball.Ball}.
     */
    void setId(int id);
    /**
     * Sets the X component of the {@link it.unibo.pyxis.model.element.ball.Ball}'s
     * pace {@link it.unibo.pyxis.model.util.Vector}.
     *
     * @param x The X component of the pace {@link it.unibo.pyxis.model.util.Vector}
     *          of the {@link it.unibo.pyxis.model.element.ball.Ball} to set.
     */
    void setPaceX(int x);
    /**
     * Sets the Y component of the {@link it.unibo.pyxis.model.element.ball.Ball}'s
     * pace {@link it.unibo.pyxis.model.util.Vector}.
     *
     * @param y The Y component of the pace {@link it.unibo.pyxis.model.util.Vector}
     *          of the {@link it.unibo.pyxis.model.element.ball.Ball}.
     */
    void setPaceY(int y);
    /**
     * Sets the X {@link it.unibo.pyxis.model.util.Coord} of the
     * {@link it.unibo.pyxis.model.element.ball.Ball}.
     *
     * @param x The integer representing the X {@link it.unibo.pyxis.model.util.Coord}.
     */
    void setX(int x);
    /**
     * Sets the Y {@link it.unibo.pyxis.model.util.Coord} of the
     * {@link it.unibo.pyxis.model.element.ball.Ball}.
     *
     * @param y The integer representing the Y {@link it.unibo.pyxis.model.util.Coord}.
     */
    void setY(int y);
}
