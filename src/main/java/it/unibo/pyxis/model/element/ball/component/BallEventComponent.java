package it.unibo.pyxis.model.element.ball.component;

import it.unibo.pyxis.ecs.component.event.AbstractEventComponent;
import it.unibo.pyxis.model.element.ball.Ball;
import it.unibo.pyxis.model.event.collision.BallCollisionWithBorderEvent;
import it.unibo.pyxis.model.event.collision.BallCollisionWithBrickEvent;
import it.unibo.pyxis.model.event.collision.BallCollisionWithPadEvent;
import it.unibo.pyxis.model.event.collision.CollisionEvent;
import it.unibo.pyxis.model.hitbox.HitEdge;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.Vector;
import org.greenrobot.eventbus.Subscribe;

public class BallEventComponent extends AbstractEventComponent<Ball> {

    private static final double ANGLE_MIN_PERCENTAGE_FLAT_CORNER = 0.1;
    private static final double ANGLE_MAX_PERCENTAGE_FLAT_CORNER = 0.9;

    public BallEventComponent(final Ball entity) {
        super(entity);
    }

    /**
     * Registers a new {@link CollisionEvent}.
     *
     * @param collisionEvent The event to register.
     */
    private void registerCollision(final CollisionEvent collisionEvent) {
        if (collisionEvent.getCollisionInformation().getHitEdge() == HitEdge.TOP) {
            collisionEvent.getCollisionInformation().setHitEdge(HitEdge.HORIZONTAL);
        }
        final HitEdge hitEdge = collisionEvent.getCollisionInformation().getHitEdge();
        final Dimension borderOffset = collisionEvent.getCollisionInformation().getCollisionOffset();
        this.getEntity().registerCollision(hitEdge, borderOffset);
    }

    /**
     * Calculates and successively apply the new {@link Vector} pace to the {@link Ball}
     * after a {@link it.unibo.pyxis.model.element.pad.Pad} collision.
     *
     * @param padHitPercentage The parameter to calculate the new {@link Vector}.
     */
    private void applyPaceChange(final double padHitPercentage) {
        final double angle = Math.PI * Math.min(Math.max(padHitPercentage, ANGLE_MIN_PERCENTAGE_FLAT_CORNER), ANGLE_MAX_PERCENTAGE_FLAT_CORNER);
        final double module = this.getEntity().getPace().getModule();
        final Vector newPace = this.getEntity().getPace();
        newPace.setX(Math.cos(angle) * module);
        newPace.setY(Math.sin(angle) * module);
        this.getEntity().setPace(newPace);
    }

    /**
     * Handles the {@link CollisionEvent} between the {@link Ball} and a
     * {@link it.unibo.pyxis.model.element.brick.Brick}.
     *
     * @param collisionEvent The {@link BallCollisionWithBrickEvent} to handle.
     */
    @Subscribe
    public void handleBrickCollision(final BallCollisionWithBrickEvent collisionEvent) {
        if (this.getEntity().getId() == collisionEvent.getBallId() && this.getEntity().getType().bounce()) {
            this.registerCollision(collisionEvent);
        }
    }

    /**
     * Handles the {@link CollisionEvent} between the {@link Ball} and the border.
     *
     * @param collisionEvent The {@link BallCollisionWithBorderEvent} to handle.
     */
    @Subscribe
    public void handleBorderCollision(final BallCollisionWithBorderEvent collisionEvent) {
        if (this.getEntity().getId() == collisionEvent.getBallId()) {
            this.registerCollision(collisionEvent);
        }
    }

    /**
     * Handles the {@link CollisionEvent} between the {@link Ball} and the
     * {@link it.unibo.pyxis.model.element.pad.Pad}.
     *
     * @param collisionEvent The {@link BallCollisionWithPadEvent} to handle.
     */
    @Subscribe
    public void handlePadCollision(final BallCollisionWithPadEvent collisionEvent) {
        if (this.getEntity().getId() == collisionEvent.getBallId()) {
            if (collisionEvent.getCollisionInformation().getHitEdge() == HitEdge.TOP) {
                this.applyPaceChange(collisionEvent.getPadHitPercentage());
            }
            this.registerCollision(collisionEvent);
        }
    }
}
