package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.controller.controllers.Controller;
import javafx.stage.Stage;

public interface SceneHandler {
    /**
     * Close the application's {@link Stage}.
     */
    void close();

    /**
     * Return the {@link Controller} bound to the current
     * {@link it.unibo.pyxis.view.views.View}.
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
