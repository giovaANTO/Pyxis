package it.unibo.pyxis.ecs.component.graphic;

import it.unibo.pyxis.ecs.component.Component;
import it.unibo.pyxis.ecs.entity.Entity;

public interface SpriteComponent<T extends Entity> extends Component<T> {
    /**
     * Obtain the sprite representation of the component.
     * @return
     *          A String containing the path of the sprite.
     */
    String obtainSprite();
}
