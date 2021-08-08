package it.unibo.pyxis.model.element.pad;

import it.unibo.pyxis.model.element.AbstractElement;
import it.unibo.pyxis.model.element.pad.component.PadEventComponent;
import it.unibo.pyxis.model.hitbox.RectHitbox;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.DimensionImpl;
import it.unibo.pyxis.model.util.Vector;
import it.unibo.pyxis.model.util.VectorImpl;

import java.util.Objects;

public final class PadImpl extends AbstractElement implements Pad {

    private static final String DEFAULT_TAG = "DEFAULT_PAD";
    private static final Dimension DIMENSION = new DimensionImpl(70, 12);
    private final String tag;

    public PadImpl(final Dimension inputDimension, final Coord inputPosition, final String inputTag) {
        super(inputDimension, inputPosition);
        this.setHitbox(new RectHitbox(this));
        this.tag = inputTag;
        this.registerComponent(new PadEventComponent(this));
    }

    public PadImpl(final Dimension inputDimension, final Coord inputPosition) {
        this(inputDimension, inputPosition, DEFAULT_TAG);
    }

    public PadImpl(final Coord inputPosition) {
        this(DIMENSION, inputPosition, DEFAULT_TAG);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PadImpl)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final PadImpl pad = (PadImpl) o;
        return Objects.equals(this.getTag(), pad.getTag());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Vector getPace() {
        return new VectorImpl(0, 0);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String getTag() {
        return this.tag;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getTag());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setPace(final Vector inputPace) {
        throw new UnsupportedOperationException("You can't set the pace on a Pad");
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt) {
        throw new UnsupportedOperationException("You can't call an update on the Pad");
    }
}
