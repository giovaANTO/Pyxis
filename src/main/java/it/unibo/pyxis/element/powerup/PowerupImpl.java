package it.unibo.pyxis.element.powerup;

import it.unibo.pyxis.element.AbstractElement;
import it.unibo.pyxis.event.EventHandler;
import it.unibo.pyxis.event.notify.PowerupActivationEvent;
import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.Dimension;

public final class PowerupImpl extends AbstractElement implements Powerup {

    private final PowerupType type;

    public PowerupImpl(final PowerupType inputType, final Dimension dimension, final Coord coord) {
        super(dimension, coord);
        this.type = inputType;
    }

    @Override
    public void apply() {
        final PowerupActivationEvent powerupActivationEvent = () -> this.getType().getEffect();
        EventHandler.getEventHandler().sendEvent(powerupActivationEvent);
    }

    @Override
    public PowerupType getType() {
        return this.type;
    }
}
