package it.unibo.pyxis.model.element.powerup;

import it.unibo.pyxis.model.ecs.component.physics.PhysicsComponent;
import it.unibo.pyxis.model.element.AbstractElement;
import it.unibo.pyxis.model.element.powerup.component.PowerupPhysicsComponent;
import it.unibo.pyxis.model.event.Events;
import it.unibo.pyxis.model.hitbox.RectHitbox;

import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.DimensionImpl;
import it.unibo.pyxis.model.util.Vector;
import it.unibo.pyxis.model.util.VectorImpl;
import org.greenrobot.eventbus.EventBus;

import java.util.Objects;

public final class PowerupImpl extends AbstractElement implements Powerup {

    private static final Dimension DIMENSION = new DimensionImpl(30, 20);
    private static final Vector PACE = new VectorImpl(0, 30);
    private final PowerupType type;

    public PowerupImpl(final PowerupType inputType, final Coord inputCoord) {
        super(DIMENSION, inputCoord);
        this.setHitbox(new RectHitbox(this));
        this.type = inputType;
        this.registerComponent(new PowerupPhysicsComponent(this));
    }

    @Override
    public PowerupType getType() {
        return this.type;
    }

    @Override
    public Vector getPace() {
        return PACE.copyOf();
    }

    @Override
    public void update(final double dt) {
        this.getComponent(PhysicsComponent.class).update(dt);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PowerupImpl)) {
            return false;
        }
        PowerupImpl powerup = (PowerupImpl) o;
        return super.equals(o) && getType() == powerup.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType());
    }

    public String toString() {
        return "I'm a " + this.type + "; Coord: " + this.getPosition().getX() + " " + this.getPosition().getY();
    }
}
