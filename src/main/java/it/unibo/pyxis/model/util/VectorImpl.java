package it.unibo.pyxis.model.util;


import java.util.Objects;

public final class VectorImpl implements Vector {

    private final Pair<Double> components;

    public VectorImpl(final Pair<Double> initialComponents) {
        this.components = initialComponents;
    }

    public VectorImpl(final double firstComponent, final double secondComponent) {
        this(new PairImpl<Double>(firstComponent, secondComponent));
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
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VectorImpl vector = (VectorImpl) o;
        return Objects.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components);
    }

    @Override
    public Vector copyOf() {
        double firstComponent = this.components.getFirst();
        double secondComponent = this.components.getSecond();
        return new VectorImpl(firstComponent, secondComponent);
    }

}
