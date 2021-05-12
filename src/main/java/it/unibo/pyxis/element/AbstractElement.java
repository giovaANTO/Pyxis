package it.unibo.pyxis.element;

import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.Dimension;

import java.util.Objects;

public abstract class AbstractElement implements Element {

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

    @Override
    public final synchronized void setPosition(final Coord inputPosition) {
        Objects.requireNonNull(inputPosition, "Error, tried to set null position.");
        this.position.setXY(inputPosition.getX(), inputPosition.getY());
    }

    @Override
    public final void setWidth(final double inputWidth) {
        this.dimension.setWidth(inputWidth);
    }

    @Override
    public final void setHeight(final double inputHeight) {
        this.dimension.setHeight(inputHeight);
    }

    @Override
    public final void increaseWidth(final double increaseValue) {
        this.dimension.increaseWidth(increaseValue);
    }

    @Override
    public final void increaseHeight(final double increaseValue) {
        this.dimension.increaseHeight(increaseValue);
    }

    @Override
    public abstract void update();
}
