package it.unibo.pyxis.util;

public interface Vector {

    /**
     * Returns vector's components.
     * @return
     *          The {@link Pair} components to return
     */
    Pair<Double> getComponents();

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
