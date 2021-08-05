package it.unibo.pyxis.model.element.brick.component;

import it.unibo.pyxis.ecs.component.event.AbstractEventComponent;
import it.unibo.pyxis.ecs.component.event.EventComponent;
import it.unibo.pyxis.model.element.ball.Ball;
import it.unibo.pyxis.model.element.brick.Brick;
import it.unibo.pyxis.model.event.Events;
import it.unibo.pyxis.model.event.movement.BallMovementEvent;
import it.unibo.pyxis.model.hitbox.CollisionInformation;
import it.unibo.pyxis.model.hitbox.Hitbox;
import it.unibo.pyxis.model.util.Coord;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Optional;

public class BrickEventComponent extends AbstractEventComponent<Brick> {

    public BrickEventComponent(final Brick entity) {
        super(entity);
    }

    /**
     * Handle the damage received by a {@link it.unibo.pyxis.model.element.ball.Ball}.
     * If the durability of the {@link Brick} reaches the value 0 then the brick is destroyed.
     *
     * @param incomingDamage
     *                         The {@link Optional} indicating the damage taken.
     */
    private void handleIncomingDamage(final Optional<Integer> incomingDamage) {
        final int actualDurability = this.getEntity().getDurability();
        final int damage = incomingDamage.isEmpty() ? 0 : Math.max(actualDurability - incomingDamage.get(), 0);
        this.getEntity().setDurability(damage);
        if (this.getEntity().getDurability() == 0 && !this.getEntity().getBrickType().isIndestructible()) {
            final Coord brickPosition = this.getEntity().getPosition();
            final int getPoints = this.getEntity().getBrickType().getPoints();
            EventBus.getDefault().post(Events.newBrickDestructionEvent(brickPosition, getPoints));
            if (this.getEntity().hasComponent(EventComponent.class)) {
                this.getEntity().removeComponent(EventComponent.class);
            }
        }
    }

    /**
     * Handles the ball's movement event.
     * @param movementEvent
     *          The movement event caused by the
     *          {@link it.unibo.pyxis.model.element.ball.Ball} needs to be handled.
     */
    @Subscribe
    public void handleBallMovement(final BallMovementEvent movementEvent) {
        final Hitbox hitbox = this.getEntity().getHitbox();
        final Optional<CollisionInformation> collInfo = movementEvent.getElement().getHitbox().collidingEdgeWithHB(hitbox);
        collInfo.ifPresent(cI -> {
            final Ball ball = movementEvent.getElement();
            this.handleIncomingDamage(movementEvent.getElement().getType().getDamage());
            EventBus.getDefault().post(Events.newBallCollisionWithBrickEvent(ball.getId(), this.getEntity().getBrickType().isIndestructible(), cI));
        });
    }
}
