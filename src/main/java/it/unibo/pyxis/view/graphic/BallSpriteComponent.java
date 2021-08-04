package it.unibo.pyxis.view.graphic;

import it.unibo.pyxis.ecs.component.sprite.AbstractSpriteComponent;
import it.unibo.pyxis.model.element.ball.Ball;
import javafx.scene.image.Image;

public final class BallSpriteComponent extends AbstractSpriteComponent<Ball> {
    public BallSpriteComponent(final Ball entity) {
        super(entity);
    }

    @Override
    public Image obtainSprite() {
        return null;
    }
}
