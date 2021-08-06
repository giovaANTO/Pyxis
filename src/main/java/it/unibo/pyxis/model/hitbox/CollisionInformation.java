package it.unibo.pyxis.model.hitbox;

import it.unibo.pyxis.model.util.Dimension;

public class CollisionInformation {

    private final Dimension borderOffset;
    private HitEdge hitEdge;

    public CollisionInformation(final HitEdge hitEdge, final Dimension borderOffset) {
        this.hitEdge = hitEdge;
        this.borderOffset = borderOffset;
    }

    public Dimension getBorderOffset() {
        return borderOffset;
    }

    public HitEdge getHitEdge() {
        return hitEdge;
    }

    public void setHitEdge(final HitEdge hitEdge) {
        this.hitEdge = hitEdge;
    }

}
