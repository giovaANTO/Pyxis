package it.unibo.pyxis.model.element.powerup;

import it.unibo.pyxis.model.element.AbstractElement;
import it.unibo.pyxis.model.element.powerup.component.PowerupUpdateComponent;
import it.unibo.pyxis.model.hitbox.RectHitbox;

import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.DimensionImpl;
import it.unibo.pyxis.model.util.Vector;
import it.unibo.pyxis.model.util.VectorImpl;

import java.util.Objects;

public final class PowerupImpl extends AbstractElement implements Powerup {

    private static final Dimension DIMENSION = new DimensionImpl(20, 14);
    private static final Vector PACE = new VectorImpl(0, 30);
    private final PowerupType type;

    public PowerupImpl(final PowerupType inputType, final Coord inputCoord) {
        super(DIMENSION, inputCoord);
        this.setHitbox(new RectHitbox(this));
        this.type = inputType;
        this.registerComponent(new PowerupUpdateComponent(this));
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PowerupImpl)) {
            return false;
        }
        final PowerupImpl powerup = (PowerupImpl) o;
        return super.equals(o) && getType() == powerup.getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PowerupType getType() {
        return this.type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Vector getPace() {
        return PACE.copyOf();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(getType());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPace(final Vector inputPace) {
        throw new UnsupportedOperationException("You can't set a the pace on a PowerupImpl");
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string representing the object.
     */
    public String toString() {
        return "I'm a " + this.type + "; Coord: " + this.getPosition().getX() + " " + this.getPosition().getY();
    }
}
