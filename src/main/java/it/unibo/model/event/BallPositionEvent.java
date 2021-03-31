package it.unibo.model.event;

/**
 * Toy interface describing event 1
 */
public interface BallPositionEvent extends Event {

    /**
     * String containing the position of the ball
     *
     * @return
     *          The string with the ball position
     */
    String getPosition();
}
