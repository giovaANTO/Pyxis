package it.unibo.pyxis.util;

public interface Vector {

    /**
     * Returns vector's components.
     * @return
     */
    Pair<Double> getComponents();

    /**
     * Returns vector's module.
     * @return
     */
    double getModule();

    /**
     * Sets vector's components.
     * @param components
     */
    void setComponents(Pair<Double> components);
}
