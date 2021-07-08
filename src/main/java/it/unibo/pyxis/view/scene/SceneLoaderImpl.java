package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.model.level.Level;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneLoaderImpl implements SceneLoader {

    private final SceneFactory sceneFactory;

    public SceneLoaderImpl(final Level inputLevel) {
        this.sceneFactory = new SceneFactoryImpl(inputLevel);
    }

    @Override
    public final void switchScene(final Stage inputStage, final SceneType inputSceneType) {
        Scene newScene = this.loadNewScene(inputSceneType);
        inputStage.setScene(newScene);
        inputStage.show();
    }

    @Override
    public final void setLevel(final Level inputLevel) {
        this.sceneFactory.setLevel(inputLevel);
    }

    private Scene loadNewScene(final SceneType inputSceneType) {
        Parent root = null;
        switch (inputSceneType) {
            case MENU_SCENE:
                root = this.sceneFactory.getMenuScene();
                break;
            case SETTINGS_SCENE:
                root = this.sceneFactory.getSettingsScene();
                break;
            case SELECT_LEVEL_SCENE:
                root = this.sceneFactory.getSelectLevelScene();
                break;
            case GAME_SCENE:
                root = this.sceneFactory.getGameScene();
                break;
            case PAUSE_SCENE:
                root = this.sceneFactory.getPauseScene();
                break;
            case END_LEVEL_SCENE:
                root = this.sceneFactory.getEndLevelScene();
                break;
            case QUITTING_SCENE:
                root = this.sceneFactory.getQuittingScene();
                break;
            default:
                throw new IllegalArgumentException();
        }
        return new Scene(root);
    }
}
