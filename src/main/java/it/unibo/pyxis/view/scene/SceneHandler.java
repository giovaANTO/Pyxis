package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.controller.Controller;
import it.unibo.pyxis.view.View;
import javafx.stage.Stage;

public interface SceneHandler {
    /**
     * Close the application's {@link Stage}.
     */
    void close();

    /**
     * Return the {@link Controller} bound to the current
     * {@link View}.
     *
     * @return The current {@link Controller}.
     */
    Controller getCurrentController();

    /**
     * Loads and shows the input {@link javafx.scene.Scene}.
     *
     * @param sceneType The {@link SceneType} to set.
     */
    void switchScene(SceneType sceneType);
}
