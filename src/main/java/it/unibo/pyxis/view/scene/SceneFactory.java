package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.model.level.Level;
import javafx.scene.Parent;

public interface SceneFactory {

    void setLevel(Level level);

    Parent getMenuScene();

    Parent getSettingsScene();

    Parent getSelectLevelScene();

    Parent getGameScene();

    Parent getPauseScene();

    Parent getEndLevelScene();

    Parent getQuittingScene();
}
