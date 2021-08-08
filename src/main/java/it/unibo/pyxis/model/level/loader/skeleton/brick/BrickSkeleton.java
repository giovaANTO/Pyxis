package it.unibo.pyxis.model.level.loader.skeleton.brick;


public interface BrickSkeleton {
    /**
     * Returns the string representing the type of the {@link it.unibo.pyxis.model.element.brick.Brick}.
     *
     * @return A {@link String} representing the {@link it.unibo.pyxis.model.element.brick.Brick} type.
     */
    String getType();
    /**
     * Returns the X {@link it.unibo.pyxis.model.util.Coord} of the
     * {@link it.unibo.pyxis.model.element.brick.Brick}.
     *
     * @return The value of X {@link it.unibo.pyxis.model.util.Coord} of the
     *         {@link it.unibo.pyxis.model.element.brick.Brick}.
     */
    double getX();
    /**
     * Returns the Y {@link it.unibo.pyxis.model.util.Coord} of the
     * {@link it.unibo.pyxis.model.element.brick.Brick}.
     *
     * @return The value of Y {@link it.unibo.pyxis.model.util.Coord} of the
     *         {@link it.unibo.pyxis.model.element.brick.Brick}.
     */
    double getY();
    /**
     * Sets the {@link it.unibo.pyxis.model.element.brick.BrickType} of the
     * {@link it.unibo.pyxis.model.element.brick.Brick}.
     *
     * @param type A {@link String} containing the type of a
     *             {@link it.unibo.pyxis.model.element.brick.Brick}.
     */
    void setType(String type);
    /**
     * Sets the X {@link it.unibo.pyxis.model.util.Coord} of the
     * {@link it.unibo.pyxis.model.element.brick.Brick}.
     *
     * @param x The X {@link it.unibo.pyxis.model.util.Coord} value to set.
     */
    void setX(double x);
    /**
     * Sets the y coordinate of the {@link it.unibo.pyxis.model.element.brick.Brick}.
     *
     * @param y The Y {@link it.unibo.pyxis.model.util.Coord} value to set.
     */
    void setY(double y);
}
