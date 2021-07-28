package it.unibo.pyxis.model.element.ball;

import it.unibo.pyxis.model.element.AbstractElement;
import it.unibo.pyxis.model.event.collision.CollisionEvent;
import it.unibo.pyxis.model.event.collision.PadCollisionEvent;
import it.unibo.pyxis.model.event.Events;
import it.unibo.pyxis.model.hitbox.CircleHitbox;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.DimensionImpl;
import it.unibo.pyxis.model.util.Vector;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Objects;
import java.util.Optional;

public final class BallImpl extends AbstractElement implements Ball {

    private static final Dimension DIMENSION = new DimensionImpl(8, 8);
    private BallType type;
    private Vector pace;
    private final int id;

    private BallImpl(final Vector inputPace, final Coord position, final BallType type, final int inputId) {
        super(DIMENSION, position);
        this.setHitbox(new CircleHitbox(this));
        this.type = type;
        this.pace = inputPace;
        this.id = inputId;
        EventBus.getDefault().register(this);
    }


    @Override
    @Subscribe
    public void handleBrickCollision(final CollisionEvent collisionEvent) {

    }

    @Override
    @Subscribe
    public void handlePadCollision(final PadCollisionEvent collisionEvent) {

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
        this.calculateNewCoord(dt);
        EventBus.getDefault().post(Events.newBallMovementEvent(this.id, this.getHitbox(), this.getType().getDamage()));
    }

    private void calculateNewCoord(final double dt) {
        Coord updatedCoord = this.getPosition();
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
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BallImpl ball = (BallImpl) o;
        return type == ball.type && pace.equals(ball.pace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, pace);
    }

    @Override
    public String toString() {
        return "BallImpl{" + "type=" + type + ", pace=" + pace + ", id=" + id + "}";
    }
}
