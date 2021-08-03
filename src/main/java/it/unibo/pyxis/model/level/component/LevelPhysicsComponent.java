package it.unibo.pyxis.model.level.component;

import it.unibo.pyxis.model.ecs.component.physics.AbstractPhysicsComponent;
import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.model.level.status.LevelStatus;

public class LevelPhysicsComponent extends AbstractPhysicsComponent<Level> {

    public LevelPhysicsComponent(final Level entity) {
        super(entity);
    }

    @Override
    public void update(final double elapsed) {
        this.getEntity().getArena().update(elapsed);
        if (this.getEntity().getArena().isCleared()) {
            this.getEntity().setLevelStatus(LevelStatus.SUCCESSFULLY_COMPLETED);
        }
    }
}
