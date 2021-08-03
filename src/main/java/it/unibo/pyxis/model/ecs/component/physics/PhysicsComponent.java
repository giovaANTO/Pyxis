package it.unibo.pyxis.model.ecs.component.physics;

import it.unibo.pyxis.model.ecs.component.Component;
import it.unibo.pyxis.model.ecs.entity.Entity;

public interface PhysicsComponent<T extends Entity> extends Component<T> {
    /**
     * Execute an update on the {@link Entity}.
     * @param elapsed
     *                  Time gap between two call of the update method
     */
    void update(double elapsed);
}
