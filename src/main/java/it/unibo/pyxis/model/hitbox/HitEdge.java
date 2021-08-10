package it.unibo.pyxis.model.hitbox;

public enum HitEdge {
    /**
     * Collision between two {@link it.unibo.pyxis.model.hitbox.BallHitbox}es.
     */
    CIRCLE,
    /**
     * Collision between a {@link it.unibo.pyxis.model.hitbox.BallHitbox}
     * and the corner of a {@link it.unibo.pyxis.model.hitbox.RectHitbox}
     * or of a Border.
     */
    CORNER,
    /**
     * Collision between a {@link it.unibo.pyxis.model.hitbox.BallHitbox}
     * and a horizontal edge of a {@link it.unibo.pyxis.model.hitbox.RectHitbox}.
     */
    HORIZONTAL,
    /**
     * Collision between a {@link it.unibo.pyxis.model.hitbox.BallHitbox}
     * and the top edge of a {@link it.unibo.pyxis.model.hitbox.RectHitbox}.
     */
    TOP,
    /**
     * Collision between a {@link it.unibo.pyxis.model.hitbox.BallHitbox}
     * and a vertical edge of a {@link it.unibo.pyxis.model.hitbox.RectHitbox}.
     */
    VERTICAL;
}
