package it.unibo.pyxis.event.movement;
import it.unibo.pyxis.event.Event;
import it.unibo.pyxis.util.Coord;

public interface MovementEvent extends Event {
    Coord getCoord();
}
