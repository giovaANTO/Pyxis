package it.unibo.pyxis.model.element.powerup;

import it.unibo.pyxis.model.element.AbstractElement;
import it.unibo.pyxis.model.event.Events;
import it.unibo.pyxis.model.hitbox.RectHitbox;
import it.unibo.pyxis.model.util.*;

import org.greenrobot.eventbus.EventBus;

import java.util.Objects;

public final class PowerupImpl extends AbstractElement implements Powerup {

    private static final Dimension DIMENSION = new DimensionImpl(1, 1);
    private static final Vector PACE = new VectorImpl(1, 1);
    private final PowerupType type;

    public PowerupImpl(final PowerupType inputType, final Coord inputCoord) {
        super(DIMENSION, inputCoord, new RectHitbox(inputCoord, DIMENSION));
        this.type = inputType;
    }

    @Override
    public void apply() {
        EventBus.getDefault().post(Events.newPowerupActivationEvent(this));
    }

    @Override
    public PowerupType getType() {
        return this.type;
    }

    @Override
    public Vector getPace() {
        return PACE.copyOf();
    }

    @Override
    public void update(final int dt) {
        this.calculateNewCoord(dt);
        EventBus.getDefault().post(Events.newPowerupMovementEvent(this.getPosition()));
        this.getHitbox().setPosition(this.getPosition());
    }

    private void calculateNewCoord(final int dt) {
        final Coord updatedCoord = this.getPosition();
        updatedCoord.sumVector(this.getPace(),
                dt * this.getUpdateTimeMultiplier());
        this.setPosition(updatedCoord);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PowerupImpl)) {
            return false;
        }
        PowerupImpl powerup = (PowerupImpl) o;
        return getType() == powerup.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType());
    }
}
