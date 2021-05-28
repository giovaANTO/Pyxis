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
     * Set the position of the {@link Hitbox}
     * @param
     *          position
     */
    void setPosition(Coord position);

    /**
     * Return the dimension of the {@link Hitbox}.
     *
     * @return
     *          The {@link Dimension} of the {@link Hitbox}
     *
     */
    Dimension getDimension();

    /**
     * Checks for a collision with a {@link Coord}.
     * 
     * @param
     *          position
     * @return
     *          TRUE is the point is situated inside the {@link Hitbox}, otherwise FALSE.
     * 
     */
    boolean isCollidingWithPoint(Coord position);

    /**
     * Checks for a collision with the different {@link Hitbox}.
     * @param 
     *          hitbox
     * @return 
     *          TRUE if the two {@link Hitbox} are different and colliding, otherwise FALSE.
     */
    boolean isCollidingWithOtherHB(Hitbox hitbox);

    /**
     * Checks for a collision with the same {@link Hitbox}.
     * @param 
     *          hitbox
     * @return 
     *          TRUE if the two {@link Hitbox} are the same and colliding, otherwise FALSE.
     */
    boolean isCollidingWithSameHB(Hitbox hitbox);

    /**
     * Checks for a collision with the different {@link Hitbox}.
     * @param 
     *          hitbox
     * @return 
     *          An {@link Optional} with the specified {@link HitEdge} the {@link RectHitbox} is colliding with, an EMPTY {@link Optional} if they are the same or not colliding.
     */
    Optional<HitEdge> collidingEdgeWithOtherHB(Hitbox hitbox);

    /**
     * Checks for a collision with the right, left and upper border of the {@link RectHitbox}.
     * @param 
     *          borderPosition
     * @param 
     *          borderDimension
     * @return 
     *          An {@link Optional} with the specified colliding {@link HitEdge} of the border, an EMPTY {@link Optional} if they are not colliding.
     */
    Optional<HitEdge> collidingEdgeWithBorder(RectHitbox border);

    /**
     * Checks for a collision with the lower border of the {@link RectHitbox}.
     * @param 
     *          border
     * @return 
     *          TRUE if there is a collision, otherwise FALSE.
     */
    boolean isCollidingWithLowerBorder(RectHitbox border);
    
}
