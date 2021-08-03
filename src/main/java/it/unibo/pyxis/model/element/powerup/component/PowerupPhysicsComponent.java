package it.unibo.pyxis.model.element.powerup.component;

import it.unibo.pyxis.model.ecs.component.physics.AbstractPhysicsComponent;
import it.unibo.pyxis.model.element.powerup.Powerup;
import it.unibo.pyxis.model.event.Events;
import it.unibo.pyxis.model.util.Coord;
import org.greenrobot.eventbus.EventBus;

public class PowerupPhysicsComponent extends AbstractPhysicsComponent<Powerup> {

    public PowerupPhysicsComponent(final Powerup entity) {
        super(entity);
    }

    /**
     * Calculate the new coordinate of the {@link Powerup}.
     * @param dt
     *             elapsed time between two updates
     */
    private void calculateNewCoord(final double dt) {
        final Coord updatedCoord = this.getEntity().getPosition();
        updatedCoord.sumVector(this.getEntity().getPace(), dt * this.getEntity().getUpdateTimeMultiplier());
        this.getEntity().setPosition(updatedCoord);
    }

    @Override
    public void update(final double elapsed) {
        this.calculateNewCoord(elapsed);
        EventBus.getDefault().post(Events.newPowerupMovementEvent(this.getEntity()));
    }
}
