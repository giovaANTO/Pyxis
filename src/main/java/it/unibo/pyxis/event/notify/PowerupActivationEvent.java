package it.unibo.pyxis.event.notify;

import it.unibo.pyxis.element.powerup.Powerup;

public interface PowerupActivationEvent extends NotifyEvent {
    Powerup getPowerupEffect();
}
