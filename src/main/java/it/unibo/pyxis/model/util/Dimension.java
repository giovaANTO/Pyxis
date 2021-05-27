package it.unibo.pyxis.model.util;

public interface Dimension {

    /**
     * Returns the width of the element.
     * @return
     *          The width value
     */
    double getWidth();

    /**
     * Returns the height of the element.
     * @return
     *          The height value
     */
    double getHeight();

    /**
     * Sets the width value.
     * @param width
     *          The width value
     */
    void setWidth(double width);

    /**
     * Sets the height value.
     * @param height
     *          The height value
     */
    void setHeight(double height);

    /**
     * Increases the width value.
     * @param increaseValue
     *          The increment value
     */
    void increaseWidth(double increaseValue);

    /**
     * Increases the height value
     * @param increaseValue
     *          The increment value
     */
    void increaseHeight(double increaseValue);

    /**
     * Returns the {@link Dimension} copy.
     * @return
     *          The {@link Dimension}
     */
    Dimension copyOf();
}
