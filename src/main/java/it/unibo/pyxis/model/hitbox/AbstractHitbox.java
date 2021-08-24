package it.unibo.pyxis.model.hitbox;

import java.util.Objects;
import java.util.Optional;

import it.unibo.pyxis.model.element.Element;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.DimensionImpl;

public abstract class AbstractHitbox implements Hitbox {

    private final Element element;

    public AbstractHitbox(final Element element) {
        this.element = element;
    }
    /**
     * Checks if the distance from the border is small enough
     * to have a collision.
     * @param distanceFromBorder The distance from the border.
     * @param collisionDistance  The distance required
     *                  to have a collision.
     *
     * @return TRUE if the distance from the border is less than or equal to
     *                  the distance required to have a collision,
     *                  FALSE otherwise.
     */
    private boolean checkBorderCollision(final double distanceFromBorder, final double collisionDistance) {
        return distanceFromBorder <= collisionDistance;
    }
    /**
     * Checks for a collision with the different type {@link Hitbox}.
     * @param hitbox The different type {@link Hitbox}.
     * 
     * @return An {@link Optional} with the specified {@link CollidingInformation},
     *                  an EMPTY {@link Optional} if they are the same or not colliding.
     */
    protected abstract Optional<CollisionInformation> collidingEdgeWithOtherHB(Hitbox hitbox);
    /**
     * Checks for a collision with the same type {@link Hitbox}.
     * @param hitbox The same type {@link Hitbox}.
     * 
     * @return An {@link Optional} with the specified {@link CollidingInformation},
     *                  an EMPTY {@link Optional} if they are different or not colliding.
     */
    protected abstract Optional<CollisionInformation> collidingEdgeWithSameHB(Hitbox hitbox);
    /**
     * Return the offset to apply to the {@link Element} after the collision.
     * @param distanceFromCenter The distance from the center.
     * 
     * @return The offset to apply to the {@link Element} after the collision.
     */
    protected final Double heightOffsetCalculation(final Double distanceFromCenter) {
        return this.getDimension().getHeight() / 2 - distanceFromCenter;
    }
    /**
     * Checks for a collision with the different type {@link Hitbox}.
     * @param hitbox The different type {@link Hitbox}.
     * 
     * @return TRUE if the two {@link Hitbox} are different and colliding, otherwise FALSE.
     */
    protected final boolean isCollidingWithOtherHB(final Hitbox hitbox) {
        return collidingEdgeWithOtherHB(hitbox).isPresent();
    }
    /**
     * Checks for a collision with the same type {@link Hitbox}.
     * @param hitbox The same type {@link Hitbox}.
     * 
     * @return TRUE if the two {@link Hitbox} are the same and colliding, otherwise FALSE.
     */
    protected final boolean isCollidingWithSameHB(final Hitbox hitbox) {
        return collidingEdgeWithSameHB(hitbox).isPresent();
    }
    /**
     * Returns the offset to apply to the {@link Element} after the collision.
     * @param distanceFromCenter The distance from the center.
     * 
     * @return The offset to apply to the {@link Element} after the collision.
     */
    protected final Double widthOffsetCalculation(final Double distanceFromCenter) {
        return this.getDimension().getWidth() / 2 - distanceFromCenter;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final Optional<CollisionInformation> collidingInformationWithBorder(final Dimension borderDimension) {

        final double cHBCenterX = getPosition().getX();
        final double cHBCenterY = getPosition().getY();
        final double cHBHalvedHeight = getDimension().getHeight() / 2;
        final double cHBHalvedWidth = getDimension().getWidth() / 2;
        final double bHBWidth = borderDimension.getWidth();

        HitEdge hitEdge = null;
        final Dimension borderOffset = new DimensionImpl();

        if (checkBorderCollision(cHBCenterX, cHBHalvedWidth)) {
            borderOffset.setWidth(widthOffsetCalculation(cHBCenterX));
            hitEdge = HitEdge.VERTICAL;
        } else if (checkBorderCollision(bHBWidth - cHBCenterX, cHBHalvedWidth)) {
            borderOffset.setWidth(widthOffsetCalculation(bHBWidth - cHBCenterX));
            hitEdge = HitEdge.VERTICAL;
        }
        if (checkBorderCollision(cHBCenterY, cHBHalvedHeight)) {
            borderOffset.setHeight(heightOffsetCalculation(cHBCenterY));
            hitEdge = Objects.isNull(hitEdge)
                    ? HitEdge.HORIZONTAL
                    : HitEdge.CORNER;
        }
        return !Objects.isNull(hitEdge)
                ? Optional.of(new CollisionInformationImpl(hitEdge, borderOffset))
                : Optional.empty();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final Dimension getDimension() {
        return element.getDimension();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final Element getElement() {
        return element;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final Coord getPosition() {
        return element.getPosition();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean isCollidingWithLowerBorder(final Dimension borderDimension) {
        return checkBorderCollision(borderDimension.getHeight() - this.getPosition().getY(), this.getDimension().getHeight() / 2);
    }
}
