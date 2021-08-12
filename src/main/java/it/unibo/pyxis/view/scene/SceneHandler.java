package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.controller.Controller;

public interface SceneHandler {
    /**
     * Close the application's {@link javafx.stage.Stage}.
     */
    void close();

    /**
     * Return the {@link Controller} bound to the current
     * {@link it.unibo.pyxis.view.View}.
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
