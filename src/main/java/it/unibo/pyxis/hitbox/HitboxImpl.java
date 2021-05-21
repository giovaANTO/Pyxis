package it.unibo.pyxis.hitbox;

import java.util.Optional;

import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.Dimension;
import it.unibo.pyxis.util.DimensionImpl;

public abstract class HitboxImpl implements Hitbox {
        
        private Coord position;
        private Dimension dimension;
        

        public HitboxImpl(Coord position, Dimension dimension) {
                this.position = position;
                this.dimension = dimension;
        }
        
        
        protected Coord getPosition() {
                return position;
        }
        
        
        protected Dimension getDimension() {
                return dimension;
        }
        
        
        public abstract boolean isCollidingWithPoint(Coord position);
        
        public abstract boolean isCollidingWithOtherHB(HitboxImpl hitbox);
        
        public abstract boolean isCollidingWithSameHB(HitboxImpl hitbox);
        
        public abstract Optional<HitEdge> collidingEdgeWithOtherHB(HitboxImpl hitbox);
        
        
        
        public static class CircleHitbox extends HitboxImpl {
            
            
            public CircleHitbox(Coord position, Double diameter) {
                super(position, new DimensionImpl(diameter, diameter));
            }
        
        
            public Double getRadius() {
                return getDimension().getHeight() / 2;
            }


            public boolean isCollidingWithPoint(Coord position) {
                return getPosition().distance(position) <= getRadius();
            }


            public boolean isCollidingWithSameHB(HitboxImpl hitbox) {
                return hitbox instanceof CircleHitbox
                        ? getPosition().distance(hitbox.getPosition()) <= getRadius() + ((CircleHitbox) hitbox).getRadius()
                        : false;
            }
            
            
            public boolean isCollidingWithOtherHB(HitboxImpl hitbox) {
                return collidingEdgeWithOtherHB(hitbox).isPresent();
            }


            public Optional<HitEdge> collidingEdgeWithOtherHB(HitboxImpl hitbox) {
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
                }
                else if (closestPointX == cHBCenterX && closestPointY != cHBCenterY) {
                        hitEdge = HitEdge.HORIZONTAL;
                }
                else {
                        hitEdge = HitEdge.VERTICAL;
                }
                
                                                
                return getPosition().distance(closestPointX, closestPointY) < getRadius() 
                        ? Optional.of(hitEdge)
                        : Optional.empty();
                
            }
        
            private double closestPointCalculation(double cHBCenterCoord, double rHBCenterCoord, double rHBEdgeLength) {
                return cHBCenterCoord < rHBCenterCoord - rHBEdgeLength / 2
                        ? rHBCenterCoord - rHBEdgeLength / 2
                                
                        : cHBCenterCoord > rHBCenterCoord + rHBEdgeLength / 2
                            ? rHBCenterCoord + rHBEdgeLength / 2
                            : cHBCenterCoord;
            }
            
        }
        
        
        public static class RectHitbox extends HitboxImpl {
            
            public RectHitbox(Coord position, Dimension dimension) {
                super(position, dimension);
            }

            
            public boolean isCollidingWithPoint(Coord position) {
                return Math.abs(position.getX() - getPosition().getX()) <= getDimension().getWidth() / 2 
                        && Math.abs(position.getY() - getPosition().getY()) <= getDimension().getHeight() / 2;
            }


            public boolean isCollidingWithSameHB(HitboxImpl hitbox) {
                return hitbox instanceof RectHitbox
                        ? Math.abs(getPosition().getX() - hitbox.getPosition().getX()) 
                              <= (getDimension().getWidth() / 2) + hitbox.getDimension().getWidth() / 2
                          && Math.abs(getPosition().getY() - hitbox.getPosition().getY()) 
                              <= (getDimension().getHeight() / 2) + hitbox.getDimension().getHeight() / 2
                        : false;
            }


            public boolean isCollidingWithOtherHB(HitboxImpl hitbox) {
                return hitbox.isCollidingWithOtherHB(this);
            }


            public Optional<HitEdge> collidingEdgeWithOtherHB(HitboxImpl hitbox) {
                return hitbox instanceof CircleHitbox 
                        ? hitbox.collidingEdgeWithOtherHB(this)
                        : Optional.empty();
            }
            
        }
        
        
}
