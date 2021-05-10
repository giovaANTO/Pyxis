package it.unibo.pyxis.element.powerup;

import it.unibo.pyxis.element.AbstractElement;
import it.unibo.pyxis.event.Events;
import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.Dimension;
import org.greenrobot.eventbus.EventBus;

public final class PowerupImpl extends AbstractElement implements Powerup {

    private final PowerupType type;

    public PowerupImpl(final PowerupType inputType, final Dimension dimension, final Coord coord) {
        super(dimension, coord);
        this.type = inputType;
    }

    @Override
    public void apply() {
        EventBus.getDefault().post(Events.newPowerupActivationEvent(this.getType().getEffect()));
    }

    @Override
    public PowerupType getType() {
        return this.type;
    }
}
