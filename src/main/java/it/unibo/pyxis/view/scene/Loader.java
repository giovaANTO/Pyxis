package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.controller.Controller;
import javafx.scene.Parent;

public interface Loader {
    /**
     * Loads and then returns a new {@link javafx.scene.Scene} of the input
     * {@link SceneType} already binded with the input {@link Controller}.
     *
     * @param sceneType The {@link SceneType} required.
     * @param controller The {@link Controller} to bind.
     * @return The new {@link javafx.scene.Scene}.
     */
    Parent getScene(SceneType sceneType, Controller controller);
}
