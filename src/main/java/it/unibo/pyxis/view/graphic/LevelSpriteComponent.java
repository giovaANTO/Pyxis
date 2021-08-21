package it.unibo.pyxis.view.graphic;

import it.unibo.pyxis.ecs.component.sprite.AbstractSpriteComponent;
import it.unibo.pyxis.model.level.Level;

public final class LevelSpriteComponent extends AbstractSpriteComponent<Level> {

    public LevelSpriteComponent(final Level entity) {
        super(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFileName() {
        return this.getBackgroundPath() + this.getEntity().getLevelNumber() + "BACKGROUND.png";
    }
}
