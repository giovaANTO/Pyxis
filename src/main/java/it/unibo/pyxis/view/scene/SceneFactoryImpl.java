package it.unibo.pyxis.view.scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class SceneFactoryImpl implements SceneFactory {

    private static final String FIRST_PATH = "layouts/scenebuilder/";
    private static final String SECOND_PATH = ".fxml";
    private Parent root;

    @Override
    public final Parent getScene(final SceneType inputSceneType) {
        return getAScene(inputSceneType);
    }

    private Parent getAScene(final SceneType inputScene) {
        try {
            this.root = FXMLLoader.load(ClassLoader.
                    getSystemResource(FIRST_PATH + inputScene.getName() + SECOND_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.root;
    }

    private void loadController() {

    }
}
