package it.unibo.pyxis.view.graphic;

import it.unibo.pyxis.ecs.component.sprite.AbstractSpriteComponent;
import it.unibo.pyxis.model.element.brick.Brick;

import java.io.File;


public final class BrickSpriteComponent extends AbstractSpriteComponent<Brick> {

    private static final String BRICK_FOLDER = "brick" + File.separator;

    public BrickSpriteComponent(final Brick entity) {
        super(entity);
    }


    @Override
    public String getFileName() {
        return this.getSpritesPath() + BRICK_FOLDER + this.getEntity().getBrickType().getTypeString() + "_BRICK.png";
    }

}
