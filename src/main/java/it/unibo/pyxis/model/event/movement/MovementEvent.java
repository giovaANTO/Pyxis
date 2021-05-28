package it.unibo.pyxis.model.event.movement;

import it.unibo.pyxis.model.event.Event;
import it.unibo.pyxis.model.util.Coord;

/**
 * Represent a generic movement event.
 */
@FunctionalInterface
public interface MovementEvent extends Event {
    Coord getCoord();
}
