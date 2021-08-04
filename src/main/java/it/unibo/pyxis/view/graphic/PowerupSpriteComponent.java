package it.unibo.pyxis.view.graphic;

import it.unibo.pyxis.ecs.component.sprite.AbstractSpriteComponent;
import it.unibo.pyxis.model.element.powerup.Powerup;
import javafx.scene.image.Image;

public final class PowerupSpriteComponent extends AbstractSpriteComponent<Powerup> {
    public PowerupSpriteComponent(final Powerup entity) {
        super(entity);
    }

    @Override
    public Image obtainSprite() {
        return null;
    }
}
