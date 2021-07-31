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

    @Override
    public double getWidth() {
        return this.internalPair.getFirst();
    }

    @Override
    public double getHeight() {
        return this.internalPair.getSecond();
    }

    @Override
    public void setWidth(final double width) {
        this.internalPair.setFirst(width);
    }

    @Override
    public void setHeight(final double height) {
        this.internalPair.setSecond(height);
    }

    @Override
    public void increaseWidth(final double increaseValue) {
        System.out.println("DimensionImpl - Increasing starting width: " + this.getWidth() + " with " + increaseValue);
        this.setWidth(this.getWidth() + increaseValue);
        System.out.println("DimensionImpl - After increase: " + this.getWidth());
    }

    @Override
    public void increaseHeight(final double increaseValue) {
        this.setHeight(this.getHeight() + increaseValue);
    }

    @Override
    public Dimension copyOf() {
        return new DimensionImpl(this.getWidth(), this.getHeight());
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(internalPair);
    }

    public String toString() {
        return "Dimension X: " + this.internalPair.getFirst() + " and Y: " + this.internalPair.getSecond();
    }
}
