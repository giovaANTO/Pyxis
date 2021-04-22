package it.unibo.pyxis.element;

import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.Dimension;

public abstract class AbstractElement implements Element{

    private Dimension dimension;
    private Coord position;

    @Override
    public Dimension getDimension() {
        return this.dimension;
    }

    @Override
    public Coord getPosition() {
        return this.position;
    }

    @Override
    public void setDimension(Dimension newDimension) {
        this.dimension = newDimension;
    }

    @Override
    public void setPosition(Coord newPosition) {
        this.position = newPosition;
    }
}
