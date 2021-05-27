package it.unibo.pyxis.model.element;

import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;

public class ToTestElement extends AbstractElement{

    public ToTestElement(Dimension inputDimension, Coord inputPosition) {
        super(inputDimension, inputPosition);
    }

    @Override
    public void update(final int dt) {
        throw new UnsupportedOperationException("Method isn't implemented yet");
    }
}
