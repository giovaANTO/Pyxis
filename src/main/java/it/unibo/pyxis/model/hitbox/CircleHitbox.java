package it.unibo.pyxis.model.hitbox;

import java.util.Optional;

import it.unibo.pyxis.model.element.Element;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.DimensionImpl;

public class CircleHitbox extends AbstractHitbox {

    public CircleHitbox(final Element element) {
        super(element);
    }

    /**
     * Return the radius of the {@link CircleHitbox}.
     * @return
     *          the radius of the {@link CircleHitbox}.
     */
    private Double getRadius() {
        return getDimension().getHeight() / 2;
    }

    @Override
    public boolean isCollidingWithPoint(final Coord position) {
        return getPosition().distance(position) <= getRadius();
    }

    @Override
    public boolean isCollidingWithPoint(final double px, final double py) {
        return getPosition().distance(px, py) <= getRadius();
    }

    @Override
    public boolean isCollidingWithHB(final Hitbox hitbox) {
        return hitbox instanceof CircleHitbox
                ? isCollidingWithSameHB(hitbox)
                : isCollidingWithOtherHB(hitbox);
    }

    @Override
    public Optional<CollisionInformation> collidingEdgeWithHB(final Hitbox hitbox) {
        return hitbox instanceof CircleHitbox
                ? collidingEdgeWithSameHB(hitbox)
                : collidingEdgeWithOtherHB(hitbox);
    }

    protected Optional<CollisionInformation> collidingEdgeWithSameHB(final Hitbox hitbox) {
        return getPosition().distance(hitbox.getPosition()) <= getRadius() + ((CircleHitbox) hitbox).getRadius()
                ? Optional.of(new CollisionInformation(HitEdge.CIRCLE, new DimensionImpl()))
                : Optional.empty();
    }

    protected boolean isCollidingWithOtherHB(final Hitbox hitbox) {
        return collidingEdgeWithOtherHB(hitbox).isPresent();
    }

    protected Optional<CollisionInformation> collidingEdgeWithOtherHB(final Hitbox hitbox) {

        double closestPointX;
        double closestPointY;

        HitEdge hitEdge;
        final Dimension borderOffset = new DimensionImpl();

        final double cHBCenterX = this.getPosition().getX();
        final double cHBCenterY = this.getPosition().getY();
        final double rHBCenterX = hitbox.getPosition().getX();
        final double rHBCenterY = hitbox.getPosition().getY();
        final double rHBWidth   = hitbox.getDimension().getWidth();
        final double rHBHeight  = hitbox.getDimension().getHeight();

        closestPointX = closestPointCalculation(cHBCenterX, rHBCenterX, rHBWidth);
        closestPointY = closestPointCalculation(cHBCenterY, rHBCenterY, rHBHeight);

        if (closestPointX != cHBCenterX && closestPointY != cHBCenterY) {
            borderOffset.setWidth(widthOffsetCalculation(Math.abs(cHBCenterX - closestPointX)));
            borderOffset.setHeight(heightOffsetCalculation(Math.abs(cHBCenterY - closestPointY)));
            hitEdge = HitEdge.CORNER;
        } else if (closestPointX != cHBCenterX && closestPointY == cHBCenterY) {
            borderOffset.setWidth(widthOffsetCalculation(Math.abs(cHBCenterX - closestPointX)));
            hitEdge = HitEdge.VERTICAL;
        } else if (closestPointX == cHBCenterX && closestPointY != cHBCenterY){
            borderOffset.setHeight(heightOffsetCalculation(Math.abs(cHBCenterY - closestPointY)));
            hitEdge = HitEdge.HORIZONTAL;
        } else {
            if (Math.min(cHBCenterX, rHBWidth - cHBCenterX) <= Math.min(cHBCenterY, rHBHeight - cHBCenterY)) {
                borderOffset.setWidth(widthOffsetCalculation(Math.min(cHBCenterX, rHBWidth - cHBCenterX)));
                hitEdge = HitEdge.VERTICAL;
            } else {
                borderOffset.setHeight(heightOffsetCalculation(Math.min(cHBCenterY, rHBHeight - cHBCenterY)));
                hitEdge = HitEdge.HORIZONTAL;
            }
        }

        return isCollidingWithPoint(closestPointX, closestPointY)
                ? Optional.of(new CollisionInformation(hitEdge, borderOffset))
                : Optional.empty();
    }

    /**
     * Checks what's the closest point of the {@link RectHitbox} to the center of the {@link CircleHitbox}.
     * @param cHBCenterCoord
     * @param rHBCenterCoord
     * @param rHBEdgeLength
     * @return
     *          cHBCenterCoord if the center of the {@link CircleHitbox} is inside the {@link RectHitbox},
     *          the Coordinate of the closest edge of the {@link RectHitbox} otherwise.
     */
    private double closestPointCalculation(final double cHBCenterCoord, final double rHBCenterCoord,
                                           final double rHBEdgeLength) {
        return cHBCenterCoord < rHBCenterCoord - rHBEdgeLength / 2
                ? rHBCenterCoord - rHBEdgeLength / 2
                : Math.min(cHBCenterCoord, rHBCenterCoord + rHBEdgeLength / 2);
    }

}
