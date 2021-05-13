package it.unibo.pyxis.element.powerup;

import it.unibo.pyxis.element.AbstractElement;
import it.unibo.pyxis.event.notify.PowerupActivationEvent;
import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.Dimension;

import org.greenrobot.eventbus.EventBus;
import com.google.common.base.Objects;

public final class PowerupImpl extends AbstractElement implements Powerup {

    private final PowerupType type;

    public PowerupImpl(final PowerupType inputType, final Dimension dimension, final Coord coord) {
        super(dimension, coord);
        this.type = inputType;
    }

    @Override
    public void apply() {
        final PowerupActivationEvent powerupActivationEvent = () -> this;
        EventBus.getDefault().post(powerupActivationEvent);
    }

    @Override
    public PowerupType getType() {
        return this.type;
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("This method isn't implemented yet");
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
        return Objects.hashCode(getType());
    }
}
