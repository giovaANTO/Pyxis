package it.unibo.pyxis.view.graphic;

import it.unibo.pyxis.ecs.component.sprite.AbstractSpriteComponent;
import it.unibo.pyxis.model.level.Level;
import javafx.scene.image.Image;

import java.util.Objects;

public final class LevelSpriteComponent extends AbstractSpriteComponent<Level> {
    public LevelSpriteComponent(final Level entity) {
        super(entity);
    }

    private String getFileNameByLevelNumber() {
        return 1 + "BACKGROUND.png";
    }

    @Override
    public Image obtainSprite() {
        final String path = this.getBackgroundPath() + this.getFileNameByLevelNumber();
        return new Image(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream(path)));
    }
}
