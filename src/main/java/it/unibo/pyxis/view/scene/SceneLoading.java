package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.controller.controllers.Controller;
import it.unibo.pyxis.model.level.Level;
import javafx.scene.Parent;

public interface SceneLoading {

    void setLevel(Level level);

    Parent getScene(SceneType sceneType);

    Controller getCurrentController();
}
