package it.unibo.pyxis.model.element.pad;

import it.unibo.pyxis.model.element.AbstractElement;
import it.unibo.pyxis.model.event.Events;
import it.unibo.pyxis.model.event.movement.BallMovementEvent;
import it.unibo.pyxis.model.event.movement.PowerupMovementEvent;
import it.unibo.pyxis.model.hitbox.CollisionInformation;
import it.unibo.pyxis.model.hitbox.RectHitbox;
import it.unibo.pyxis.model.util.*;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Objects;
import java.util.Optional;

public final class PadImpl extends AbstractElement implements Pad {

    public static final double PAD_X_MOVEMENT = 10;
    private static final String DEFAULT_TAG = "DEFAULT_PAD";
    private static final Dimension DIMENSION = new DimensionImpl(100, 18);
    private String tag;

    public PadImpl(final Dimension inputDimension, final Coord inputPosition, final String inputTag) {
        super(inputDimension, inputPosition);
        this.setHitbox(new RectHitbox(this));
        this.tag = inputTag;
        EventBus.getDefault().register(this);
    }

    public PadImpl(final Dimension inputDimension, final Coord inputPosition) {
        this(inputDimension, inputPosition, DEFAULT_TAG);
    }

    public PadImpl(final Coord inputPosition) {
        this(DIMENSION, inputPosition, DEFAULT_TAG);
    }

    @Override
    public Vector getPace() {
        return new VectorImpl(0, 0);
    }

    @Override
    public void setPace(final Vector inputPace) {
        throw new UnsupportedOperationException("You can't set a the pace on a Pad");
    }

    @Override
    public void update(final double dt) {
        throw new UnsupportedOperationException("You can't call an update on the Pad");
    }

    @Override
    public String getTag() {
        return this.tag;
    }

    @Override
    @Subscribe
    public void handleBallMovement(final BallMovementEvent movementEvent) {
        final Optional<CollisionInformation> collisionInformation = movementEvent.getElement().getHitbox().collidingEdgeWithHB(this.getHitbox());
        collisionInformation.ifPresent(cI -> {
            EventBus.getDefault().post(Events.newBallCollisionWithPadEvent(movementEvent.getElement().getId(), cI,
                (this.getPosition().getX() + this.getDimension().getWidth() / 2 - movementEvent.getElement().getPosition().getX())
                / this.getDimension().getWidth()));
        });
    }

    @Override
    @Subscribe
    public void handlePowerupMovement(final PowerupMovementEvent movementEvent) {
        if (movementEvent.getElement().getHitbox().collidingEdgeWithHB(this.getHitbox()).isPresent()) {
            EventBus.getDefault().post(Events.newPowerupActivationEvent(movementEvent.getElement()));
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PadImpl)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final PadImpl pad = (PadImpl) o;
        return Objects.equals(this.getTag(), pad.getTag());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getTag());
    }
}
