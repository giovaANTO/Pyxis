package it.unibo.pyxis.hitbox;

import java.util.Optional;

import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.Dimension;

public interface Hitbox {
    
    /**
     * Checks for a collision with a Coord point.
     * 
     * @param
     * 
     * @return
     * TRUE is the point is situated inside the hitbox, otherwise FALSE.
     * 
     */
    boolean isCollidingWithPoint(Coord position);
    
    /**
     * Checks for a collision with the different hitbox.
     * @param hitbox
     * @return TRUE if the two hitboxes are different and colliding, otherwise FALSE.
     */
    boolean isCollidingWithOtherHB(HitboxImpl hitbox);
    
    /**
     * Checks for a collision with the same hitbox.
     * @param hitbox
     * @return TRUE if the two hitboxes are the same and colliding, otherwise FALSE.
     */
    boolean isCollidingWithSameHB(HitboxImpl hitbox);
    
    /**
     * Checks for a collision with the different hitbox.
     * @param hitbox
     * @return An Optional with the specified Edge the RectHitbox is colliding with, an EMPTY optional if they are the same or not colliding.
     */
    Optional<HitEdge> collidingEdgeWithOtherHB(HitboxImpl hitbox);
    
}
