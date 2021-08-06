package it.unibo.pyxis.model.hitbox;

import java.util.Optional;

import it.unibo.pyxis.model.element.Element;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;

public interface Hitbox {

    /**
     * Check for a collision with the right, left and upper edge of a border with the parameter {@link Dimension}.
     *
     * @param borderDimension
     *
     * @return An {@link Optional} with the specified colliding {@link HitEdge} of the border, an EMPTY {@link Optional} if they are not colliding.
     */
    Optional<CollisionInformation> collidingEdgeWithBorder(Dimension borderDimension);
    /**
     * Check for a collision with a {@link Hitbox}.
     *
     * @param hitbox
     *
     * @return An {@link Optional} with the specified {@link HitEdge} the {@link Hitbox} is colliding with,
     * an empty {@link Optional} if they are not colliding.
     */
    Optional<CollisionInformation> collidingEdgeWithHB(Hitbox hitbox);
    /**
     * Return the dimension of the {@link Hitbox}.
     *
     * @return
     *          The {@link Dimension} of the {@link Hitbox}.
     */
    Dimension getDimension();
    /**
     * Return the {@link Element} bound to the {@link Hitbox}.
     *
     * @return
     *          The {@link Element} bound to the {@link Hitbox}.
     */
    Element getElement();
    /**
     * Return the position of the {@link Hitbox}.
     *
     * @return
     *          The {@link Coord} of the {@link Hitbox}.
     */
    Coord getPosition();
    /**
     * Check for a collision with a {@link Hitbox}.
     *
     * @param hitbox
     *          The {@link Hitbox} to check.
     * @return
     *          true if the two {@link Hitbox} are colliding, otherwise false.
     */
    boolean isCollidingWithHB(Hitbox hitbox);
    /**
     * Check for a collision with the lower edge of a border with the parameter
     * {@link Dimension}.
     *
     * @param borderDimension
     *
     * @return
     *          true if there is a collision, otherwise false.
     */
    boolean isCollidingWithLowerBorder(Dimension borderDimension);
    /**
     * Check for a collision with a {@link Coord}.
     *
     * @param position
     *
     * @return
     *          true is the point is situated inside the {@link Hitbox}, otherwise false.
     */
    boolean isCollidingWithPoint(Coord position);
    /**
     * Check for a collision with an input {@link Coord}.
     *
     * @param px
     *          The X input {@link Coord}.
     * @param py
     *          The Y input {@link Coord}.
     * @return
     *          true if the point is situated inside the {@link Hitbox}, otherwise false.
     */
    boolean isCollidingWithPoint(double px, double py);
}
