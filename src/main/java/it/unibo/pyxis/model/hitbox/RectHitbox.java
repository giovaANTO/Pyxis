package it.unibo.pyxis.model.hitbox;

import java.util.Optional;

import it.unibo.pyxis.model.element.Element;
import it.unibo.pyxis.model.util.Coord;

public class RectHitbox extends AbstractHitbox {

    public RectHitbox(final Element element) {
        super(element);
    }

    @Override
    public boolean isCollidingWithPoint(final Coord position) {
        return isCollidingWithPoint(position.getX(), position.getY());
    }

    @Override
    public boolean isCollidingWithPoint(final double px, final double py) {
        return Math.abs(px - getPosition().getX()) <= getDimension().getWidth() / 2 
                && Math.abs(py - getPosition().getY()) <= getDimension().getHeight() / 2;
    }

    @Override
    public boolean isCollidingWithHB(final Hitbox hitbox) {
        return hitbox instanceof RectHitbox
                ? isCollidingWithSameHB(hitbox)
                : isCollidingWithOtherHB(hitbox);
    }

    @Override
    public Optional<HitEdge> collidingEdgeWithHB(final Hitbox hitbox) {
        return hitbox instanceof RectHitbox
                ? collidingEdgeWithSameHB(hitbox)
                : collidingEdgeWithOtherHB(hitbox);
    }

    @Override
    protected Optional<HitEdge> collidingEdgeWithSameHB(final Hitbox hitbox) {

        double closestPointX;
        double closestPointY;

        HitEdge hitEdge;

        final double cHBCenterX = getPosition().getX();
        final double cHBCenterY = getPosition().getY();
        final double rHBCenterX = hitbox.getPosition().getX();
        final double rHBCenterY = hitbox.getPosition().getY();
        final double rHBWidth   = hitbox.getDimension().getWidth();
        final double rHBHeight  = hitbox.getDimension().getHeight();

        closestPointX = closestPointCalculation(cHBCenterX, rHBCenterX, rHBWidth);
        closestPointY = closestPointCalculation(cHBCenterY, rHBCenterY, rHBHeight);

        if (closestPointX != cHBCenterX && closestPointY != cHBCenterY) {
            hitEdge = HitEdge.CORNER;
        } else if (closestPointX == cHBCenterX && closestPointY != cHBCenterY) {
            hitEdge = HitEdge.HORIZONTAL;
        } else {
            hitEdge = HitEdge.VERTICAL;
        }

        return isCollidingWithPoint(closestPointX, closestPointY)
                    ? Optional.of(hitEdge)
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

    @Override
    protected Optional<HitEdge> collidingEdgeWithOtherHB(final Hitbox hitbox) {
        return !(hitbox instanceof RectHitbox)
                ? hitbox.collidingEdgeWithHB(this)
                : Optional.empty();
    }

}
