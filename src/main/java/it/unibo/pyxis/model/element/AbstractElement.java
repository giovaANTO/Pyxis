package it.unibo.pyxis.model.element;

import it.unibo.pyxis.ecs.component.physics.UpdateComponent;
import it.unibo.pyxis.ecs.EntityImpl;
import it.unibo.pyxis.model.hitbox.Hitbox;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;

import java.util.Objects;

public abstract class AbstractElement extends EntityImpl implements Element {

    private static final double UPDATE_TIME_MULTIPLIER = 0.001;
    private final Dimension dimension;
    private final Coord position;
    private Hitbox hitbox;

    public AbstractElement(final Dimension inputDimension, final Coord inputPosition) {
        this.dimension = inputDimension;
        this.position = inputPosition;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized final Dimension getDimension() {
        return this.dimension.copyOf();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized final Hitbox getHitbox() {
        return this.hitbox;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized final Coord getPosition() {
        return this.position.copyOf();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final double getUpdateTimeMultiplier() {
        return UPDATE_TIME_MULTIPLIER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getDimension(), this.getPosition(), this.getHitbox());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized final void increaseHeight(final double increaseValue) {
        this.dimension.increaseHeight(increaseValue);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized final void increaseWidth(final double increaseValue) {
        this.dimension.increaseWidth(increaseValue);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized final void setHeight(final double inputHeight) {
        this.dimension.setHeight(inputHeight);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void setHitbox(final Hitbox hitbox) {
        this.hitbox = hitbox;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized final void setPosition(final Coord inputPosition) {
        this.position.setXY(inputPosition.getX(), inputPosition.getY());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized final void setWidth(final double inputWidth) {
        this.dimension.setWidth(inputWidth);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void update(final double dt) {
        this.getComponent(UpdateComponent.class).update(dt);
    }
}
