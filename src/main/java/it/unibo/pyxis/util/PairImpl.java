package it.unibo.pyxis.util;

public class PairImpl<T> implements Pair<T> {

    private T first;

    private T second;

    public PairImpl(final T inFirst, final T inSecond) {
        this.first = inFirst;
        this.second = inSecond;
    }

    @Override
    public void setFirst(T firstValue) {
        this.first = firstValue;
    }

    @Override
    public void setSecond(T secondValue) {
        this.second = secondValue;
    }

    @Override
    public T getFirst() {
        return this.first;
    }

    @Override
    public T getSecond() {
        return this.second;
    }
}
