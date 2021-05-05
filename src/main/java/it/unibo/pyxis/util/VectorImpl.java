package it.unibo.pyxis.util;

import java.lang.Math;

public class VectorImpl implements Vector{

    private final Pair<Double> components;

    public VectorImpl(final Pair<Double> initialComponents) {
        this.components = initialComponents;
    }

    @Override
    public Pair<Double> getComponents() {
        return this.components;
    }

    @Override
    public double getModule() {
        return Math.sqrt(Math.pow(this.components.getFirst(), 2) +
                        Math.pow(this.components.getSecond(), 2));
    }

    @Override
    public void setComponents(final Pair<Double> inputComponents) {
        this.components.setFirst(inputComponents.getFirst());
        this.components.setSecond(inputComponents.getSecond());
    }
}
