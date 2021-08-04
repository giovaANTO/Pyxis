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

    /**
     * Apply a {@link CollisionEvent} to the {@link Ball}.
     */
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
    /**
     * Apply the {@link CollisionEvent}'s offset to the {@link Ball} .
     * @param borderOffset
     *          The {@link CollisionEvent}'s offset.
     */
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
    /**
     * Calculate and apply the new {@link Vector} pace to the {@link Ball} after
     * a {@link it.unibo.pyxis.model.element.pad.Pad} {@link CollisionEvent}.
     * @param padHitPercentage
     *          The percentage of the width of the
     *          {@link it.unibo.pyxis.model.element.pad.Pad} based on the
     *          point of collision's X {@link Coord} and the right limit of the
     *          {@link it.unibo.pyxis.model.element.pad.Pad}.
     */
    private void applyPaceChange(final double padHitPercentage) {
        final double angle = Math.PI * Math.min(Math.max(padHitPercentage, MIN_PACE_LEFT_PERCENTAGE), MIN_PACE_RIGHT_PERCENTAGE);
        final double module = this.getPace().getModule();
        this.pace.setX(Math.cos(angle) * module);
        this.pace.setY(Math.sin(angle) * module);
    }
    /**
     * Calculate and apply the new {@link Coord} to the {@link Ball}.
     * @param dt
     *          The time gap used to calculate the new {@link Coord}.
     */
    private void calculateNewCoord(final double dt) {
        final Coord updatedCoord = this.getPosition();
        updatedCoord.sumVector(this.getPace(),
                this.getType().getPaceMultiplier() * dt * this.getUpdateTimeMultiplier());
        this.setPosition(updatedCoord);
    }
    /**
     * Invert the X component of the {@link Ball}'s pace's {@link Vector}.
     */
    private void invertPaceX() {
        this.pace.setX(-this.pace.getX());
    }
    /**
     * Invert the Y component of the {@link Ball}'s pace's {@link Vector}.
     */
    private void invertPaceY() {
        this.pace.setY(-this.pace.getY());
    }
    /**
     * Register a new {@link CollisionEvent}.
     * @param collisionEvent
     *          The {@link CollisionEvent} to register.
     */
    private void registerCollision(final CollisionEvent collisionEvent) {
        final HitEdge hitEdge = collisionEvent.getCollisionInformation().getHitEdge();
        final Dimension borderOffset = collisionEvent.getCollisionInformation().getBorderOffset();
        this.collisionInformation.put(hitEdge, borderOffset);
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
    public void handleBrickCollision(final BallCollisionWithBrickEvent collisionEvent) {
        if (this.id == collisionEvent.getBallId() && this.getType().bounce()) {
            this.registerCollision(collisionEvent);
        }
    }
    @Override
    @Subscribe
    public void handlePadCollision(final BallCollisionWithPadEvent collisionEvent) {
        if (this.id == collisionEvent.getBallId()) {
            if (collisionEvent.getCollisionInformation().getHitEdge() == HitEdge.TOP) {
                this.applyPaceChange(collisionEvent.getPadHitPercentage());
                collisionEvent.getCollisionInformation().setHitEdge(HitEdge.HORIZONTAL);
            }
            this.registerCollision(collisionEvent);
        }
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
    public int getId() {
        return this.id;
    }
    @Override
    public Vector getPace() {
        return this.pace.copyOf();
    }
    @Override
    public BallType getType() {
        return this.type;
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
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
    public String toString() {
        return "BallImpl{" + "type=" + type + ", pace=" + pace + ", id=" + id + "}";
    }
    @Override
    public void update(final double dt) {
        this.applyCollisions();
        this.calculateNewCoord(dt);
        EventBus.getDefault().post(Events.newBallMovementEvent(this));
    }
}
