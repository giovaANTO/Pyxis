package it.unibo.pyxis.util;

import com.google.common.base.Objects;

public final class DimensionImpl implements Dimension {

    private final Pair<Double> internalPair;

    public DimensionImpl(final double width, final double height) {
        this.internalPair = new PairImpl<>(width, height);
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
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DimensionImpl)) {
            return false;
        }
        DimensionImpl dimension = (DimensionImpl) o;
        return Objects.equal(internalPair, dimension.internalPair);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(internalPair);
    }
}
