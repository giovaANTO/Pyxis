package it.unibo.pyxis.model.element.powerup;

import it.unibo.pyxis.model.element.Element;
public interface Powerup extends Element {
    /**
     * Returns the {@link PowerupType} associated to this {@link Powerup}.
     *
     * @return The {@link PowerupType}.
     */
    PowerupType getType();
}
