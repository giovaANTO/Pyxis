package it.unibo.pyxis.ecs.component.sprite;

import it.unibo.pyxis.ecs.component.Component;
import it.unibo.pyxis.ecs.entity.Entity;
import javafx.scene.image.Image;

public interface SpriteComponent<T extends Entity> extends Component<T> {
    /**
     * Obtain the sprite representation of the component.
     * @return
     *          A String containing the path of the sprite.
     */
    Image obtainSprite();
}
