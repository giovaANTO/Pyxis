package it.unibo.pyxis.model.hitbox;

import java.util.Optional;

import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.DimensionImpl;

public abstract class HitboxImpl implements Hitbox {

        private final Coord position;
        private final Dimension dimension;

        public HitboxImpl(final Coord position, final Dimension dimension) {
                this.position = position;
                this.dimension = dimension;
        }

        @Override
        public Coord getPosition() {
                return this.position;
        }

        @Override
        public Dimension getDimension() {
                return this.dimension;
        }

        @Override
        public abstract boolean isCollidingWithPoint(Coord position);

        @Override
        public abstract boolean isCollidingWithOtherHB(Hitbox hitbox);

        @Override
        public abstract boolean isCollidingWithSameHB(Hitbox hitbox);

        @Override
        public abstract Optional<HitEdge> collidingEdgeWithOtherHB(Hitbox hitbox);

        public static class CircleHitbox extends HitboxImpl {

            public CircleHitbox(final Coord position, final Double diameter) {
                super(position, new DimensionImpl(diameter, diameter));
            }

            public Double getRadius() {
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

        public static class RectHitbox extends HitboxImpl {

            public RectHitbox(final Coord position, final Dimension dimension) {
                super(position, dimension);
            }

            @Override
            public boolean isCollidingWithPoint(final Coord position) {
                return Math.abs(position.getX() - getPosition().getX()) <= getDimension().getWidth() / 2 
                        && Math.abs(position.getY() - getPosition().getY()) <= getDimension().getHeight() / 2;
            }

            @Override
            public boolean isCollidingWithSameHB(final Hitbox hitbox) {
                return hitbox instanceof RectHitbox && Math.abs(getPosition().getX() - hitbox.getPosition().getX())
                        <= (getDimension().getWidth() / 2) + hitbox.getDimension().getWidth() / 2
                        && Math.abs(getPosition().getY() - hitbox.getPosition().getY())
                        <= (getDimension().getHeight() / 2) + hitbox.getDimension().getHeight() / 2;
            }

            @Override
            public boolean isCollidingWithOtherHB(final Hitbox hitbox) {
                return hitbox.isCollidingWithOtherHB(this);
            }

            @Override
            public Optional<HitEdge> collidingEdgeWithOtherHB(final Hitbox hitbox) {
                return hitbox instanceof CircleHitbox 
                        ? hitbox.collidingEdgeWithOtherHB(this)
                        : Optional.empty();
            }
        }
}
