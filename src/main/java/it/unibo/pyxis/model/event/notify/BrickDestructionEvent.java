package it.unibo.pyxis.model.event.notify;

import it.unibo.pyxis.model.event.Event;
import it.unibo.pyxis.model.util.Coord;

/**
 * Event fired when a brick is destroyed.
 */
@FunctionalInterface
public interface BrickDestructionEvent extends Event {
    /**
     * Return the coords of the destroyed {@link it.unibo.pyxis.model.element.brick.Brick}.
     * @return
     *          The {@link Coord} of the destroyed {@link it.unibo.pyxis.model.element.brick.Brick}.
     */
    Coord getBrickCoord();
}
