package it.unibo.pyxis.model.level.component;

import it.unibo.pyxis.ecs.component.physics.AbstractUpdateComponent;
import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.model.level.status.LevelStatus;

public class LevelUpdateComponent extends AbstractUpdateComponent<Level> {

    public LevelUpdateComponent(final Level entity) {
        super(entity);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final void update(final double elapsed) {
        this.getEntity().getArena().update(elapsed);
        if (this.getEntity().getArena().isCleared()) {
            this.getEntity().setLevelStatus(LevelStatus.SUCCESSFULLY_COMPLETED);
        }
    }
}
