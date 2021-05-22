package it.unibo.pyxis.element.ball;

import it.unibo.pyxis.element.AbstractElement;
import it.unibo.pyxis.event.collision.BrickCollisionEvent;
import it.unibo.pyxis.event.collision.PadCollisionEvent;
import it.unibo.pyxis.event.Events;
import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.Dimension;
import it.unibo.pyxis.util.Vector;
import org.greenrobot.eventbus.EventBus;

import java.util.Objects;
import java.util.Optional;

public final class BallImpl extends AbstractElement implements Ball {

    private BallType type;
    private final Vector pace;

    private BallImpl(final Dimension inputDimension, final Coord inputPosition,
                    final Vector inputPace) {
        super(inputDimension, inputPosition);
        this.type = BallType.NORMAL_BALL;
        this.pace = inputPace;
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
    public void update() {
        this.calculateNewCoord();
        EventBus.getDefault().post(Events.newBallMovementEvent(this.getPosition()));
    }

    private void calculateNewCoord() {
        Coord updatedCoord = this.getPosition();
        updatedCoord.sumVector(this.getPace(), this.getType().getPaceMultiplier());
        this.setPosition(updatedCoord);
    }

    public static final class BallBuilderImpl implements BallBuilder {

        private Optional<Dimension> dimension = Optional.empty();
        private Optional<Coord> position = Optional.empty();
        private Optional<Vector> pace = Optional.empty();

        private void check(final Object inputObject) {
            Objects.requireNonNull(inputObject);
        }

        @Override
        public BallBuilder dimension(final Dimension inputDimension) {
            this.check(inputDimension);
            this.dimension = Optional.of(inputDimension.copyOf());
            return this;
        }

        @Override
        public BallBuilder position(final Coord inputPosition) {
            this.check(inputPosition);
            this.position = Optional.of(inputPosition.copyOf());
            return this;
        }

        @Override
        public BallBuilder pace(final Vector inputPace) {
            this.check(inputPace);
            this.pace = Optional.of(inputPace.copyOf());
            return this;
        }

        @Override
        public Ball build() {
            return new BallImpl(this.dimension.orElseThrow(),
                    this.position.orElseThrow(), this.pace.orElseThrow());
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
