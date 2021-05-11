package it.unibo.pyxis.element;

import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.Dimension;

public abstract class AbstractElement implements Element {

    private final Dimension dimension;
    private final Coord position;

    public AbstractElement(final Dimension inputDimension, final Coord inputPosition) {
        this.dimension = inputDimension;
        this.position = inputPosition;
    }

    @Override
    public final synchronized Dimension getDimension() {
        return this.dimension;
    }

    @Override
    public final synchronized Coord getPosition() {
        return this.position;
    }

    @Override
    public abstract void update();
}
