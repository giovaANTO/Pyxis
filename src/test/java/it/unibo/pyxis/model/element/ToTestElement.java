package it.unibo.pyxis.model.element;

import it.unibo.pyxis.model.hitbox.Hitbox;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;

public class ToTestElement extends AbstractElement{

    public ToTestElement(final Dimension inputDimension, final Coord inputPosition, final Hitbox hitbox) {
        super(inputDimension, inputPosition, hitbox);
    }

    @Override
    public void update(final int dt) {
        throw new UnsupportedOperationException("Method isn't implemented yet");
    }
}
