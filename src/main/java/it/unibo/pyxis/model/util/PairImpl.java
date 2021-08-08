package it.unibo.pyxis.model.util;

import java.util.Objects;

public final class PairImpl<T> implements Pair<T> {

    private T first;
    private T second;

    public PairImpl(final T inFirst, final T inSecond) {
        this.first = inFirst;
        this.second = inSecond;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PairImpl)) {
            return false;
        }
        final PairImpl<?> pair = (PairImpl<?>) o;
        return this.getFirst().equals(pair.getFirst()) && this.getSecond().equals(pair.getSecond());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public T getFirst() {
        return this.first;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public T getSecond() {
        return this.second;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getFirst(), this.getSecond());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setFirst(final T firstValue) {
        this.first = firstValue;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setSecond(final T secondValue) {
        this.second = secondValue;
    }
}
