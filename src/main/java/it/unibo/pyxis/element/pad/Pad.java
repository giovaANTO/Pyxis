package it.unibo.pyxis.element.pad;

import it.unibo.pyxis.element.Element;
import it.unibo.pyxis.event.movement.BallMovementEvent;
import it.unibo.pyxis.event.movement.PowerupMovementEvent;

public interface Pad extends Element {

    /**
     * Handles the ball's movement event.
     * @param movementEvent
     */
    void handleBallMovement(BallMovementEvent movementEvent);

    /**
     * Handles a powerup's movement event.
     * @param movementEvent
     */
    void handlePowerupMovement(PowerupMovementEvent movementEvent);
}
