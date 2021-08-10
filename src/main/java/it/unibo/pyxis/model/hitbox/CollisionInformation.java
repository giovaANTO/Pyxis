package it.unibo.pyxis.model.hitbox;

import it.unibo.pyxis.model.util.Dimension;

public interface CollisionInformation {
    /**
     * Returns the offset of the collision.
     *
     * @return The collision offset's {@link Dimension}.
     */
    Dimension getCollisionOffset();
    /**
     * Returns the {@link HitEdge} of the collision.
     *
     * @return The {@link HitEdge}.
     */
    HitEdge getHitEdge();
    /**
     * Sets the {@link HitEdge} of the collision.
     *
     * @param hitEdge The {@link HitEdge} to set.
     */
    void setHitEdge(final HitEdge hitEdge);
}
