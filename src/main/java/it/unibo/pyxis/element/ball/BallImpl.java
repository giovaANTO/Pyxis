package it.unibo.pyxis.element.ball;

import it.unibo.pyxis.element.AbstractElement;
import it.unibo.pyxis.element.brick.Brick;
import it.unibo.pyxis.element.pad.Pad;
import it.unibo.pyxis.event.movement.BallMovementEvent;
import it.unibo.pyxis.event.notify.CollisionEvent;
import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.Dimension;
import it.unibo.pyxis.util.PairImpl;
import it.unibo.pyxis.util.Vector;
import org.greenrobot.eventbus.EventBus;

import java.util.Objects;

public final class BallImpl extends AbstractElement implements Ball {

    private BallType type;
    private final Vector pace;

    public BallImpl(final Dimension inputDimension, final Coord inputPosition,
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
        BallMovementEvent event = this::getPosition;
        EventBus.getDefault().post(event);
    }

    private void calculateNewCoord() {
        Coord updatedCoord = this.getPosition();
        updatedCoord.sumVector(this.getPace(), this.getType().getPaceMultiplier());
        this.setPosition(updatedCoord);
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
