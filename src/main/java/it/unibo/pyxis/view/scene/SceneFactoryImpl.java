package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.view.views.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import it.unibo.pyxis.controller.controllers.*;
import java.io.IOException;

public class SceneFactoryImpl implements SceneFactory {

    private static final String FIRST_ROOT_PATH = "layouts/scenebuilder/";
    private static final String SECOND_ROOT_PATH = ".fxml";
    private Level level;

    public SceneFactoryImpl(final Level inputLevel) {
        this.level = inputLevel;
    }

    public final void setLevel(final Level inputLevel) {
        this.level = inputLevel;
    }

    public final Parent getScene(final SceneType inputSceneType) {
        FXMLLoader loader = this.getFxLoader(inputSceneType);
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        loader.<View>getController().
                setController(inputSceneType.getController());
        this.setControllerLevel(loader.<View>getController().getController());
        return root;
    }

    @Override
    public final Parent getMenuScene() {
        FXMLLoader loader = this.getScene(SceneType.MENU_SCENE);
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        loader.<View>getController().
                setController(SceneType.MENU_SCENE.getController());
        this.setControllerLevel(loader.<View>getController().getController());
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
        loader.<View>getController().
                setController(SceneType.SETTINGS_SCENE.getController());
        this.setControllerLevel(loader.<View>getController().getController());
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
        loader.<View>getController().
                setController(SceneType.SELECT_LEVEL_SCENE.getController());
        this.setControllerLevel(loader.<View>getController().getController());
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
        loader.<View>getController().
                setController(SceneType.GAME_SCENE.getController());
        this.setControllerLevel(loader.<View>getController().getController());
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
        loader.<View>getController().
                setController(SceneType.PAUSE_SCENE.getController());
        this.setControllerLevel(loader.<View>getController().getController());
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
        loader.<View>getController().
                setController(SceneType.END_LEVEL_SCENE.getController());
        this.setControllerLevel(loader.<View>getController().getController());
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
        loader.<View>getController().
                setController(SceneType.QUITTING_SCENE.getController());
        this.setControllerLevel(loader.<View>getController().getController());
        return root;
    }

    private FXMLLoader getFxLoader(final SceneType inputScene) {
        return new FXMLLoader(ClassLoader.
                getSystemResource(FIRST_ROOT_PATH + inputScene.getName()
                        + SECOND_ROOT_PATH));
    }

    private void setControllerLevel(final Controller inputController) {
        inputController.setLevel(this.level);
    }
}
