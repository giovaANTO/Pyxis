package it.unibo.pyxis.model.event.collision;

import it.unibo.pyxis.model.hitbox.CollisionInformation;
import it.unibo.pyxis.model.hitbox.HitEdge;

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
    CollisionInformation getCollisionInformation();
}
