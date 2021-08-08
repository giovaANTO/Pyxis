package it.unibo.pyxis.model.element.ball;

import it.unibo.pyxis.ecs.component.physics.PhysicsComponent;
import it.unibo.pyxis.model.element.AbstractElement;
import it.unibo.pyxis.model.element.ball.component.BallEventComponent;
import it.unibo.pyxis.model.element.ball.component.BallPhysicsComponent;
import it.unibo.pyxis.model.hitbox.BallHitbox;
import it.unibo.pyxis.model.hitbox.HitEdge;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.DimensionImpl;
import it.unibo.pyxis.model.util.Vector;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public final class BallImpl extends AbstractElement implements Ball {

    private static final Dimension DIMENSION = new DimensionImpl(14, 14);
    private BallType type;
    private Vector pace;
    private final Map<HitEdge, Dimension> collisionInformation;
    private final int id;

    private BallImpl(final Vector inputPace, final Coord position, final BallType type, final int inputId) {
        super(DIMENSION, position);
        this.setHitbox(new BallHitbox(this));
        this.type = type;
        this.pace = inputPace;
        this.collisionInformation = new HashMap<>();
        this.id = inputId;
        this.registerComponent(new BallPhysicsComponent(this));
        this.registerComponent(new BallEventComponent(this));
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Map<HitEdge, Dimension> getCollisionInformation() {
        return Collections.unmodifiableMap(this.collisionInformation);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void clearCollisionInformation() {
        this.collisionInformation.clear();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void registerCollision(final HitEdge hitEdge, final Dimension offset) {
        this.collisionInformation.put(hitEdge, offset);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public BallType getType() {
        return this.type;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Vector getPace() {
        return this.pace.copyOf();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setPace(final Vector inputPace) {
        this.pace = inputPace;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void setType(final BallType inputType) {
        this.type = inputType;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getId() {
        return this.id;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double dt) {
        this.getComponent(PhysicsComponent.class).update(dt);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BallImpl)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final BallImpl ball = (BallImpl) o;
        final boolean testId = this.getId() == ball.getId();
        final boolean testType = this.getType() == ball.getType();
        return testId && testType && getPace().equals(ball.getPace());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "BallImpl{" + "type=" + type + ", pace=" + pace + ", id=" + id + "}";
    }
    /**
     * The Builder of the {@link it.unibo.pyxis.model.element.ball.Ball}.
     */
    public static final class Builder implements BallBuilder {

        private Optional<Vector> pace = Optional.empty();
        private Optional<Integer> id = Optional.empty();
        private Optional<Coord> position = Optional.empty();
        private BallType type = BallType.NORMAL_BALL;

        private void check(final Object inputObject) {
            Objects.requireNonNull(inputObject);
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public BallBuilder pace(final Vector inputPace) {
            this.check(inputPace);
            this.pace = Optional.of(inputPace);
            return this;
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public BallBuilder id(final int inputId) {
            this.id = Optional.of(inputId);
            return this;
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public BallBuilder initialPosition(final Coord position) {
            this.check(position);
            this.position = Optional.of(position);
            return this;
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public BallBuilder ballType(final BallType type) {
            this.check(type);
            this.type = type;
            return this;
        }
        /**
         * {@inheritDoc}
         */
        @Override
        public Ball build() {
            return new BallImpl(this.pace.orElseThrow(),
                    this.position.orElseThrow(),
                    this.type,
                    this.id.orElseThrow());
        }
    }
}
