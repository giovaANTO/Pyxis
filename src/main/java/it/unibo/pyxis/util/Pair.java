package it.unibo.pyxis.util;

public interface Pair<T> {

    /**
     * Sets the pair's first value.
     * @param firstValue
     *          The value to set
     */
    void setFirst(T firstValue);

    /**
     * Set's the pair's second value.
     * @param secondValue
     *          The value to set
     */
    void setSecond(T secondValue);

    /**
     * Returns the pair's first value.
     * @return
     *          The first value
     */
    T getFirst();

    /**
     * Returns the pai's second value
     * @return
     *          The second value
     */
    T getSecond();
}
