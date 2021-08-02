package it.unibo.pyxis.model.event.collision;

public interface BallCollisionWithBorderEvent extends CollisionEvent {

    /**
     * Returns the Id of the ball that collided in the event.
     * @return
     *          the Id of the ball that collided in the event.
     */
    int getBallId();
}
