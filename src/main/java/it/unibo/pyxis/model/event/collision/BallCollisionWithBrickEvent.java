package it.unibo.pyxis.model.event.collision;

/**
 * Event fired when a {@link it.unibo.pyxis.model.element.ball.Ball}
 * collides with a {@link it.unibo.pyxis.model.element.brick.Brick}.
 */
public interface BallCollisionWithBrickEvent extends CollisionEvent {
    /**
     * Returns the Id of the {@link it.unibo.pyxis.model.element.ball.Ball}
     * that collided in the event.
     * @return
     *          the Id of the {@link it.unibo.pyxis.model.element.ball.Ball}
     *          that collided in the event.
     */
    int getBallId();
}
