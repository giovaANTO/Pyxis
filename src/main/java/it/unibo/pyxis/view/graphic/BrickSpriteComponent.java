package it.unibo.pyxis.view.graphic;

import it.unibo.pyxis.ecs.component.sprite.AbstractSpriteComponent;
import it.unibo.pyxis.model.element.brick.Brick;
import javafx.scene.image.Image;

public final class BrickSpriteComponent extends AbstractSpriteComponent<Brick> {
    public BrickSpriteComponent(final Brick entity) {
        super(entity);
    }

    @Override
    public Image obtainSprite() {
        return null;
    }
}
