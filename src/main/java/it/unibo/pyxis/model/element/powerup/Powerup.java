package it.unibo.pyxis.model.element.powerup;

import it.unibo.pyxis.model.element.Element;
public interface Powerup extends Element {
    /**
     * Return the type associated to this powerup.
     * @return
     *              The {@link PowerupType}
     */
    PowerupType getType();
}
