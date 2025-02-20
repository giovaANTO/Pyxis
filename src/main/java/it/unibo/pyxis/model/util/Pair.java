package it.unibo.pyxis.model.util;

public interface Pair<T> {
    /**
     * Returns the pair's first value.
     *
     * @return The first value.
     */
    T getFirst();
    /**
     * Returns the pair's second value.
     *
     * @return The second value.
     */
    T getSecond();
    /**
     * Sets the pair's first value.
     *
     * @param firstValue The value to set.
     */
    void setFirst(T firstValue);
    /**
     * Set's the pair's second value.
     *
     * @param secondValue The value to set.
     */
    void setSecond(T secondValue);
}
