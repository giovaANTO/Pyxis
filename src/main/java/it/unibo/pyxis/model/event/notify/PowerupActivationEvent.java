package it.unibo.pyxis.model.event.notify;

import it.unibo.pyxis.model.element.powerup.Powerup;
import it.unibo.pyxis.model.event.Event;

/**
 * Event fired when a powerup is fired.
 */
@FunctionalInterface
public interface PowerupActivationEvent extends Event {
    /**
     * Return the instance of the powerup that has been activated.
     * @return
     *          The instance of activated {@link Powerup}
     */
    Powerup getPowerup();
}
