package it.unibo.pyxis.view.scene;

import javafx.scene.Parent;

public interface SceneFactory {

    Parent getScene(SceneType sceneType);

}
