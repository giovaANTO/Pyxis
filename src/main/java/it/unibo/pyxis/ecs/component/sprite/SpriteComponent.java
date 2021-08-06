package it.unibo.pyxis.ecs.component.sprite;

import it.unibo.pyxis.ecs.component.Component;
import it.unibo.pyxis.ecs.Entity;
import javafx.scene.image.Image;
import java.io.File;

public interface SpriteComponent<T extends Entity> extends Component<T> {
    /**
     * Obtain the sprite representation of the component.
     * @return
     *          A String containing the path of the sprite.
     */
    Image obtainSprite();

    /**
     * Return the filename of the sprite to load.
     * @return
     *          The string containing the filename.
     */
    String getFileName();

    /**
     * Get the sprites path.
     * @return
     *          A string containing the sprites path
     */
    default String getSpritesPath() {
        return "sprites" + File.separator;
    }

    /**
     * Get the background path.
     * @return
     *          A string containing the sprites path
     */
    default String getBackgroundPath() {
        return "backgrounds" + File.separator;
    }


}
