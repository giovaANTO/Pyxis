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
     * Checks for a collision with a {@link Coord} of coordinates (px, py).
     * 
     * @param px
     * @param py
     * @return
     *          TRUE is the point is situated inside the {@link Hitbox}, otherwise FALSE.
     */
    boolean isCollidingWithPoint(double px, double py);

    /**
     * Checks for a collision with a {@link Hitbox}.
     * @param 
     *          hitbox
     * @return 
     *          TRUE if the two {@link Hitbox} are colliding, otherwise FALSE.
     */
    boolean isCollidingWithHB(Hitbox hitbox);

    /**
     * Checks for a collision with a {@link Hitbox}.
     * @param hitbox
     * @return
     *          An {@link Optional} with the specified {@link HitEdge} the {@link Hitbox} is colliding with,
     *          an empty {@link Optional} if they are not colliding.
     */
    Optional<HitEdge> collidingEdgeWithHB(Hitbox hitbox);

    /**
     * Checks for a collision with the right, left and upper edge of a border with the parameter {@link Dimension}.
     * @param 
     *          borderDimension
     * @return 
     *          An {@link Optional} with the specified colliding {@link HitEdge} of the border, an EMPTY {@link Optional} if they are not colliding.
     */
    Optional<HitEdge> collidingEdgeWithBorder(Dimension borderDimension);

    /**
     * Checks for a collision with the lower edge of a border with the parameter {@link Dimension}.
     * @param 
     *          borderDimension
     * @return 
     *          TRUE if there is a collision, otherwise FALSE.
     */
    boolean isCollidingWithLowerBorder(Dimension borderDimension);
    
}
