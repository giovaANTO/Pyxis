package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.controller.controllers.Controller;
import it.unibo.pyxis.model.level.Level;
import javafx.stage.Stage;

public interface SceneHandler {
    /**
     *
     * @param sceneType
     */
    void switchScene(SceneType sceneType);

    /**
     *
     */
    void close();

    /**
     *
     * @return
     */
    Controller getCurrentController();
}
