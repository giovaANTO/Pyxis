package it.unibo.pyxis.model.event.notify;

import it.unibo.pyxis.model.event.Event;
import it.unibo.pyxis.model.util.Coord;

/**
 * Event fired when a brick is destroyed.
 */
public interface BrickDestructionEvent extends Event {
    /**
     * Returns the {@link Coord} of the destroyed
     * {@link it.unibo.pyxis.model.element.brick.Brick}.
     *
     * @return The {@link Coord} of the destroyed
     *         {@link it.unibo.pyxis.model.element.brick.Brick}.
     */
    Coord getBrickCoord();
    /**
     * Returns the points gained on the destruction of the
     * {@link it.unibo.pyxis.model.element.brick.Brick}.
     *
     * @return An integer representing the number of points gained on the destruction
     *         of a {@link it.unibo.pyxis.model.element.brick.Brick}
     */
    int getPoints();
}
