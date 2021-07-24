package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.controller.controllers.Controller;
import it.unibo.pyxis.model.level.Level;
import javafx.stage.Stage;

public interface SceneLoader {

    void init(Stage inputStage, Level inputLevel);

    void switchScene(SceneType sceneType);

    void setLevel(Level level);

    Controller getCurrentController();
}
