package it.unibo.pyxis.view.graphic;

import it.unibo.pyxis.ecs.component.sprite.AbstractSpriteComponent;
import it.unibo.pyxis.model.element.brick.Brick;
import javafx.scene.image.Image;

import java.util.Objects;

public final class BrickSpriteComponent extends AbstractSpriteComponent<Brick> {
    public BrickSpriteComponent(final Brick entity) {
        super(entity);
    }

    /**
     * Return the filename to load.
     * @return
     *          The {@link Brick}'s filename to load.
     */
    private String getFileNameByBrickType() {
        return this.getEntity().getBrickType().getTypeString() + "BRICK.png";
    }

    @Override
    public Image obtainSprite() {
        final String path = this.getSpritesPath() + this.getFileNameByBrickType();
        return new Image(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream(path)));
    }
}
