package it.unibo.pyxis.model.element.pad.component;

import it.unibo.pyxis.ecs.component.event.AbstractEventComponent;
import it.unibo.pyxis.model.element.pad.Pad;
import it.unibo.pyxis.model.event.Events;
import it.unibo.pyxis.model.event.collision.BallCollisionWithPadEvent;
import it.unibo.pyxis.model.event.movement.BallMovementEvent;
import it.unibo.pyxis.model.event.movement.PowerupMovementEvent;
import it.unibo.pyxis.model.hitbox.CollisionInformation;
import it.unibo.pyxis.model.hitbox.Hitbox;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Optional;

public class PadEventComponent extends AbstractEventComponent<Pad> {

    public PadEventComponent(final Pad entity) {
        super(entity);
    }

    /**
     * Handles a {@link BallMovementEvent}.
     *
     * @param movementEvent The {@link BallMovementEvent} to handle.
     */
    @Subscribe
    public void handleBallMovement(final BallMovementEvent movementEvent) {
        final Hitbox currentHitbox = this.getEntity().getHitbox();
        final Hitbox ballHitbox = movementEvent.getElement().getHitbox();
        final Optional<CollisionInformation> collInfo = ballHitbox.collidingInformationWithHB(currentHitbox);
        collInfo.ifPresent(cI -> {
            final int elemId = movementEvent.getElement().getId();
            final Coord padPos = this.getEntity().getPosition();
            final Coord elementPos = movementEvent.getElement().getPosition();
            final Dimension padDim = this.getEntity().getDimension();
            final double padWidth = (padPos.getX() + padDim.getWidth() / 2 - elementPos.getX()) / padDim.getWidth();
            final BallCollisionWithPadEvent event = Events.newBallCollisionWithPadEvent(elemId, cI, padWidth);
            EventBus.getDefault().post(event);
        });
    }

    /**
     * Handles a {@link PowerupMovementEvent}.
     *
     * @param movementEvent The {@link PowerupMovementEvent} to handle.
     */
    @Subscribe
    public void handlePowerupMovement(final PowerupMovementEvent movementEvent) {
        if (movementEvent.getElement().getHitbox().collidingInformationWithHB(this.getEntity().getHitbox()).isPresent()) {
            EventBus.getDefault().post(Events.newPowerupActivationEvent(movementEvent.getElement()));
        }
    }
}
