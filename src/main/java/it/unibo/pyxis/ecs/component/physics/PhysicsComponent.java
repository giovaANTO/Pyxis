package it.unibo.pyxis.ecs.component.physics;

import it.unibo.pyxis.ecs.component.Component;
import it.unibo.pyxis.ecs.entity.Entity;

public interface PhysicsComponent<T extends Entity> extends Component<T> {
    /**
     * Execute an update on the {@link Entity}.
     * @param elapsed
     *                  Time gap between two call of the update method
     */
    void update(double elapsed);
}
