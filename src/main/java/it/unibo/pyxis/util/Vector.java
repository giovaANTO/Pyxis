package it.unibo.pyxis.util;

public interface Vector {

    /**
     * Returns vector's components.
     * @return
     *          The {@link Pair}
     */
    Pair<Double> getComponents();

    /**
     * Returns vector's module.
     * @return
     *          Value of the module
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
