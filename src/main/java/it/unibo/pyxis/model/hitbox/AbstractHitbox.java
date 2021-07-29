package it.unibo.pyxis.model.hitbox;

import java.util.Objects;
import java.util.Optional;

import it.unibo.pyxis.model.element.Element;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;

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
    public Optional<HitEdge> collidingEdgeWithBorder(final Dimension borderDimension) {

        final double cHBCenterX = getPosition().getX();
        final double cHBCenterY = getPosition().getY();
        final double cHBHalvedHeight = getDimension().getHeight() / 2;
        final double cHBHalvedWidth = getDimension().getWidth() / 2;
        final double bHBWidth   = borderDimension.getWidth();

        HitEdge hitEdge = null;

        if (checkBC(cHBCenterX, cHBHalvedWidth)
                || checkBC(bHBWidth - cHBCenterX, cHBHalvedWidth)) {
            hitEdge = HitEdge.VERTICAL;
        }
        if (checkBC(cHBCenterY, cHBHalvedHeight)) {
            hitEdge = Objects.isNull(hitEdge) 
                    ? HitEdge.HORIZONTAL
                    : HitEdge.CORNER;
        }
        return Optional.ofNullable(hitEdge);
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
    public abstract Optional<HitEdge> collidingEdgeWithHB(final Hitbox hitbox);

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
    protected abstract Optional<HitEdge> collidingEdgeWithSameHB(final Hitbox hitbox);

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
    protected abstract Optional<HitEdge> collidingEdgeWithOtherHB(final Hitbox hitbox);

}
