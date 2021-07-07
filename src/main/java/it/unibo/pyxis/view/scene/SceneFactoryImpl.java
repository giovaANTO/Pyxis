package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.view.views.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import it.unibo.pyxis.controller.controllers.*;

import java.io.IOException;

public class SceneFactoryImpl implements SceneFactory {

    private static final String FIRST_ROOT_PATH = "layouts/scenebuilder/";
    private static final String SECOND_ROOT_PATH = ".fxml";

    @Override
    public final Parent getMenuScene() {
        FXMLLoader loader = this.getScene(SceneType.MENU_SCENE);
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        loader.<View>getController().setController(new MenuSceneController(loader.getController()));
        return root;
    }

    @Override
    public final Parent getSettingsScene() {
        FXMLLoader loader = this.getScene(SceneType.SETTINGS_SCENE);
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        loader.<View>getController().setController(new SettingsSceneController(loader.getController()));
        return root;
    }

    @Override
    public final Parent getSelectLevelScene() {
        FXMLLoader loader = this.getScene(SceneType.SELECT_LEVEL_SCENE);
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        loader.<View>getController().setController(new SelectLevelSceneController(loader.getController()));
        return root;
    }

    @Override
    public final Parent getGameScene() {
        FXMLLoader loader = this.getScene(SceneType.GAME_SCENE);
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        loader.<View>getController().setController(new GameSceneController(loader.getController()));
        return root;
    }

    @Override
    public final Parent getPauseScene() {
        FXMLLoader loader = this.getScene(SceneType.PAUSE_SCENE);
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        loader.<View>getController().setController(new PauseSceneController(loader.getController()));
        return root;
    }

    @Override
    public final Parent getEndLevelScene() {
        FXMLLoader loader = this.getScene(SceneType.END_LEVEL_SCENE);
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        loader.<View>getController().setController(new EndLevelSceneController(loader.getController()));
        return root;
    }

    @Override
    public final Parent getQuittingScene() {
        FXMLLoader loader = this.getScene(SceneType.QUITTING_SCENE);
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        loader.<View>getController().setController(new QuittingSceneController(loader.getController()));
        return root;
    }

    private FXMLLoader getScene(final SceneType inputScene) {
        return new FXMLLoader(ClassLoader.
                getSystemResource(FIRST_ROOT_PATH + inputScene.getName()
                        + SECOND_ROOT_PATH));
    }
}
