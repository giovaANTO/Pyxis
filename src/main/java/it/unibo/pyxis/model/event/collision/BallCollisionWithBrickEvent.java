package it.unibo.pyxis.model.event.collision;

/**
 * Event fired when a {@link it.unibo.pyxis.model.element.ball.Ball}
 * collides with a {@link it.unibo.pyxis.model.element.brick.Brick}.
 */
public interface BallCollisionWithBrickEvent extends CollisionEvent {
    /**
     * Indicates if the {@link it.unibo.pyxis.model.element.brick.Brick}
     * that collided in the event is indestructible.
     *
     * @return True if the {@link it.unibo.pyxis.model.element.brick.Brick}
     *         that collided in the event is indestructible.
     *         False otherwise.
     */
    boolean isBrickIndestructible();
}
