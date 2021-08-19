package it.unibo.pyxis.model.element.ball.component;

import it.unibo.pyxis.ecs.component.physics.AbstractUpdateComponent;
import it.unibo.pyxis.model.element.ball.Ball;
import it.unibo.pyxis.model.element.ball.BallType;
import it.unibo.pyxis.model.event.Events;
import it.unibo.pyxis.model.hitbox.HitEdge;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.DimensionImpl;
import it.unibo.pyxis.model.util.Vector;
import org.greenrobot.eventbus.EventBus;

import java.util.Map;

public class BallUpdateComponent extends AbstractUpdateComponent<Ball> {

    public BallUpdateComponent(final Ball entity) {
        super(entity);
    }

    /**
     * Calculates and successively apply the new {@link Coord} to the {@link Ball}.
     *
     * @param dt The time gap used to calculate the new {@link Coord}.
     * */
    private void applicateMovement(final double dt) {
        final Coord updatedCoord = this.getEntity().getPosition();
        final BallType ballType = this.getEntity().getType();
        final double movementTime = ballType.getPaceMultiplier() * dt * this.getEntity().getUpdateTimeMultiplier();
        updatedCoord.sumVector(this.getEntity().getPace(), movementTime);
        this.getEntity().setPosition(updatedCoord);
    }

    /**
     * Inverts the {@link Ball}'s X {@link Vector} pace component.
     */
    private void invertPaceX() {
        final Vector newPace = this.getEntity().getPace();
        newPace.setX(-this.getEntity().getPace().getX());
        this.getEntity().setPace(newPace);
    }

    /**
     * Inverts the {@link Ball}'s Y {@link Vector} pace component.
     */
    private void invertPaceY() {
        final Vector newPace = this.getEntity().getPace();
        newPace.setY(-this.getEntity().getPace().getY());
        this.getEntity().setPace(newPace);
    }

    /**
     * Set a new {@link Ball} position applying the offset calculated
     * during collisions.
     *
     * @param borderOffset The input offset {@link Dimension}
     */
    private void applyOffset(final Dimension borderOffset) {
        final Coord updatedCoord = this.getEntity().getPosition();
        final double paceX = this.getEntity().getPace().getX();
        final double paceY = this.getEntity().getPace().getY();
        updatedCoord.sumXValue(paceX > 0 ? borderOffset.getWidth() : -borderOffset.getWidth());
        updatedCoord.sumYValue(paceY > 0 ? borderOffset.getHeight() : -borderOffset.getHeight());
        this.getEntity().setPosition(updatedCoord);
    }

    /**
     * Redirect {@link Ball} using the registered collision's information.
     */
    private void applicateCollisions() {
        final Map<HitEdge, Dimension> collInfo = this.getEntity().getCollisionInformation();
        if (collInfo.containsKey(HitEdge.HORIZONTAL) && collInfo.containsKey(HitEdge.VERTICAL)) {
            this.invertPaceX();
            this.invertPaceY();
            final Dimension offsetVertical = collInfo.get(HitEdge.VERTICAL);
            final Dimension offsetHorizontal = collInfo.get(HitEdge.HORIZONTAL);
            this.applyOffset(new DimensionImpl(offsetVertical.getWidth(), offsetHorizontal.getHeight()));
        } else if (collInfo.containsKey(HitEdge.HORIZONTAL)) {
            this.invertPaceY();
            this.applyOffset(collInfo.get(HitEdge.HORIZONTAL));
        } else if (collInfo.containsKey(HitEdge.VERTICAL)) {
            this.invertPaceX();
            this.applyOffset(collInfo.get(HitEdge.VERTICAL));
        } else if (collInfo.containsKey(HitEdge.CORNER)) {
            this.invertPaceX();
            this.invertPaceY();
            this.applyOffset(collInfo.get(HitEdge.CORNER));
        }
        this.getEntity().clearCollisionInformation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void update(final double elapsed) {
        this.applicateCollisions();
        this.applicateMovement(elapsed);
        EventBus.getDefault().post(Events.newBallMovementEvent(this.getEntity()));
    }
}
