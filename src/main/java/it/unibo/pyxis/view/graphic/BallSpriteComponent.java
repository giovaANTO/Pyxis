package it.unibo.pyxis.view.graphic;

import it.unibo.pyxis.ecs.component.sprite.AbstractSpriteComponent;
import it.unibo.pyxis.model.element.ball.Ball;
import javafx.scene.image.Image;
import java.util.Objects;

public final class BallSpriteComponent extends AbstractSpriteComponent<Ball> {
    public BallSpriteComponent(final Ball entity) {
        super(entity);
    }

    /**
     * Return the filename to load.
     * @return
     *          The {@link Ball}'s filename to load.
     */
    private String getFileNameByBallType() {
        return this.getEntity().getType().getType() + "BALL.png";
    }

    @Override
    public Image obtainSprite() {
        final String path = this.getSpritesPath() + this.getFileNameByBallType();
        return new Image(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream(path)));
    }
}
