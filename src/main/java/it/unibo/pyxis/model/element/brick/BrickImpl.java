package it.unibo.pyxis.model.element.brick;

import it.unibo.pyxis.model.element.AbstractElement;
import it.unibo.pyxis.model.element.brick.component.BrickEventComponent;
import it.unibo.pyxis.model.hitbox.RectHitbox;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.DimensionImpl;
import it.unibo.pyxis.model.util.Vector;
import it.unibo.pyxis.model.util.VectorImpl;


public final class BrickImpl extends AbstractElement implements Brick {

    private static final Dimension DIMENSION = new DimensionImpl(42, 18);
    private final BrickType brickType;
    private int durability;

    public BrickImpl(final BrickType type, final Coord inputPosition) {
        super(DIMENSION, inputPosition);
        this.setHitbox(new RectHitbox(this));
        this.brickType = type;
        this.durability = type.getDurability();
        this.registerComponent(new BrickEventComponent(this));
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
    public void setPace(final Vector inputPace) {
        throw new UnsupportedOperationException("You can't set a the pace on a Brick");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double delta) {
        throw new UnsupportedOperationException("You can't call update on a brick");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDurability() {
        return this.durability;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDurability(final int inputDurability) {
        this.durability = inputDurability;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BrickType getBrickType() {
        return this.brickType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrickImpl)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final BrickImpl brick = (BrickImpl) o;
        return this.getDurability() == brick.getDurability() && this.getBrickType() == brick.getBrickType();
    }
}
