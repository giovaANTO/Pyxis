package it.unibo.pyxis.model.element.brick;

import it.unibo.pyxis.model.element.Element;
import it.unibo.pyxis.model.event.movement.BallMovementEvent;


public interface Brick extends Element {

    /**
     * Handles the ball's movement event.
     *
     * @param movementEvent
     *                          The movement event caused by the {@link it.unibo.pyxis.model.element.ball.Ball}
     *                          that should be handled
     */
    void handleBallMovement(BallMovementEvent movementEvent);

    /**
     * Returns the brick's durability.
     * @return
     *          The integer representing the durability of the brick.
     */
    int getDurability();

    /**
     * Allow to access the typology of the brick.
     *
     * @return
     *          The {@link BrickType} value for this brick
     */
    BrickType getBrickType();
}
