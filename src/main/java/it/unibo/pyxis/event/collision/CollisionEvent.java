package it.unibo.pyxis.event.collision;

import it.unibo.pyxis.hitbox.HitEdge;

/**
 * Generic collision event interface.
 */
@FunctionalInterface
public interface CollisionEvent {
    /**
     * Return the edge of the element where the ball has collided.
     * @return
     *          the {@link HitEdge} that collided with the ball.
     */
    HitEdge getCollidedEdge();
}
