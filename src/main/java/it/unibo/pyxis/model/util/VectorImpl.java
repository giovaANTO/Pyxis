package it.unibo.pyxis.model.util;


import java.util.Objects;

public final class VectorImpl implements Vector {

    private final Pair<Double> components;

    public VectorImpl(final Pair<Double> initialComponents) {
        this.components = initialComponents;
    }

    public VectorImpl(final double x, final double y) {
        this(new PairImpl<Double>(x, y));
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Vector copyOf() {
        final double firstComponent = this.components.getFirst();
        final double secondComponent = this.components.getSecond();
        return new VectorImpl(firstComponent, secondComponent);
    }
    /**
     * {@inheritDoc}
     */
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
    /**
     * {@inheritDoc}
     */
    @Override
    public double getX() {
        return this.components.getFirst();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public double getY() {
        return this.components.getSecond();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public double getModule() {
        return Math.sqrt(Math.pow(this.components.getFirst(), 2)
                + Math.pow(this.components.getSecond(), 2));
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(components);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Vector createVectorWithSameModule(final double rotationAngle) {
        final double cos = Math.cos(rotationAngle);
        final double sin = Math.sin(rotationAngle);
        final double module = this.getModule();
        return new VectorImpl(module * cos, module * sin);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setX(final double xCoord) {
        this.components.setFirst(xCoord);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setY(final double yCoord) {
        this.components.setSecond(yCoord);
    }





}
