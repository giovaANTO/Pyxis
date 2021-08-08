package it.unibo.pyxis.ecs.component.physics;

import it.unibo.pyxis.ecs.component.Component;
import it.unibo.pyxis.ecs.Entity;

public interface PhysicsComponent<T extends Entity> extends Component<T> {
    /**
     * Executes an update on the {@link Entity}.
     *
     * @param elapsed The time elapsed between two call of the update method.
     */
    void update(double elapsed);
}
