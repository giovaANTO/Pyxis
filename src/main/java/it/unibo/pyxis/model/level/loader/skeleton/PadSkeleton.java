package it.unibo.pyxis.model.level.loader.skeleton;

public interface PadSkeleton {
    /**
     * Return the x coordinate of the {@link it.unibo.pyxis.model.element.pad.Pad}.
     * @return
     *          The value of x coordinate of the {@link it.unibo.pyxis.model.element.pad.Pad}
     */
    double getX();

    /**
     * Set the x coordinate of the {@link it.unibo.pyxis.model.element.pad.Pad}.
     * @param x
     *          The x value to set
     */
    void setX(double x);

    /**
     * Return the y coordinate of the {@link it.unibo.pyxis.model.element.pad.Pad}.
     * @return
     *          The value of y coordinate of the {@link it.unibo.pyxis.model.element.pad.Pad}
     */
    double getY();

    /**
     * Set the y coordinate of the {@link it.unibo.pyxis.model.element.pad.Pad}.
     * @param y
     *          The y value to set
     */
    void setY(double y);
}
