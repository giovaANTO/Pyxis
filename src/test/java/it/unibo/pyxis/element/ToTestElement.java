package it.unibo.pyxis.element;

import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.Dimension;
import it.unibo.pyxis.util.DimensionImpl;

public class ToTestElement extends AbstractElement{

    public ToTestElement(Dimension inputDimension, Coord inputPosition) {
        super(inputDimension, inputPosition);
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Method isn't implemented yet");
    }
}
