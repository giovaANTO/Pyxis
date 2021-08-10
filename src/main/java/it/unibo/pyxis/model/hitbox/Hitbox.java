package it.unibo.pyxis.model.hitbox;

import java.util.Optional;

import it.unibo.pyxis.model.element.Element;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;

public interface Hitbox {

    /**
     * Checks for a collision with the right, left and upper edge of a border with the parameter {@link Dimension}.
     *
     * @param borderDimension
     * @return An {@link Optional} with the specified colliding {@link HitEdge} of the border, an EMPTY {@link Optional} if they are not colliding.
     */
    Optional<CollisionInformationImpl> collidingEdgeWithBorder(Dimension borderDimension);
    /**
     * Checks for a collision with a {@link Hitbox}.
     *
     * @param hitbox
     * @return An {@link Optional} with the specified {@link HitEdge} the {@link Hitbox} is colliding with,
     * an empty {@link Optional} if they are not colliding.
     */
    Optional<CollisionInformationImpl> collidingEdgeWithHB(Hitbox hitbox);
    /**
     * Returns the dimension of the {@link Hitbox}.
     *
     * @return The {@link Dimension} of the {@link Hitbox}.
     */
    Dimension getDimension();
    /**
     * Returns the {@link Element} bound to the {@link Hitbox}.
     *
     * @return The {@link Element} bound to the {@link Hitbox}.
     */
    Element getElement();
    /**
     * Returns the position of the {@link Hitbox}.
     *
     * @return The {@link Coord} of the {@link Hitbox}.
     */
    Coord getPosition();
    /**
     * Checks for a collision with a {@link Hitbox}.
     *
     * @param hitbox The {@link Hitbox} to check.
     * @return True if the two {@link Hitbox} are colliding.
     *         False otherwise.
     */
    boolean isCollidingWithHB(Hitbox hitbox);
    /**
     * Checks for a collision with the lower edge of a border with the parameter
     * {@link Dimension}.
     *
     * @param borderDimension
     *
     * @return True if there is a collision.
     *         False otherwise.
     */
    boolean isCollidingWithLowerBorder(Dimension borderDimension);
    /**
     * Checks for a collision with a {@link Coord}.
     *
     * @param position
     *
     * @return True is the point is situated inside the {@link Hitbox}.
     *         False otherwise.
     */
    boolean isCollidingWithPoint(Coord position);
    /**
     * Checks for a collision with an input {@link Coord}.
     *
     * @param px The X input {@link Coord}.
     * @param py The Y input {@link Coord}.
     * @return True if the point is situated inside the {@link Hitbox}.
     *         False otherwise.
     */
    boolean isCollidingWithPoint(double px, double py);
}
