package it.unibo.pyxis.event.notify;

import it.unibo.pyxis.powerup.effect.PowerupEffect;

public interface PowerupActivationEvent extends NotifyEvent {
    PowerupEffect getPowerupEffect();
}
