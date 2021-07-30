package it.unibo.pyxis.model.element.pad;

import it.unibo.pyxis.model.element.Element;
import it.unibo.pyxis.model.event.movement.BallMovementEvent;
import it.unibo.pyxis.model.event.movement.PowerupMovementEvent;

public interface Pad extends Element {

    /**
     * Set the tag name of the {@link Pad}.
     * @return
     *          The tag string of the {@link Pad}
     */
    String getTag();

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
