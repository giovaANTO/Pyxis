package it.unibo.pyxis.util;

public interface Vector {

    /**
     * Returns vector's x component.
     * @return
     *          The x component
     */
    double getX();

    /**
     * Returns vector's y component.
     * @return
     *          The y component
     */
    double getY();

    /**
     * Returns vector's module.
     * @return
     *          The module's value
     */
    double getModule();

    /**
     * Sets vector's components.
     * @param components
     *          The {@link Pair} components x, y
     */
    void setComponents(Pair<Double> components);

    /**
     * Return a copy of the vector.
     * @return
     *          The {@link Vector} copy
     */
    Vector copyOf();
}
