package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.controller.controllers.Controller;
import it.unibo.pyxis.model.level.Level;
import javafx.stage.Stage;

public interface SceneHandler {

    void switchScene(SceneType sceneType);

    void close();

    Controller getCurrentController();
}
