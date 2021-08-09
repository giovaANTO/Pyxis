package it.unibo.pyxis.view.graphic;

import it.unibo.pyxis.ecs.component.sprite.AbstractSpriteComponent;
import it.unibo.pyxis.model.element.ball.Ball;

public final class BallSpriteComponent extends AbstractSpriteComponent<Ball> {

    private static final String BALL_FOLDER = "ball/";

    public BallSpriteComponent(final Ball entity) {
        super(entity);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String getFileName() {
        return this.getSpritesPath() + BALL_FOLDER + this.getEntity().getType().getType() + "_BALL.png";
    }

}
