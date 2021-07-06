package it.unibo.pyxis.view.scene;

import javafx.scene.Parent;

public class SceneFactoryImpl implements SceneFactory {

    @Override
    public final Parent getScene(final SceneType inputSceneType) {

        switch (inputSceneType) {
            case MENU_SCENE:
                return this.getMenuScene();
            case SETTINGS_SCENE:
                return this.getSettingsScene();
            case SELECT_LEVEL_SCENE:
                return this.getSelectLevelScene();
            case GAME_SCENE:
                return this.getGameScene();
            case END_LEVEL_SCENE:
                return this.getEndLevelScene();
            case QUITTING_SCENE:
                return this.getQuittingScene();
            default:
                return this.getPauseScene();
        }
    }

    private Parent getMenuScene() {

    }
    private Parent getSettingsScene() {

    }
    private Parent getSelectLevelScene() {

    }
    private Parent getGameScene() {

    }

    private Parent getEndLevelScene() {

    }
    private Parent getQuittingScene() {

    }
    private Parent getPauseScene() {

    }
}
