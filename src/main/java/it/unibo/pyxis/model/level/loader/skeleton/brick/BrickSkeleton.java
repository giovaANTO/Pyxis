package it.unibo.pyxis.model.level.loader.skeleton.brick;


public interface BrickSkeleton {
    /**
     * Return the string representing the type of the {@link it.unibo.pyxis.model.element.brick.Brick}.
     * @return
     *          A {@link String} representing the {@link it.unibo.pyxis.model.element.brick.Brick} type.
     */
    String getType();

    /**
     * Set the type of the {@link it.unibo.pyxis.model.element.brick.Brick}.
     * @param type
     *          A {@link String} containing the type of a {@link it.unibo.pyxis.model.element.brick.Brick}
     */
    void setType(String type);

    /**
     * Return the x coordinate of the {@link it.unibo.pyxis.model.element.brick.Brick}.
     * @return
     *          The value of x coordinate of the {@link it.unibo.pyxis.model.element.brick.Brick}
     */
    double getX();

    /**
     * Set the x coordinate of the {@link it.unibo.pyxis.model.element.brick.Brick}.
     * @param x
     *          The y value to set
     */
    void setX(double x);

    /**
     * Return the y coordinate of the {@link it.unibo.pyxis.model.element.brick.Brick}.
     * @return
     *          The value of y coordinate of the {@link it.unibo.pyxis.model.element.brick.Brick}
     */
    double getY();

    /**
     * Set the y coordinate of the {@link it.unibo.pyxis.model.element.brick.Brick}.
     * @param y
     *          The y value to set
     */
    void setY(double y);
}
