package it.unibo.pyxis.util;

public interface Pair<T> {

    void setFirst(T firstValue);

    void setSecond(T secondValue);

    T getFirst();

    T getSecond();
}
