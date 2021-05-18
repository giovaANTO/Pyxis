package it.unibo.pyxis.element.ball;

import it.unibo.pyxis.element.AbstractElement;
import it.unibo.pyxis.element.brick.Brick;
import it.unibo.pyxis.element.pad.Pad;
import it.unibo.pyxis.event.Events;
import it.unibo.pyxis.event.notify.CollisionEvent;
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
    public void handleBrickCollision(final CollisionEvent<Brick> collisionEvent) {

    }

    @Override
    public void handlePadCollision(final CollisionEvent<Pad> collisionEvent) {

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
    public void setType(final BallType inputType) {
        this.type = inputType;
    }

    @Override
    public void setPace(final Vector inputPace) {
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

        private Optional<Dimension> dimension;
        private Optional<Coord> position;
        private Optional<Vector> pace;

        private BallBuilderImpl() {
        }

        @Override
        public BallBuilder dimension(final Dimension inputDimension) {
            this.dimension = Optional.of(inputDimension.copyOf());
            return this;
        }

        @Override
        public BallBuilder position(final Coord inputPosition) {
            this.position = Optional.of(inputPosition.copyOf());
            return this;
        }

        @Override
        public BallBuilder pace(final Vector inputPace) {
            this.pace = Optional.of(inputPace.copyOf());
            return this;
        }

        @Override
        public Ball build() {
            if (this.dimension.isEmpty() || this.position.isEmpty() || this.pace.isEmpty()) {
                throw new IllegalStateException("Wrong ball Build");
            }
            return new BallImpl(this.dimension.get(), this.position.get(), this.pace.get());
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
