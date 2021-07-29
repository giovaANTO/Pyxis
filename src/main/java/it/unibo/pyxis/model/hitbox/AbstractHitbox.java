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

    @Override
    public Coord getPosition() {
        return element.getPosition();
    }

    @Override
    public Dimension getDimension() {
        return element.getDimension();
    }

    @Override
    public Optional<CollisionInformation> collidingEdgeWithBorder(final Dimension borderDimension) {

        final double cHBCenterX = getPosition().getX();
        final double cHBCenterY = getPosition().getY();
        final double cHBHalvedHeight = getDimension().getHeight() / 2;
        final double cHBHalvedWidth = getDimension().getWidth() / 2;
        final double bHBWidth   = borderDimension.getWidth();

        HitEdge hitEdge = null;
        final Dimension borderOffset = new DimensionImpl();

        if (checkBC(cHBCenterX, cHBHalvedWidth)) {
            borderOffset.setWidth(widthOffsetCalculation(cHBCenterX));
            hitEdge = HitEdge.VERTICAL;
        } else if (checkBC(bHBWidth - cHBCenterX, cHBHalvedWidth)) {
            borderOffset.setWidth(widthOffsetCalculation(bHBWidth - cHBCenterX));
            hitEdge = HitEdge.VERTICAL;
        }
        if (checkBC(cHBCenterY, cHBHalvedHeight)) {
            borderOffset.setHeight(heightOffsetCalculation(cHBCenterY));
            hitEdge = Objects.isNull(hitEdge) 
                    ? HitEdge.HORIZONTAL
                    : HitEdge.CORNER;
        }
        return !Objects.isNull(hitEdge)
                ? Optional.of(new CollisionInformation(hitEdge, borderOffset))
                : Optional.empty();
    }

    @Override
    public boolean isCollidingWithLowerBorder(final Dimension borderDimension) {
        return checkBC(borderDimension.getHeight() - this.getPosition().getY(), this.getDimension().getHeight() / 2);
    }

    /**
     * Check for a collision with one of the borders.
     * @param addedValue
     * @param subtractedValue
     * @param addedHalvedValue
     * @param collisionDistance
     * @return
     *          TRUE if the calculation [addedValue - subtractedValue + addedHalvedValue/2] is less than or equal to [collisionDistance], 
     *          FALSE otherwise.
     */
    private boolean checkBC(final double distanceFromBorder, final double collisionDistance) {
        return distanceFromBorder <= collisionDistance;
    }

    @Override
    public abstract boolean isCollidingWithPoint(final Coord position);

    @Override
    public abstract boolean isCollidingWithPoint(final double px, final double py);

    @Override
    public abstract boolean isCollidingWithHB(final Hitbox hitbox);

    @Override
    public abstract Optional<CollisionInformation> collidingEdgeWithHB(final Hitbox hitbox);

    /**
     * Checks for a collision with the same {@link Hitbox}.
     * @param 
     *          hitbox
     * @return 
     *          TRUE if the two {@link Hitbox} are the same and colliding, otherwise FALSE.
     */
    protected boolean isCollidingWithSameHB(final Hitbox hitbox) {
        return collidingEdgeWithSameHB(hitbox).isPresent();
    }

    /**
     * Checks for a collision with the same {@link Hitbox}.
     * @param 
     *          hitbox
     * @return 
     *          An {@link Optional} with the specified {@link HitEdge} the {@link RectHitbox} is colliding with,
     *          an EMPTY {@link Optional} if they are different or not colliding.
     */
    protected abstract Optional<CollisionInformation> collidingEdgeWithSameHB(final Hitbox hitbox);

    /**
     * Checks for a collision with the different {@link Hitbox}.
     * @param 
     *          hitbox
     * @return 
     *          TRUE if the two {@link Hitbox} are different and colliding, otherwise FALSE.
     */
    protected boolean isCollidingWithOtherHB(final Hitbox hitbox) {
        return collidingEdgeWithOtherHB(hitbox).isPresent();
    }

    /**
     * Checks for a collision with the different {@link Hitbox}.
     * @param 
     *          hitbox
     * @return 
     *          An {@link Optional} with the specified {@link HitEdge} the {@link RectHitbox} is colliding with,
     *          an EMPTY {@link Optional} if they are the same or not colliding.
     */
    protected abstract Optional<CollisionInformation> collidingEdgeWithOtherHB(final Hitbox hitbox);

    protected Double widthOffsetCalculation(final Double distanceFromCenter) {
        return this.getDimension().getWidth() / 2 - distanceFromCenter;
    }

    protected Double heightOffsetCalculation(final Double distanceFromCenter) {
        return this.getDimension().getHeight() / 2 - distanceFromCenter;
    }
}
