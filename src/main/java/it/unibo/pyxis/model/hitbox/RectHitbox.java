package it.unibo.pyxis.model.hitbox;

import java.util.Optional;

import it.unibo.pyxis.model.element.Element;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.DimensionImpl;

public class RectHitbox extends AbstractHitbox {

    public RectHitbox(final Element element) {
        super(element);
    }

    /**
     * Calculation of the value of the closest point of the first
     * {@link RectHitbox} from the center of the second {@link RectHitbox}.
     * @param sHBCenterValue The value of the center of the first {@link RectHitbox}.
     * @param fHBCenterValue The value of the center of the second {@link RectHitbox}.
     * @param rHBEdgeLength The lenght of the edge of the {@link RectHitbox}.
     * 
     * @return cHBCenterCoord if the center of the {@link BallHitbox} is inside the {@link RectHitbox},
     *                  the Coordinate of the closest edge of the {@link RectHitbox} otherwise.
     */
    private double closestPointComponentCalculation(final double sHBCenterValue, final double fHBCenterValue,
                                           final double rHBEdgeLength) {
        return sHBCenterValue < fHBCenterValue - rHBEdgeLength / 2
                ? fHBCenterValue - rHBEdgeLength / 2
                : Math.min(sHBCenterValue, fHBCenterValue + rHBEdgeLength / 2);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    protected Optional<CollisionInformation> collidingEdgeWithOtherHB(final Hitbox hitbox) {
        return !(hitbox instanceof RectHitbox)
                ? hitbox.collidingInformationWithHB(this)
                : Optional.empty();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    protected Optional<CollisionInformation> collidingEdgeWithSameHB(final Hitbox hitbox) {

        double closestPointX;
        double closestPointY;

        HitEdge hitEdge;
        final Dimension edgeOffset = new DimensionImpl();

        final double bHBCenterX = getPosition().getX();
        final double bHBCenterY = getPosition().getY();
        final double rHBCenterX = hitbox.getPosition().getX();
        final double rHBCenterY = hitbox.getPosition().getY();
        final double rHBWidth = hitbox.getDimension().getWidth();
        final double rHBHeight = hitbox.getDimension().getHeight();

        closestPointX = closestPointComponentCalculation(bHBCenterX, rHBCenterX, rHBWidth);
        closestPointY = closestPointComponentCalculation(bHBCenterY, rHBCenterY, rHBHeight);

        if (closestPointX != bHBCenterX && closestPointY != bHBCenterY) {
            edgeOffset.setWidth(widthOffsetCalculation(Math.abs(bHBCenterX - closestPointX)));
            edgeOffset.setHeight(heightOffsetCalculation(Math.abs(bHBCenterY - closestPointY)));
            hitEdge = HitEdge.CORNER;
        } else if (closestPointX != bHBCenterX && closestPointY == bHBCenterY) {
            edgeOffset.setWidth(widthOffsetCalculation(Math.abs(bHBCenterX - closestPointX)));
            hitEdge = HitEdge.VERTICAL;
        } else if (closestPointX == bHBCenterX && closestPointY != bHBCenterY) {
            edgeOffset.setHeight(heightOffsetCalculation(Math.abs(bHBCenterY - closestPointY)));
            hitEdge = HitEdge.HORIZONTAL;
        } else {
            if (Math.min(bHBCenterX, rHBWidth - bHBCenterX) <= Math.min(bHBCenterY, rHBHeight - bHBCenterY)) {
                edgeOffset.setWidth(widthOffsetCalculation(Math.min(bHBCenterX, rHBWidth - bHBCenterX)));
                hitEdge = HitEdge.VERTICAL;
            } else {
                edgeOffset.setHeight(heightOffsetCalculation(Math.min(bHBCenterY, rHBHeight - bHBCenterY)));
                hitEdge = HitEdge.HORIZONTAL;
            }
        }

        return this.isCollidingWithPoint(closestPointX, closestPointY)
                ? Optional.of(new CollisionInformationImpl(hitEdge, edgeOffset))
                : Optional.empty();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<CollisionInformation> collidingInformationWithHB(final Hitbox hitbox) {
        return hitbox instanceof RectHitbox
                ? this.collidingEdgeWithSameHB(hitbox)
                : this.collidingEdgeWithOtherHB(hitbox);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCollidingWithHB(final Hitbox hitbox) {
        return hitbox instanceof RectHitbox
                ? this.isCollidingWithSameHB(hitbox)
                : this.isCollidingWithOtherHB(hitbox);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCollidingWithPoint(final Coord position) {
        return this.isCollidingWithPoint(position.getX(), position.getY());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCollidingWithPoint(final double px, final double py) {
        return Math.abs(px - this.getPosition().getX()) <= this.getDimension().getWidth() / 2
                && Math.abs(py - this.getPosition().getY()) <= this.getDimension().getHeight() / 2;
    }
}
