package it.unibo.pyxis.model.level.loader.skeleton.pad;

public interface PadSkeleton {
    /**
     * Returns the X {@link it.unibo.pyxis.model.util.Coord} of the
     * {@link it.unibo.pyxis.model.element.pad.Pad}.
     *
     * @return The value of the X {@link it.unibo.pyxis.model.util.Coord}
     *         of the {@link it.unibo.pyxis.model.element.pad.Pad}.
     */
    double getX();
    /**
     * Returns the Y {@link it.unibo.pyxis.model.util.Coord} of the
     * {@link it.unibo.pyxis.model.element.pad.Pad}.
     *
     * @return The value of the Y {@link it.unibo.pyxis.model.util.Coord} of the
     *         {@link it.unibo.pyxis.model.element.pad.Pad}.
     */
    double getY();
    /**
     * Sets the X {@link it.unibo.pyxis.model.util.Coord} of the
     * {@link it.unibo.pyxis.model.element.pad.Pad}.
     *
     * @param x The X {@link it.unibo.pyxis.model.util.Coord} value to set.
     */
    void setX(double x);
    /**
     * Sets the Y {@link it.unibo.pyxis.model.util.Coord} of the
     * {@link it.unibo.pyxis.model.element.pad.Pad}.
     *
     * @param y The Y {@link it.unibo.pyxis.model.util.Coord} to set.
     */
    void setY(double y);
}
