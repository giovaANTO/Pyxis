package it.unibo.pyxis.model.hitbox;

import java.util.Objects;
import java.util.Optional;

import it.unibo.pyxis.model.element.Element;
import it.unibo.pyxis.model.element.ball.Ball;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.DimensionImpl;
import it.unibo.pyxis.model.util.Vector;

public class BallHitbox extends AbstractHitbox {

    public BallHitbox(final Element element) {
        super(element);
    }

    /**
     * Checks what's the closest point of the {@link RectHitbox} to the center of the {@link BallHitbox}.
     *
     * @param cHBCenterCoord
     * @param rHBCenterCoord
     * @param rHBEdgeLength
     * @return cHBCenterCoord if the center of the {@link BallHitbox} is inside the {@link RectHitbox},
     * the Coordinate of the closest edge of the {@link RectHitbox} otherwise.
     */
    private double closestPointCalculation(final double cHBCenterCoord, final double rHBCenterCoord,
                                           final double rHBEdgeLength) {
        return cHBCenterCoord < rHBCenterCoord - rHBEdgeLength / 2
                ? rHBCenterCoord - rHBEdgeLength / 2
                : Math.min(cHBCenterCoord, rHBCenterCoord + rHBEdgeLength / 2);
    }

    /**
     * Return the offset to apply to the {@link Element} after the collision.
     *
     * @param distanceFromClosestPoint
     * @param componentDistance
     * @return The offset to apply to the {@link Element} after the collision.
     */
    private double cornerOffsetCalculation(final double distanceFromClosestPoint, final double componentDistance) {
        return (this.getRadius() - distanceFromClosestPoint) * componentDistance / this.getRadius();
    }

    /**
     * Return the radius of the {@link BallHitbox}.
     *
     * @return The radius of the {@link BallHitbox}.
     */
    private Double getRadius() {
        return getDimension().getHeight() / 2;
    }

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

        closestPointX = closestPointCalculation(bHBCenterX, rHBCenterX, rHBWidth);
        closestPointY = closestPointCalculation(bHBCenterY, rHBCenterY, rHBHeight);

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

        return isCollidingWithPoint(closestPointX, closestPointY)
                ? Optional.of(new CollisionInformation(hitEdge, borderOffset))
                : Optional.empty();
    }

    protected Optional<CollisionInformation> collidingEdgeWithSameHB(final Hitbox hitbox) {
        return getPosition().distance(hitbox.getPosition()) <= getRadius() + ((BallHitbox) hitbox).getRadius()
                ? Optional.of(new CollisionInformation(HitEdge.CIRCLE, new DimensionImpl()))
                : Optional.empty();
    }

    protected boolean isCollidingWithOtherHB(final Hitbox hitbox) {
        return collidingEdgeWithOtherHB(hitbox).isPresent();
    }

    @Override
    public Optional<CollisionInformation> collidingEdgeWithHB(final Hitbox hitbox) {
        return hitbox instanceof BallHitbox
                ? collidingEdgeWithSameHB(hitbox)
                : collidingEdgeWithOtherHB(hitbox);
    }

    @Override
    public boolean isCollidingWithHB(final Hitbox hitbox) {
        return hitbox instanceof BallHitbox
                ? isCollidingWithSameHB(hitbox)
                : isCollidingWithOtherHB(hitbox);
    }

    @Override
    public boolean isCollidingWithPoint(final Coord position) {
        return getPosition().distance(position) <= getRadius();
    }

    @Override
    public boolean isCollidingWithPoint(final double px, final double py) {
        return getPosition().distance(px, py) <= getRadius();
    }

    private Vector getPace() {
        return this.getElement().getPace();
    }

}
