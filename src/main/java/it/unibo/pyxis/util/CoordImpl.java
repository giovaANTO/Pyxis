package it.unibo.pyxis.util;

import it.unibo.pyxis.event.movement.BallMovementEvent;

import java.util.Objects;

public class CoordImpl implements Coord {

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
    public void setX(double xCoord) {
        this.internalPair.setFirst(xCoord);
    }

    @Override
    public void setY(double yCoord) {
        this.internalPair.setSecond(yCoord);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordImpl coord = (CoordImpl) o;
        return internalPair.equals(coord.internalPair);
    }

    @Override
    public int hashCode() {
        return Objects.hash(internalPair);
    }
}
