package it.unibo.pyxis.element.pad;

import it.unibo.pyxis.element.Element;
import it.unibo.pyxis.event.movement.BallMovementEvent;
import it.unibo.pyxis.event.movement.PowerupMovementEvent;

public interface Pad extends Element {

    void handleBallMovement(BallMovementEvent movementEvent);

    void handlePowerupMovement(PowerupMovementEvent movementEvent);
}
