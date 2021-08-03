package it.unibo.pyxis.model.arena.component;

import it.unibo.pyxis.model.arena.Arena;
import it.unibo.pyxis.model.ecs.component.physics.AbstractPhysicsComponent;

public class ArenaPhysicsComponent extends AbstractPhysicsComponent<Arena> {

    public ArenaPhysicsComponent(final Arena entity) {
        super(entity);
    }

    @Override
    public void update(final double elapsed) {
        System.out.println(this.getClass().getSuperclass().getInterfaces()[0]);
    }
}
