package it.unibo.pyxis.model.event.movement;

/**
 * Event fired when the {@link it.unibo.pyxis.model.element.ball.Ball}
 * update its position.
 */
public interface BallMovementEvent extends MovementEvent {
    int getBallId();
}
