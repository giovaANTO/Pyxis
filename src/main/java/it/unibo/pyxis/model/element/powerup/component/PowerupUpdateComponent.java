package it.unibo.pyxis.model.element.powerup.component;

import it.unibo.pyxis.ecs.component.physics.AbstractUpdateComponent;
import it.unibo.pyxis.model.element.powerup.Powerup;
import it.unibo.pyxis.model.event.Events;
import it.unibo.pyxis.model.util.Coord;
import org.greenrobot.eventbus.EventBus;

public final class PowerupUpdateComponent extends AbstractUpdateComponent<Powerup> {

    public PowerupUpdateComponent(final Powerup entity) {
        super(entity);
    }

    /**
     * Calculates the new {@link Coord} of the {@link Powerup}.
     *
     * @param dt The elapsed time between two updates.
     */
    private void calculateNewCoord(final double dt) {
        final Coord updatedCoord = this.getEntity().getPosition();
        updatedCoord.sumVector(this.getEntity().getPace(), dt * this.getEntity().getUpdateTimeMultiplier());
        this.getEntity().setPosition(updatedCoord);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double elapsed) {
        this.calculateNewCoord(elapsed);
        EventBus.getDefault().post(Events.newPowerupMovementEvent(this.getEntity()));
    }
}
