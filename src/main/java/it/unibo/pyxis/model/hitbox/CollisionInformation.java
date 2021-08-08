package it.unibo.pyxis.model.hitbox;

import it.unibo.pyxis.model.util.Dimension;

public class CollisionInformation {

    private final Dimension borderOffset;
    private HitEdge hitEdge;

    public CollisionInformation(final HitEdge hitEdge, final Dimension borderOffset) {
        this.hitEdge = hitEdge;
        this.borderOffset = borderOffset;
    }
    /**
     * Returns the border offset of the collision.
     *
     * @return The border offset's {@link Dimension}.
     */
    public final Dimension getBorderOffset() {
        return this.borderOffset;
    }
    /**
     * Returns the {@link HitEdge} of the collision.
     *
     * @return The {@link HitEdge}.
     */
    public final HitEdge getHitEdge() {
        return this.hitEdge;
    }
    /**
     * Sets the {@link HitEdge} of the collision.
     *
     * @param hitEdge The {@link HitEdge} to set.
     */
    public final void setHitEdge(final HitEdge hitEdge) {
        this.hitEdge = hitEdge;
    }
}
