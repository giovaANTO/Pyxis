package it.unibo.pyxis.event.notify;

import it.unibo.pyxis.util.Coord;

public interface BrickDestructionEvent extends NotifyEvent {
    Coord getBrickCoord();
}
