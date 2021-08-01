package it.unibo.pyxis.model.event.movement;

import it.unibo.pyxis.model.element.ball.Ball;

/**
 * Event fired when the {@link it.unibo.pyxis.model.element.ball.Ball}
 * update its position.
 */
public interface BallMovementEvent extends MovementEvent<Ball> {
}
