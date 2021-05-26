package it.unibo.pyxis.hitbox;

import java.util.Optional;

import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.DimensionImpl;

public class CircleHitbox extends AbstractHitbox {


    public CircleHitbox(final Coord position, final Double diameter) {
        super(position, new DimensionImpl(diameter, diameter));
    }

    private Double getRadius() {
        return getDimension().getHeight() / 2;
    }

    @Override
    public boolean isCollidingWithPoint(final Coord position) {
        return getPosition().distance(position) <= getRadius();
    }

    @Override
    public boolean isCollidingWithSameHB(final Hitbox hitbox) {
        return hitbox instanceof CircleHitbox
                && getPosition().distance(hitbox.getPosition()) <= getRadius() + ((CircleHitbox) hitbox).getRadius();
    }

    @Override
    public boolean isCollidingWithOtherHB(final Hitbox hitbox) {
        return collidingEdgeWithOtherHB(hitbox).isPresent();
    }

    @Override
    public Optional<HitEdge> collidingEdgeWithOtherHB(final Hitbox hitbox) {
        if (hitbox instanceof CircleHitbox) {
            return Optional.empty();
        }

        double closestPointX;
        double closestPointY;

        HitEdge hitEdge;

        double cHBCenterX = getPosition().getX();
        double cHBCenterY = getPosition().getY();
        double rHBCenterX = hitbox.getPosition().getX();
        double rHBCenterY = hitbox.getPosition().getY();
        double rHBWidth   = hitbox.getDimension().getWidth();
        double rHBHeight  = hitbox.getDimension().getHeight();

        closestPointX = closestPointCalculation(cHBCenterX, rHBCenterX, rHBWidth);
        closestPointY = closestPointCalculation(cHBCenterY, rHBCenterY, rHBHeight);

        if (closestPointX != cHBCenterX && closestPointY != cHBCenterY) {
            hitEdge = HitEdge.CORNER;
        } else if (closestPointX == cHBCenterX && closestPointY != cHBCenterY) {
                hitEdge = HitEdge.HORIZONTAL;
        } else {
                hitEdge = HitEdge.VERTICAL;
        }

        return getPosition().distance(closestPointX, closestPointY) < getRadius()
                ? Optional.of(hitEdge)
                : Optional.empty();
    }

    private double closestPointCalculation(final double cHBCenterCoord, final double rHBCenterCoord,
                                           final double rHBEdgeLength) {
        return cHBCenterCoord < rHBCenterCoord - rHBEdgeLength / 2
                ? rHBCenterCoord - rHBEdgeLength / 2
                : Math.min(cHBCenterCoord, rHBCenterCoord + rHBEdgeLength / 2);
    }

}
