package it.unibo.pyxis.model.util;


import java.util.Objects;

public final class VectorImpl implements Vector {

    private final Pair<Double> components;

    public VectorImpl(final Pair<Double> initialComponents) {
        this.components = initialComponents;
    }

    public VectorImpl(final double paceX, final double paceY) {
        this(new PairImpl<Double>(paceX, paceY));
    }

    @Override
    public double getX() {
        return this.components.getFirst();
    }

    @Override
    public double getY() {
        return this.components.getSecond();
    }

    @Override
    public double getModule() {
        return Math.sqrt(Math.pow(this.components.getFirst(), 2)
                + Math.pow(this.components.getSecond(), 2));
    }

    @Override
    public void setX(final double xCoord) {
        this.components.setFirst(xCoord);
    }

    @Override
    public void setY(final double yCoord) {
        this.components.setSecond(yCoord);
    }

    @Override
    public Vector copyOf() {
        final double firstComponent = this.components.getFirst();
        final double secondComponent = this.components.getSecond();
        return new VectorImpl(firstComponent, secondComponent);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VectorImpl)) {
            return false;
        }
        final VectorImpl vector = (VectorImpl) o;
        return Objects.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components);
    }
}
