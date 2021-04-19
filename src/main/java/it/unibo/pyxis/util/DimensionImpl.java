package it.unibo.pyxis.util;

public class DimensionImpl implements Dimension {

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
    public void setWidth(double width) {
        this.internalPair.setFirst(width);
    }

    @Override
    public void setHeight(double height) {
        this.internalPair.setSecond(height);
    }
}
