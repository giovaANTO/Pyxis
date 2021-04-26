package it.unibo.pyxis.element.powerup;

import it.unibo.pyxis.element.AbstractElement;
import it.unibo.pyxis.event.EventHandler;
import it.unibo.pyxis.event.notify.PowerupActivationEvent;

public final class PowerupImpl extends AbstractElement implements Powerup {

    private final PowerupType type;

    public PowerupImpl(final PowerupType inputType) {
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
