package it.unibo.pyxis.model.element.pad;

import it.unibo.pyxis.model.element.AbstractElement;
import it.unibo.pyxis.model.event.movement.BallMovementEvent;
import it.unibo.pyxis.model.event.movement.PowerupMovementEvent;
import it.unibo.pyxis.model.hitbox.RectHitbox;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.DimensionImpl;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public final class PadImpl extends AbstractElement implements Pad {

    private static final Dimension DIMENSION = new DimensionImpl(1, 1);

    public PadImpl(final Dimension inputDimension, final Coord inputPosition) {
        super(inputDimension, inputPosition);
        this.setHitbox(new RectHitbox(this));
        EventBus.getDefault().register(this);
    }

    public PadImpl(final Coord inputPosition) {
        super(DIMENSION, inputPosition);
    }

    @Override
    public void update(final int dt) {
        throw new UnsupportedOperationException("Operation not implemented yet");
    }

    @Override
    @Subscribe
    public void handleBallMovement(final BallMovementEvent movementEvent) {

    }

    @Override
    @Subscribe
    public void handlePowerupMovement(final PowerupMovementEvent movementEvent) {

    }
}
