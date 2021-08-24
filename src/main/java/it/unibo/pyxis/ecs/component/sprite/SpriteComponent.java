package it.unibo.pyxis.ecs.component.sprite;

import it.unibo.pyxis.ecs.component.Component;
import it.unibo.pyxis.ecs.Entity;
import javafx.scene.image.Image;

public interface SpriteComponent<T extends Entity> extends Component<T> {
    /**
     * Obtains the sprite representation of the component.
     *
     * @return A String containing the path of the sprite.
     */
    Image obtainSprite();

    /**
     * Returns the filename of the sprite to load.
     *
     * @return The string containing the filename.
     */
    String getFileName();

    /**
     * Gets the sprites path.
     *
     * @return A string containing the sprites path.
     */
    default String getSpritesPath() {
        return "sprites/";
    }
    
    /**
     * Gets the background path.
     *
     * @return A string containing the sprites path.
     */
    default String getBackgroundPath() {
        return "backgrounds/";
    }


}
