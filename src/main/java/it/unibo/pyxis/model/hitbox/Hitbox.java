package it.unibo.pyxis.model.hitbox;

import java.util.Optional;

import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;

public interface Hitbox {

    /**
     * Return the position of the {@link Hitbox}.
     * @return
     *          The {@link Coord} of the {@link Hitbox}
     */
    Coord getPosition();

    /**
     * Return the dimension of the {@link Hitbox}.
     *
     * @return
     *          The {@link Dimension} of the {@link Hitbox}
     *
     */
    Dimension getDimension();

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
    boolean isCollidingWithOtherHB(Hitbox hitbox);

    /**
     * Checks for a collision with the same hitbox.
     * @param hitbox
     * @return TRUE if the two hitboxes are the same and colliding, otherwise FALSE.
     */
    boolean isCollidingWithSameHB(Hitbox hitbox);

    /**
     * Checks for a collision with the different hitbox.
     * @param hitbox
     * @return An Optional with the specified Edge the RectHitbox is colliding with, an EMPTY optional if they are the same or not colliding.
     */
    Optional<HitEdge> collidingEdgeWithOtherHB(Hitbox hitbox);
    
}
