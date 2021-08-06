package it.unibo.pyxis.model.element;

import it.unibo.pyxis.model.hitbox.RectHitbox;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.Vector;

public class ToTestElement extends AbstractElement{

    public ToTestElement(final Dimension inputDimension, final Coord inputPosition) {
        super(inputDimension, inputPosition);
        this.setHitbox(new RectHitbox(this));
    }

    @Override
    public Vector getPace() {
        return null;
    }

    @Override
    public void setPace(Vector inputPace) {

    }

    @Override
    public void update(final double dt) {
        throw new UnsupportedOperationException("Method isn't implemented yet");
    }
}
