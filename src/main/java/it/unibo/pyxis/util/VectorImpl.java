package it.unibo.pyxis.util;


public final class VectorImpl implements Vector {

    private final Pair<Double> components;

    public VectorImpl(final Pair<Double> initialComponents) {
        this.components = initialComponents;
    }

    public VectorImpl(final double firstComponent, final double secondComponent) {
        this(new PairImpl<Double>(firstComponent, secondComponent));
    }

    @Override
    public Pair<Double> getComponents() {
        return this.components;
    }

    @Override
    public double getModule() {
        return Math.sqrt(Math.pow(this.components.getFirst(), 2)
                + Math.pow(this.components.getSecond(), 2));
    }

    @Override
    public void setComponents(final Pair<Double> inputComponents) {
        this.components.setFirst(inputComponents.getFirst());
        this.components.setSecond(inputComponents.getSecond());
    }

    @Override
    public Vector copyOf() {
        double firstComponent = this.components.getFirst();
        double secondComponent = this.components.getSecond();
        return new VectorImpl(firstComponent, secondComponent);
    }

}
