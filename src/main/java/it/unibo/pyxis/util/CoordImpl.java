package it.unibo.pyxis.util;
import java.util.Objects;

public final class CoordImpl implements Coord {

    private final Pair<Double> internalPair;

    public CoordImpl(final double xCoord, final double yCoord) {
        this.internalPair = new PairImpl<>(xCoord, yCoord);
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
    public void setX(final double xCoord) {
        this.internalPair.setFirst(xCoord);
    }

    @Override
    public void setY(final double yCoord) {
        this.internalPair.setSecond(yCoord);
    }

    @Override
    public void sumVector(final Vector inputVector, final double multiplier) {
        this.internalPair.setFirst(this.internalPair.getFirst() + inputVector.getComponents().getFirst() * multiplier);
        this.internalPair.setSecond(this.internalPair.getSecond() + inputVector.getComponents().getSecond() * multiplier);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CoordImpl coord = (CoordImpl) o;
        return internalPair.equals(coord.internalPair);
    }

    @Override
    public int hashCode() {
        return Objects.hash(internalPair);
    }
}
