package it.unibo.pyxis.event.movement;

/**
 * Event fired when the {@link it.unibo.pyxis.element.ball.Ball}
 * update its position.
 */
public interface BallMovementEvent extends MovementEvent {
    int getBallId();
}
