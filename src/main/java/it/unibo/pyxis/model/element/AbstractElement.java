package it.unibo.pyxis.model.element;

import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;

import java.util.Objects;

public abstract class AbstractElement implements Element {

    private static final double UPDATE_TIME_MULTIPLIER = 0.001;
    private final Dimension dimension;
    private final Coord position;

    public AbstractElement(final Dimension inputDimension, final Coord inputPosition) {
        this.dimension = inputDimension;
        this.position = inputPosition;
    }

    @Override
    public final synchronized Dimension getDimension() {
        return this.dimension.copyOf();
    }

    @Override
    public final synchronized Coord getPosition() {
        return this.position.copyOf();
    }

    public final double getUpdateTimeMultiplier() {
        return UPDATE_TIME_MULTIPLIER;
    }

    @Override
    public final synchronized void setPosition(final Coord inputPosition) {
        Objects.requireNonNull(inputPosition, "Error, tried to set null position.");
        this.position.setXY(inputPosition.getX(), inputPosition.getY());
    }

    @Override
    public final synchronized void setWidth(final double inputWidth) {
        this.dimension.setWidth(inputWidth);
    }

    @Override
    public final synchronized void setHeight(final double inputHeight) {
        this.dimension.setHeight(inputHeight);
    }

    @Override
    public final synchronized void increaseWidth(final double increaseValue) {
        this.dimension.increaseWidth(increaseValue);
    }

    @Override
    public final synchronized void increaseHeight(final double increaseValue) {
        this.dimension.increaseHeight(increaseValue);
    }

    @Override
    public abstract void update(int dt);
}
