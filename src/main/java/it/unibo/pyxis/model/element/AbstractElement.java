package it.unibo.pyxis.model.element;

import it.unibo.pyxis.model.hitbox.Hitbox;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;

import java.util.Objects;

public abstract class AbstractElement implements Element {

    private static final double UPDATE_TIME_MULTIPLIER = 0.001;
    private final Dimension dimension;
    private final Coord position;
    private Hitbox hitbox;

    public AbstractElement(final Dimension inputDimension, final Coord inputPosition) {
        this.dimension = inputDimension;
        this.position = inputPosition;
    }

    @Override
    public final Dimension getDimension() {
        return this.dimension.copyOf();
    }

    @Override
    public final Coord getPosition() {
        return this.position.copyOf();
    }

    @Override
    public final double getUpdateTimeMultiplier() {
        return UPDATE_TIME_MULTIPLIER;
    }

    /**
     * Sets the {@link Hitbox} of the {@link Element} as the parameter {@link Hitbox}.
     * @param hitbox
     */
    protected void setHitbox(final Hitbox hitbox) {
        this.hitbox = hitbox;
    }

    @Override
    public final Hitbox getHitbox() {
        return this.hitbox;
    }

    @Override
    public final void setPosition(final Coord inputPosition) {
        Objects.requireNonNull(inputPosition, "Error, tried to set null position.");
        this.position.setXY(inputPosition.getX(), inputPosition.getY());
    }

    @Override
    public final void setWidth(final double inputWidth) {
        this.dimension.setWidth(inputWidth);
    }

    @Override
    public final void setHeight(final double inputHeight) {
        this.dimension.setHeight(inputHeight);
    }

    @Override
    public final void increaseWidth(final double increaseValue) {
        this.dimension.increaseWidth(increaseValue);
    }

    @Override
    public final void increaseHeight(final double increaseValue) {
        this.dimension.increaseHeight(increaseValue);
    }

    @Override
    public abstract void update(double dt);

    @Override
    public boolean equals(final Object o) {
        if (this == o)  {
            return true;
        }
        if (!(o instanceof AbstractElement)) {
            return false;
        }
        final AbstractElement that = (AbstractElement) o;
        final boolean testDimensions = Objects.equals(this.getDimension(), that.getDimension());
        final boolean testPositions = Objects.equals(this.getPosition(), that.getPosition());
        final boolean testHitbox = Objects.equals(this.getHitbox(), that.getHitbox());
        return testDimensions && testPositions && testHitbox;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getDimension(), this.getPosition(), this.getHitbox());
    }
}
