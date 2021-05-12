package it.unibo.pyxis.hitbox;

import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.Dimension;
import it.unibo.pyxis.util.DimensionImpl;

public abstract class Hitbox {
        
        private Coord position;
        private Dimension dimension;
        

        public Hitbox(Coord position, Dimension dimension) {
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
        
        public abstract boolean isCollidingWithRectHB(RectHitbox hitbox);
        
        public abstract boolean isCollidingWithRoundHB(CircleHitbox hitbox);
        
        
        
        public static class CircleHitbox extends Hitbox {
            
            
            public CircleHitbox(Coord position, Double diameter) {
                super(position, new DimensionImpl(diameter, diameter));
            }
        
        
            public Double getRadius() {
                return getDimension().getHeight() / 2;
            }


            public boolean isCollidingWithPoint(Coord position) {
                return getPosition().distance(position) <= getRadius();
            }


            public boolean isCollidingWithRoundHB(CircleHitbox hitbox) {
                return getPosition().distance(hitbox.getPosition()) <= getRadius() + hitbox.getRadius();
            }
            
            
            public boolean isCollidingWithRectHB(RectHitbox hitbox) {
                double closestPointX;
                double closestPointY;
                
                double cHBCenterX = getPosition().getX();
                double cHBCenterY = getPosition().getY();
                double rHBCenterX = hitbox.getPosition().getX();
                double rHBCenterY = hitbox.getPosition().getY();
                double rHBWidth   = hitbox.getDimension().getWidth();
                double rHBHeight  = hitbox.getDimension().getHeight();
                
                closestPointX = cHBCenterX < rHBCenterX - rHBWidth / 2
                                                ? rHBCenterX - rHBWidth / 2
                                                                
                                                : cHBCenterX > rHBCenterX + rHBWidth / 2
                                                        ? rHBCenterX + rHBWidth / 2
                                                        : cHBCenterX;
                
                closestPointY = cHBCenterY < rHBCenterY - rHBHeight / 2
                                                ? rHBCenterY - rHBHeight / 2
                                                                
                                                : cHBCenterY > rHBCenterY + rHBHeight / 2
                                                        ? rHBCenterY + rHBHeight / 2
                                                        : cHBCenterY;
                                                
                if (getPosition().distance(closestPointX, closestPointY) < getRadius()) {
                        return true;
                }
                return false;
                
            }
        
        }
        
        
        public static class RectHitbox extends Hitbox {
            
            public RectHitbox(Coord position, Dimension dimension) {
                super(position, dimension);
            }

            
            public boolean isCollidingWithPoint(Coord position) {
                return Math.abs(position.getX() - getPosition().getX()) <= getDimension().getWidth() / 2 
                        && Math.abs(position.getY() - getPosition().getY()) <= getDimension().getHeight() / 2;
            }


            public boolean isCollidingWithRectHB(RectHitbox hitbox) {
                return Math.abs(getPosition().getX() - hitbox.getPosition().getX()) 
                           <= (getDimension().getWidth() / 2) + hitbox.getDimension().getWidth() / 2
                       && Math.abs(getPosition().getY() - hitbox.getPosition().getY()) 
                           <= (getDimension().getHeight() / 2) + hitbox.getDimension().getHeight() / 2;
            }


            public boolean isCollidingWithRoundHB(CircleHitbox hitbox) {
                return hitbox.isCollidingWithRectHB(this);
            }           
            
        }
        
        
}
