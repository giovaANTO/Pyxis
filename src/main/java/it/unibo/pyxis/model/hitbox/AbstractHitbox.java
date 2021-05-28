package it.unibo.pyxis.model.hitbox;

import java.util.Objects;
import java.util.Optional;

import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;

public abstract class AbstractHitbox implements Hitbox {

    private Coord position;
    private final Dimension dimension;

    public AbstractHitbox(final Coord position, final Dimension dimension) {
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
    public void setPosition(final Coord position) {
        this.position = position;
    }

    @Override
    public Optional<HitEdge> collidingEdgeWithBorder(final Hitbox border) {

        final double cHBCenterX = getPosition().getX();
        final double cHBCenterY = getPosition().getY();
        final double cHBHalvedHeight = getDimension().getHeight() / 2;
        final double cHBHalvedWidth = getDimension().getWidth() / 2;
        final double rHBCenterX = border.getPosition().getX();
        final double rHBCenterY = border.getPosition().getY();
        final double rHBWidth   = border.getDimension().getWidth();
        final double rHBHeight  = border.getDimension().getHeight();

        HitEdge hitEdge = null;

        if (checkBC(cHBCenterX, rHBCenterX, rHBWidth, cHBHalvedWidth)
                || checkBC(rHBCenterX, cHBCenterX, rHBWidth, cHBHalvedWidth)) {
            hitEdge = HitEdge.VERTICAL;
        }
        if (checkBC(cHBCenterY, rHBCenterY, rHBHeight, cHBHalvedHeight)) {
            hitEdge = Objects.isNull(hitEdge) 
                    ? HitEdge.HORIZONTAL
                    : HitEdge.CORNER;
        }
        return Optional.ofNullable(hitEdge);
    }

    @Override
    public boolean isCollidingWithLowerBorder(final Hitbox border) {
        return checkBC(border.getPosition().getY(), getPosition().getY(),
                border.getDimension().getHeight(), getDimension().getHeight() / 2);
    }

    /**
     * Check for a collision with one of the borders.
     * @param addedValue
     * @param subtractedValue
     * @param addedHalvedValue
     * @param collisionDistance
     * @return
     *          TRUE if the calculation [addedValue - subtractedValue + addedHalvedValue/2] is less than or equal to [collisionDistance], 
     *          FALSE otherwise.
     */
    private boolean checkBC(final double addedValue, final double subtractedValue,
                            final double addedHalvedValue, final double collisionDistance) {
        return addedValue - subtractedValue + addedHalvedValue/2 <= collisionDistance;
    }

    @Override
    public abstract boolean isCollidingWithPoint(Coord position);

    @Override
    public abstract boolean isCollidingWithOtherHB(Hitbox hitbox);

    @Override
    public abstract boolean isCollidingWithSameHB(Hitbox hitbox);

    @Override
    public abstract Optional<HitEdge> collidingEdgeWithOtherHB(Hitbox hitbox);

}
