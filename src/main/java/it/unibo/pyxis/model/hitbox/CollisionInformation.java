package it.unibo.pyxis.model.hitbox;

import it.unibo.pyxis.model.util.Dimension;

public class CollisionInformation {

    private final HitEdge hitEdge;
    private final Dimension borderOffset;

    public CollisionInformation(final HitEdge hitEdge, final Dimension borderOffset) {
        this.hitEdge = hitEdge;
        this.borderOffset = borderOffset;
    }

    public HitEdge getHitEdge() {
        return hitEdge;
    }

    public Dimension getBorderOffset() {
        return borderOffset;
    }

}
