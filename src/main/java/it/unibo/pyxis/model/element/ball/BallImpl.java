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

    private static final Dimension DIMENSION = new DimensionImpl(20, 20);
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

    @Override
    public Map<HitEdge, Dimension> getCollisionInformations() {
        return Collections.unmodifiableMap(this.collisionInformation);
    }

    @Override
    public void clearCollisionInformations() {
        this.collisionInformation.clear();
    }

    @Override
    public void registerCollision(final HitEdge hitEdge, final Dimension offset) {
        this.collisionInformation.put(hitEdge, offset);
    }

    @Override
    public BallType getType() {
        return this.type;
    }

    @Override
    public Vector getPace() {
        return this.pace.copyOf();
    }

    @Override
    public void setPace(final Vector inputPace) {
        this.pace = inputPace;
    }

    @Override
    public synchronized void setType(final BallType inputType) {
        this.type = inputType;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void update(final double dt) {
        this.getComponent(PhysicsComponent.class).update(dt);
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }

    @Override
    public String toString() {
        return "BallImpl{" + "type=" + type + ", pace=" + pace + ", id=" + id + "}";
    }

    /**
     * Builder of the {@link it.unibo.pyxis.model.element.ball.Ball}.
     */
    public static final class Builder implements BallBuilder {

        private Optional<Vector> pace = Optional.empty();
        private Optional<Integer> id = Optional.empty();
        private Optional<Coord> position = Optional.empty();
        private BallType type = BallType.NORMAL_BALL;

        private void check(final Object inputObject) {
            Objects.requireNonNull(inputObject);
        }

        @Override
        public BallBuilder pace(final Vector inputPace) {
            this.check(inputPace);
            this.pace = Optional.of(inputPace);
            return this;
        }

        @Override
        public BallBuilder id(final int inputId) {
            this.id = Optional.of(inputId);
            return this;
        }

        @Override
        public BallBuilder initialPosition(final Coord position) {
            this.check(position);
            this.position = Optional.of(position);
            return this;
        }

        @Override
        public BallBuilder ballType(final BallType type) {
            this.check(type);
            this.type = type;
            return this;
        }

        @Override
        public Ball build() {
            return new BallImpl(this.pace.orElseThrow(),
                    this.position.orElseThrow(),
                    this.type,
                    this.id.orElseThrow());
        }
    }
}
