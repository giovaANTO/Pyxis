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
     * Handle a {@link BallMovementEvent}.
     * @param movementEvent
     *          The {@link BallMovementEvent} to handle.
     */
    void handleBallMovement(BallMovementEvent movementEvent);
    /**
     * Handle a {@link PowerupMovementEvent}.
     * @param movementEvent
     *          The {@link PowerupMovementEvent} to handle.
     */
    void handlePowerupMovement(PowerupMovementEvent movementEvent);
}
