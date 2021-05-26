package it.unibo.pyxis.element.ball;

import it.unibo.pyxis.element.AbstractElement;
import it.unibo.pyxis.event.collision.BrickCollisionEvent;
import it.unibo.pyxis.event.collision.PadCollisionEvent;
import it.unibo.pyxis.event.Events;
import it.unibo.pyxis.util.*;
import org.greenrobot.eventbus.EventBus;
import java.util.Objects;
import java.util.Optional;

public final class BallImpl extends AbstractElement implements Ball {

    private static final Dimension DIMENSION = new DimensionImpl(1, 1);
    private static final Coord STARTING_POSITION = new CoordImpl(1, 1);
    private BallType type;
    private final Vector pace;
    private final int id;

    private BallImpl(final Vector inputPace, final int inputId) {
        super(DIMENSION, STARTING_POSITION);
        this.type = BallType.NORMAL_BALL;
        this.pace = inputPace;
        this.id = inputId;
    }

    @Override
    public void handleBrickCollision(final BrickCollisionEvent collisionEvent) {

    }

    @Override
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
        this.pace.setX(inputPace.getX());
        this.pace.setY(inputPace.getY());
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void update() {
        this.calculateNewCoord();
        EventBus.getDefault().post(Events.newBallMovementEvent(this.id, this.getPosition()));
    }

    private void calculateNewCoord() {
        Coord updatedCoord = this.getPosition();
        updatedCoord.sumVector(this.getPace(), this.getType().getPaceMultiplier());
        this.setPosition(updatedCoord);
    }

    /**
     * Builder of the {@link Ball}.
     */
    public static final class BallBuilderImpl implements BallBuilder {

        private Optional<Vector> pace = Optional.empty();
        private Optional<Integer> id = Optional.empty();

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
        public Ball build() {
            return new BallImpl(this.pace.orElseThrow(), this.id.orElseThrow());
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
}
