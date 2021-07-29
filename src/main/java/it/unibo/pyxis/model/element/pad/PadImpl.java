package it.unibo.pyxis.model.element.pad;

import it.unibo.pyxis.model.element.AbstractElement;
import it.unibo.pyxis.model.event.Events;
import it.unibo.pyxis.model.event.movement.BallMovementEvent;
import it.unibo.pyxis.model.event.movement.PowerupMovementEvent;
import it.unibo.pyxis.model.hitbox.CollisionInformation;
import it.unibo.pyxis.model.hitbox.RectHitbox;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.DimensionImpl;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Optional;

public final class PadImpl extends AbstractElement implements Pad {

    private static final Dimension DIMENSION = new DimensionImpl(100, 18);

    public PadImpl(final Dimension inputDimension, final Coord inputPosition) {
        super(inputDimension, inputPosition);
        this.setHitbox(new RectHitbox(this));
        EventBus.getDefault().register(this);
    }

    public PadImpl(final Coord inputPosition) {
        this(DIMENSION, inputPosition);
    }

    @Override
    public void update(final double dt) {
        throw new UnsupportedOperationException("Operation not implemented yet");
    }

    @Override
    @Subscribe
    public void handleBallMovement(final BallMovementEvent movementEvent) {
        final Optional<CollisionInformation> collisionInformation = movementEvent.getElement().getHitbox().collidingEdgeWithHB(this.getHitbox());
        collisionInformation.ifPresent(cI -> {
            EventBus.getDefault().post(Events.newBallCollisionWithPadEvent(movementEvent.getElement().getId(), cI, this.getDimension().getWidth()));
        });
    }

    @Override
    @Subscribe
    public void handlePowerupMovement(final PowerupMovementEvent movementEvent) {
        if (movementEvent.getElement().getHitbox().collidingEdgeWithHB(this.getHitbox()).isPresent()) {
            EventBus.getDefault().post(Events.newPowerupActivationEvent(movementEvent.getElement()));
        }
    }
}
