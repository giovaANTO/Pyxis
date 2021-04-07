package it.unibo.pyxis.util;

public class CoordImpl implements Coord {

    private final Pair<Double> internalPair;

    public CoordImpl(final Pair<Double> pair) {
        this.internalPair = pair;
    }

    @Override
    public double getX() {
        return this.internalPair.getFirst();
    }

    @Override
    public double getY() {
        return this.internalPair.getSecond();
    }

    @Override
    public void setX(double xCoord) {
        this.internalPair.setFirst(xCoord);
    }

    @Override
    public void setY(double yCoord) {
        this.internalPair.setSecond(yCoord);
    }
}
