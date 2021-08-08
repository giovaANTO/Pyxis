package it.unibo.pyxis.model.event.collision;

import it.unibo.pyxis.model.hitbox.CollisionInformation;

/**
 * Generic collision event interface.
 */
public interface CollisionEvent {
    /**
     * Returns the edge of the {@link it.unibo.pyxis.model.element.Element}
     * that has collided with a {@link it.unibo.pyxis.model.element.ball.Ball}.
     *
     * @return The {@link it.unibo.pyxis.model.hitbox.HitEdge} that collided with
     *         a {@link it.unibo.pyxis.model.element.ball.Ball}.
     */
    CollisionInformation getCollisionInformation();
    /**
     * Returns the Id of the {@link it.unibo.pyxis.model.element.ball.Ball}
     * that collided in the event.
     *
     * @return The Id of the {@link it.unibo.pyxis.model.element.ball.Ball}
     *         that collided in the event.
     */
    int getBallId();
}
