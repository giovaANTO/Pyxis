package it.unibo.pyxis.event.notify;

import it.unibo.pyxis.event.Event;
import it.unibo.pyxis.util.Coord;

/**
 * Event fired when a brick is destroyed.
 */
@FunctionalInterface
public interface BrickDestructionEvent extends Event {
    /**
     * Return the coords of the destroyed {@link it.unibo.pyxis.element.brick.Brick}.
     * @return
     *          The {@link Coord} of the destroyed {@link it.unibo.pyxis.element.brick.Brick}.
     */
    Coord getBrickCoord();
}
