package it.unibo.pyxis.view.scene;

import javafx.scene.Parent;

public interface SceneFactory {

    Parent getMenuScene();

    Parent getSettingsScene();

    Parent getSelectLevelScene();

    Parent getGameScene();

    Parent getPauseScene();

    Parent getEndLevelScene();

    Parent getQuittingScene();
}
