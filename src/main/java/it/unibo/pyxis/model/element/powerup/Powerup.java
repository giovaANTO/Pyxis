package it.unibo.pyxis.model.element.powerup;

import it.unibo.pyxis.model.element.Element;
import it.unibo.pyxis.model.util.Vector;

public interface Powerup extends Element {
    /**
     * Return the powerup's pace.
     * @return
     *          The {@link Vector}
     */
    Vector getPace();
    /**
     * Return the type associated to this powerup.
     * @return
     *              The {@link PowerupType}
     */
    PowerupType getType();
}
