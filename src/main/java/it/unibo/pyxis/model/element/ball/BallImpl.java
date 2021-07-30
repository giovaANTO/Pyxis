package it.unibo.pyxis.model.element.ball;

import it.unibo.pyxis.model.element.AbstractElement;
import it.unibo.pyxis.model.event.collision.BallCollisionEvent;
import it.unibo.pyxis.model.event.collision.BallCollisionWithPadEvent;
import it.unibo.pyxis.model.event.Events;
import it.unibo.pyxis.model.hitbox.CircleHitbox;
import it.unibo.pyxis.model.hitbox.HitEdge;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.DimensionImpl;
import it.unibo.pyxis.model.util.Vector;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public final class BallImpl extends AbstractElement implements Ball {

    private static final Dimension DIMENSION = new DimensionImpl(20, 20);
    private BallType type;
    private Vector pace;
    private final Set<HitEdge> edgesHit;
    private final int id;

    private BallImpl(final Vector inputPace, final Coord position, final BallType type, final int inputId) {
        super(DIMENSION, position);
        this.setHitbox(new CircleHitbox(this));
        this.type = type;
        this.pace = inputPace;
        this.edgesHit = new HashSet<>(Set.of());
        this.id = inputId;
        EventBus.getDefault().register(this);
    }


    @Override
    @Subscribe
    public void handleCollision(final BallCollisionEvent collisionEvent) {
        if (this.id == collisionEvent.getBallId()) {
            edgesHit.add(collisionEvent.getCollidedEdge());
        }
    }

    @Override
    @Subscribe
    public void handlePadCollision(final BallCollisionWithPadEvent collisionEvent) {
        if (this.id == collisionEvent.getBallId()) {
            edgesHit.add(collisionEvent.getCollidedEdge());
        }
    }

    private void applyBorderAndBrickCollision() {
        if (edgesHit.contains(HitEdge.HORIZONTAL) && edgesHit.contains(HitEdge.VERTICAL)) {
            this.invertPaceX();
            this.invertPaceY();
        } else if (edgesHit.contains(HitEdge.HORIZONTAL)) {
            this.invertPaceY();
        } else if (edgesHit.contains(HitEdge.VERTICAL)) {
            this.invertPaceX();
        } else if (edgesHit.contains(HitEdge.CORNER)) {
            this.invertPaceX();
            this.invertPaceY();
        }
        this.edgesHit.clear();
    }

    private void invertPaceX() {
        this.pace.setX(-this.pace.getX());
    }

    private void invertPaceY() {
        this.pace.setY(-this.pace.getY());
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
    public synchronized void setType(final BallType inputType) {
        this.type = inputType;
    }

    @Override
    public synchronized void setPace(final Vector inputPace) {
      this.pace = inputPace;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void update(final double dt) {
        this.applyBorderAndBrickCollision();
        this.calculateNewCoord(dt);
        EventBus.getDefault().post(Events.newBallMovementEvent(this));
    }

    private void calculateNewCoord(final double dt) {
        final Coord updatedCoord = this.getPosition();
        updatedCoord.sumVector(this.getPace(),
                this.getType().getPaceMultiplier() * dt * this.getUpdateTimeMultiplier());
        this.setPosition(updatedCoord);
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
            this.pace = Optional.of(inputPace.copyOf());
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
        BallImpl ball = (BallImpl) o;
        return getId() == ball.getId() && getType() == ball.getType() && getPace().equals(ball.getPace()) && edgesHit.equals(ball.edgesHit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getType(), getPace(), edgesHit, getId());
    }

    @Override
    public String toString() {
        return "BallImpl{" + "type=" + type + ", pace=" + pace + ", id=" + id + "}";
    }
}
