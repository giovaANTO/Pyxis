package it.unibo.pyxis.model.element.powerup;

import it.unibo.pyxis.model.element.Element;
import it.unibo.pyxis.model.util.Vector;

public interface Powerup extends Element {
    /**
     * Send a new {@link it.unibo.pyxis.model.event.notify.PowerupActivationEvent}
     * to an {@link it.unibo.pyxis.model.arena.Arena} instance that apply the current powerup effects.
     */
    void apply();

    /**
     * Return the type associated to this powerup.
     * @return
     *              The {@link PowerupType}
     */
    PowerupType getType();

    /**
     * Return the powerup's pace.
     * @return
     *          The {@link Vector}
     */
    Vector getPace();
}
