package it.unibo.pyxis.model.hitbox;

import java.util.Optional;

import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;

public class RectHitbox extends AbstractHitbox {

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
