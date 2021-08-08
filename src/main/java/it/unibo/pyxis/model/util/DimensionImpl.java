package it.unibo.pyxis.model.util;

import java.util.Objects;

public final class DimensionImpl implements Dimension {

    private final Pair<Double> internalPair;

    public DimensionImpl(final double width, final double height) {
        this.internalPair = new PairImpl<>(width, height);
    }

    public DimensionImpl() {
        this(0, 0);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Dimension copyOf() {
        return new DimensionImpl(this.getWidth(), this.getHeight());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DimensionImpl)) {
            return false;
        }
        final DimensionImpl dimension = (DimensionImpl) o;
        return Objects.equals(this.internalPair, dimension.internalPair);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public double getHeight() {
        return this.internalPair.getSecond();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public double getWidth() {
        return this.internalPair.getFirst();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(internalPair);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void increaseHeight(final double increaseValue) {
        this.setHeight(this.getHeight() + increaseValue);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void increaseWidth(final double increaseValue) {
        System.out.println("DimensionImpl - Increasing starting width: " + this.getWidth() + " with " + increaseValue);
        this.setWidth(this.getWidth() + increaseValue);
        System.out.println("DimensionImpl - After increase: " + this.getWidth());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setHeight(final double height) {
        this.internalPair.setSecond(height);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setWidth(final double width) {
        this.internalPair.setFirst(width);
    }
    /**
     * Return a string representing the current object's state.
     *
     * @return The string representing the current object's state.
     */
    public String toString() {
        return "Dimension X: " + this.internalPair.getFirst() + " and Y: " + this.internalPair.getSecond();
    }
}
