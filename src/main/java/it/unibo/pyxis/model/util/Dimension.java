package it.unibo.pyxis.model.util;

public interface Dimension {
    /**
     * Returns the {@link Dimension} copy.
     *
     * @return The {@link Dimension}.
     */
    Dimension copyOf();
    /**
     * Returns the height of the {@link it.unibo.pyxis.model.element.Element}.
     *
     * @return The height value.
     */
    double getHeight();
    /**
     * Returns the width of the {@link it.unibo.pyxis.model.element.Element}.
     *
     * @return The width value.
     */
    double getWidth();
    /**
     * Increases the height value.
     *
     * @param increaseValue The height value to add.
     */
    void increaseHeight(double increaseValue);
    /**
     * Increases the width value.
     *
     * @param increaseValue The width value to add.
     */
    void increaseWidth(double increaseValue);
    /**
     * Sets the height value.
     *
     * @param height The height value to set.
     */
    void setHeight(double height);
    /**
     * Sets the width value.
     *
     * @param width The width value to set.
     */
    void setWidth(double width);
}
