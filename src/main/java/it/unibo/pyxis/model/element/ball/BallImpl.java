package it.unibo.pyxis.model.element.ball;

import it.unibo.pyxis.model.element.AbstractElement;
import it.unibo.pyxis.model.event.collision.BallCollisionWithBorderEvent;
import it.unibo.pyxis.model.event.collision.BallCollisionWithBrickEvent;
import it.unibo.pyxis.model.event.collision.BallCollisionWithPadEvent;
import it.unibo.pyxis.model.event.Events;
import it.unibo.pyxis.model.event.collision.CollisionEvent;
import it.unibo.pyxis.model.hitbox.BallHitbox;
import it.unibo.pyxis.model.hitbox.HitEdge;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.DimensionImpl;
import it.unibo.pyxis.model.util.Vector;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public final class BallImpl extends AbstractElement implements Ball {

    private static final Dimension DIMENSION = new DimensionImpl(20, 20);
    private static final double MIN_PACE_LEFT_PERCENTAGE = 0.1;
    private static final double MIN_PACE_RIGHT_PERCENTAGE = 0.9;
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
        EventBus.getDefault().register(this);
    }

    private void calculateNewCoord(final double dt) {
        final Coord updatedCoord = this.getPosition();
        updatedCoord.sumVector(this.getPace(),
                this.getType().getPaceMultiplier() * dt * this.getUpdateTimeMultiplier());
        this.setPosition(updatedCoord);
    }

    private void invertPaceX() {
        this.pace.setX(-this.pace.getX());
    }

    private void invertPaceY() {
        this.pace.setY(-this.pace.getY());
    }

    private void applyCollisions() {
        if (collisionInformation.containsKey(HitEdge.HORIZONTAL) && collisionInformation.containsKey(HitEdge.VERTICAL)) {
            this.invertPaceX();
            this.invertPaceY();
            this.applyOffset(new DimensionImpl(collisionInformation.get(HitEdge.VERTICAL).getWidth(),
                                                collisionInformation.get(HitEdge.HORIZONTAL).getHeight()));
        } else if (collisionInformation.containsKey(HitEdge.HORIZONTAL)) {
            this.invertPaceY();
            this.applyOffset(collisionInformation.get(HitEdge.HORIZONTAL));
        } else if (collisionInformation.containsKey(HitEdge.VERTICAL)) {
            this.invertPaceX();
            this.applyOffset(collisionInformation.get(HitEdge.VERTICAL));
        } else if (collisionInformation.containsKey(HitEdge.CORNER)) {
            this.invertPaceX();
            this.invertPaceY();
            this.applyOffset(collisionInformation.get(HitEdge.CORNER));
        }
        this.collisionInformation.clear();
    }

    private void applyOffset(final Dimension borderOffset) {
        final Coord updatedCoord = this.getPosition();
        if (this.pace.getX() > 0) {
            updatedCoord.sumXValue(borderOffset.getWidth());
        } else {
            updatedCoord.sumXValue(-borderOffset.getWidth());
        }
        if (this.pace.getY() > 0) {
            updatedCoord.sumYValue(borderOffset.getHeight());
        } else {
            updatedCoord.sumYValue(-borderOffset.getHeight());
        }
        this.setPosition(updatedCoord);
    }

    private void applyPaceChange(final double padHitPercentage) {
        final double angle = Math.PI * Math.min(Math.max(padHitPercentage, MIN_PACE_LEFT_PERCENTAGE), MIN_PACE_RIGHT_PERCENTAGE);
        final double module = this.getPace().getModule();
        this.pace.setX(Math.cos(angle) * module);
        this.pace.setY(Math.sin(angle) * module);
    }

    private void registerCollision(final CollisionEvent collisionEvent) {
        if (collisionEvent.getCollisionInformation().getHitEdge() == HitEdge.TOP) {
            collisionEvent.getCollisionInformation().setHitEdge(HitEdge.HORIZONTAL);
        }
        final HitEdge hitEdge = collisionEvent.getCollisionInformation().getHitEdge();
        final Dimension borderOffset = collisionEvent.getCollisionInformation().getBorderOffset();
        this.collisionInformation.put(hitEdge, borderOffset);
    }

    @Override
    @Subscribe
    public void handleBrickCollision(final BallCollisionWithBrickEvent collisionEvent) {
        if (this.id == collisionEvent.getBallId() && this.getType().bounce()) {
            this.registerCollision(collisionEvent);
        }
    }

    @Override
    @Subscribe
    public void handleBorderCollision(final BallCollisionWithBorderEvent collisionEvent) {
        if (this.id == collisionEvent.getBallId()) {
            this.registerCollision(collisionEvent);
        }
    }

    @Override
    @Subscribe
    public void handlePadCollision(final BallCollisionWithPadEvent collisionEvent) {
        if (this.id == collisionEvent.getBallId()) {
            if (collisionEvent.getCollisionInformation().getHitEdge() == HitEdge.TOP) {
                this.applyPaceChange(collisionEvent.getPadHitPercentage());
            }
            this.registerCollision(collisionEvent);
        }
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
        this.applyCollisions();
        this.calculateNewCoord(dt);
        EventBus.getDefault().post(Events.newBallMovementEvent(this));
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
