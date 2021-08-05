package it.unibo.pyxis.model.event.collision;

/**
 * Event fired when a {@link it.unibo.pyxis.model.element.ball.Ball}
 * collides with a border of the {@link it.unibo.pyxis.model.arena.Arena}.
 */
public interface BallCollisionWithBorderEvent extends CollisionEvent {
    /**
     * Returns the Id of the {@link it.unibo.pyxis.model.element.ball.Ball}
     * that collided in the event.
     * @return
     *          the Id of the {@link it.unibo.pyxis.model.element.ball.Ball}
     *          that collided in the event.
     */
    int getBallId();
}
