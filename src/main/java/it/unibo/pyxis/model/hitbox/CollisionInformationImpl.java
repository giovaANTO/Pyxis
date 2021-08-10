package it.unibo.pyxis.model.hitbox;

import it.unibo.pyxis.model.util.Dimension;

public class CollisionInformationImpl implements CollisionInformation {

    private final Dimension borderOffset;
    private HitEdge hitEdge;

    public CollisionInformationImpl(final HitEdge hitEdge, final Dimension borderOffset) {
        this.hitEdge = hitEdge;
        this.borderOffset = borderOffset;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final Dimension getCollisionOffset() {
        return this.borderOffset;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final HitEdge getHitEdge() {
        return this.hitEdge;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final void setHitEdge(final HitEdge hitEdge) {
        this.hitEdge = hitEdge;
    }
}
