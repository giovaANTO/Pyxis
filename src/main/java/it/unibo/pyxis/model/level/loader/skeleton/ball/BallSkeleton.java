package it.unibo.pyxis.model.level.loader.skeleton.ball;

public interface BallSkeleton {
    /**
     * Return the x coordinate of the {@link it.unibo.pyxis.model.element.ball.Ball}.
     * @return
     *          The x coordinate.
     */
    int getX();

    /**
     * Set the x coordinate of the {@link it.unibo.pyxis.model.element.ball.Ball}.
     * @param x
     *          The integer representing the x coord.
     */
    void setX(int x);

    /**
     * Return the y coordinate of the {@link it.unibo.pyxis.model.element.ball.Ball}.
     * @return
     *          The y coordinate
     */
    int getY();

    /**
     * Set the y coordinate of the {@link it.unibo.pyxis.model.element.ball.Ball}.
     * @param y
     *          The integer rapresenting the y coord.
     */
    void setY(int y);

    /**
     * Return the string representing the {@link it.unibo.pyxis.model.element.ball.BallType}.
     * @return
     *         A string containing the type of the ball.
     */
    String getBallType();

    /**
     * Set the type of the {@link it.unibo.pyxis.model.element.ball.Ball}.
     * @param ballType
     *                  A String which value rappresent a {@link it.unibo.pyxis.model.element.ball.BallType}.
     */
    void setBallType(String ballType);

    /**
     * Return the ID of the {@link it.unibo.pyxis.model.element.ball.Ball}.
     * @return
     *          The integer representing the {@link it.unibo.pyxis.model.element.ball.Ball} ID
     */
    int getId();

    /**
     * Set the ID of the {@link it.unibo.pyxis.model.element.ball.Ball}.
     * @param id
     *            The ID of the ball
     */
    void setId(int id);

    /**
     * Return the x coordinate of the {@link it.unibo.pyxis.model.element.ball.Ball} pace.
     * @return
     *          The x coordinate of the pace {@link it.unibo.pyxis.model.util.Vector} of the {@link it.unibo.pyxis.model.element.ball.Ball}.
     */
    int getPaceX();

    /**
     * Set the x coordinate of the {@link it.unibo.pyxis.model.element.ball.Ball} pace.
     * @param x
     *          The x coordinate of the pace {@link it.unibo.pyxis.model.util.Vector} of the {@link it.unibo.pyxis.model.element.ball.Ball}.
     */
    void setPaceX(int x);

    /**
     * Return the y coordinate of the {@link it.unibo.pyxis.model.element.ball.Ball} pace.
     * @return
     *          The y coordinate of the pace {@link it.unibo.pyxis.model.util.Vector} of the {@link it.unibo.pyxis.model.element.ball.Ball}.
     */
    int getPaceY();

    /**
     * Set the y coordinate of the {@link it.unibo.pyxis.model.element.ball.Ball} pace.
     * @param y
     *          The y coordinate of the pace {@link it.unibo.pyxis.model.util.Vector} of the {@link it.unibo.pyxis.model.element.ball.Ball}.
     */
    void setPaceY(int y);
}
