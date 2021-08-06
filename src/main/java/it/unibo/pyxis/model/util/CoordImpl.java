package it.unibo.pyxis.model.util;
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
    public void sumXValue(final double xValue) {
        this.internalPair.setFirst(this.internalPair.getFirst() + xValue);
    }

    @Override
    public void sumYValue(final double yValue) {
        this.internalPair.setSecond(this.internalPair.getSecond() + yValue);
    }

    @Override
    public void sumValues(final double xValue, final double yValue) {
        this.sumXValue(xValue);
        this.sumYValue(yValue);
    }

    @Override
    public void sumCoord(final Coord coord) {
        this.sumValues(coord.getX(), coord.getY());
    }

    @Override
    public void sumVector(final Vector inputVector) {
        this.sumVector(inputVector, 1);
    }

    @Override
    public void sumVector(final Vector inputVector, final double multiplier) {
        this.sumValues(inputVector.getX() * multiplier, inputVector.getY() * multiplier);
    }

    @Override
    public double distance(final Coord position) {
        final double px = position.getX() - this.getX();
        final double py = position.getY() - this.getY();
        return Math.sqrt(px * px + py * py);
    }

    @Override
    public double distance(final double x, final double y) {
        final double px = x - getX();
        final double py = y - getY();
        return Math.sqrt(px * px + py * py);
    }

    @Override
    public Coord copyOf() {
        return new CoordImpl(this.getX(), this.getY());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CoordImpl coord = (CoordImpl) o;
        return internalPair.equals(coord.internalPair);
    }

    @Override
    public int hashCode() {
        return Objects.hash(internalPair);
    }

    public String toString() {
        return "Position X: " + this.internalPair.getFirst() + " and Y: " + this.internalPair.getSecond();
    }
}
