package it.unibo.pyxis.model.hitbox;

import java.util.Objects;
import java.util.Optional;

import it.unibo.pyxis.model.element.Element;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.DimensionImpl;
import it.unibo.pyxis.model.util.Vector;

public class BallHitbox extends AbstractHitbox {

    public BallHitbox(final Element element) {
        super(element);
    }
    /**
     * Calculation of the value of the closest point of the
     * {@link RectHitbox} from the center of the {@link BallHitbox}.
     * @param bHBCenterValue The value of the center of the {@link BallHitbox}.
     * @param rHBCenterValue The value of the center of the {@link RectHitbox}.
     * @param rHBEdgeLength The lenght of the edge of the {@link RectHitbox}.
     * 
     * @return cHBCenterCoord if the center of the {@link BallHitbox} is inside the {@link RectHitbox},
     *                  the Coordinate of the closest edge of the {@link RectHitbox} otherwise.
     */
    private double closestPointComponentCalculation(final double bHBCenterValue, final double rHBCenterValue,
                                           final double rHBEdgeLength) {
        return bHBCenterValue < rHBCenterValue - rHBEdgeLength / 2
                ? rHBCenterValue - rHBEdgeLength / 2
                : Math.min(bHBCenterValue, rHBCenterValue + rHBEdgeLength / 2);
    }
    /**
     * Returns the component of the offset to apply
     * to the {@link it.unibo.pyxis.model.element.Element} after the collision.
     * @param distanceFromClosestPoint The distance from
     *                  the closest point of the {@link RectHitbox}
     *                  to the center of the {@link BallHitbox}.
     * @param distanceComponent The component of the distance from
     *                  the closest point of the {@link RectHitbox}
     *                  to the center of the {@link BallHitbox}.
     * 
     * @return The offset to apply to the {@link it.unibo.pyxis.model.element.Element} after the collision.
     */
    private double cornerOffsetCalculation(final double distanceFromClosestPoint, final double distanceComponent) {
        return (this.getRadius() - distanceFromClosestPoint) * distanceComponent / this.getRadius();
    }
    /**
     * Returns the radius of the {@link BallHitbox}.
     *
     * @return The radius of the {@link BallHitbox}.
     */
    private Double getRadius() {
        return getDimension().getHeight() / 2;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    protected Optional<CollisionInformation> collidingEdgeWithOtherHB(final Hitbox hitbox) {

        double closestPointX;
        double closestPointY;

        HitEdge hitEdge = null;
        final Dimension borderOffset = new DimensionImpl();

        final double bHBCenterX = this.getPosition().getX();
        final double bHBCenterY = this.getPosition().getY();
        final double rHBCenterX = hitbox.getPosition().getX();
        final double rHBCenterY = hitbox.getPosition().getY();
        final double rHBWidth = hitbox.getDimension().getWidth();
        final double rHBHeight = hitbox.getDimension().getHeight();

        closestPointX = closestPointComponentCalculation(bHBCenterX, rHBCenterX, rHBWidth);
        closestPointY = closestPointComponentCalculation(bHBCenterY, rHBCenterY, rHBHeight);

        if (closestPointX != bHBCenterX && closestPointY != bHBCenterY) {
            borderOffset.setWidth(cornerOffsetCalculation(this.getPosition().distance(closestPointX, closestPointY),
                    Math.abs(bHBCenterX - closestPointX)));
            borderOffset.setHeight(cornerOffsetCalculation(this.getPosition().distance(closestPointX, closestPointY),
                    Math.abs(bHBCenterY - closestPointY)));
            if (bHBCenterX <= rHBCenterX && this.getPace().getX() > 0
                    || bHBCenterX > rHBCenterX && this.getPace().getX() < 0) {
                hitEdge = HitEdge.VERTICAL;
            }
            if (bHBCenterY <= rHBCenterY && this.getPace().getY() > 0
                    || bHBCenterY > rHBCenterY && this.getPace().getY() < 0) {
                hitEdge = Objects.isNull(hitEdge)
                        ? HitEdge.HORIZONTAL
                        : HitEdge.CORNER;
            }
        } else if (closestPointX != bHBCenterX && closestPointY == bHBCenterY) {
            borderOffset.setWidth(widthOffsetCalculation(Math.abs(bHBCenterX - closestPointX)));
            hitEdge = HitEdge.VERTICAL;
        } else if (closestPointX == bHBCenterX && closestPointY != bHBCenterY) {
            borderOffset.setHeight(heightOffsetCalculation(Math.abs(bHBCenterY - closestPointY)));
            hitEdge = bHBCenterY > rHBCenterY
                    ? HitEdge.HORIZONTAL
                    : HitEdge.TOP;
        } else {
            if (Math.min(bHBCenterX, rHBWidth - bHBCenterX) <= Math.min(bHBCenterY, rHBHeight - bHBCenterY)) {
                borderOffset.setWidth(widthOffsetCalculation(Math.min(bHBCenterX, rHBWidth - bHBCenterX)));
                hitEdge = HitEdge.VERTICAL;
            } else {
                borderOffset.setHeight(heightOffsetCalculation(Math.min(bHBCenterY, rHBHeight - bHBCenterY)));
                hitEdge = HitEdge.HORIZONTAL;
            }
        }

        return this.isCollidingWithPoint(closestPointX, closestPointY)
                ? Optional.of(new CollisionInformationImpl(hitEdge, borderOffset))
                : Optional.empty();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    protected Optional<CollisionInformation> collidingEdgeWithSameHB(final Hitbox hitbox) {
        return this.getPosition().distance(hitbox.getPosition()) <= this.getRadius() + ((BallHitbox) hitbox).getRadius()
                ? Optional.of(new CollisionInformationImpl(HitEdge.CIRCLE, new DimensionImpl()))
                : Optional.empty();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<CollisionInformation> collidingInformationWithHB(final Hitbox hitbox) {
        return hitbox instanceof BallHitbox
                ? this.collidingEdgeWithSameHB(hitbox)
                : this.collidingEdgeWithOtherHB(hitbox);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCollidingWithHB(final Hitbox hitbox) {
        return hitbox instanceof BallHitbox
                ? this.isCollidingWithSameHB(hitbox)
                : this.isCollidingWithOtherHB(hitbox);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCollidingWithPoint(final Coord position) {
        return this.getPosition().distance(position) <= this.getRadius();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCollidingWithPoint(final double px, final double py) {
        return this.getPosition().distance(px, py) <= this.getRadius();
    }
    /**
     * Returns the pace of the {@link it.unibo.pyxis.model.element.Element}
     * of the {@link BallHitbox}.
     * @return The pace of the {@link it.unibo.pyxis.model.element.Element}
     *                  of the {@link BallHitbox}.
     */
    private Vector getPace() {
        return this.getElement().getPace();
    }
}
