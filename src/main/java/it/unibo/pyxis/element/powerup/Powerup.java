package it.unibo.pyxis.element.powerup;

import it.unibo.pyxis.element.Element;

public interface Powerup extends Element {
    /**
     * Send a new {@link it.unibo.pyxis.event.notify.PowerupActivationEvent}
     * to an {@link it.unibo.pyxis.arena.Arena} instance that apply the current powerup effects.
     */
    void apply();

    /**
     * Return the type associated to this powerup.
     * @return
     *              The {@link PowerupType}
     */
    PowerupType getType();
}
