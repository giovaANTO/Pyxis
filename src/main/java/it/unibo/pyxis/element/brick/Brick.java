package it.unibo.pyxis.element.brick;

import it.unibo.pyxis.element.Element;
import it.unibo.pyxis.event.movement.BallMovementEvent;

public interface Brick extends Element {

    /**
     * Handles the ball's movement event.
     * @param movementEvent
     */
    void handleBallMovement(BallMovementEvent movementEvent);

    /**
     * Returns the brick's durability.
     * @return
     */
    int getDurability();
}
