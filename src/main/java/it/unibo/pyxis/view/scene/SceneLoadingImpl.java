package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.view.views.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import it.unibo.pyxis.controller.controllers.*;
import java.io.IOException;

public class SceneLoadingImpl implements SceneLoading {

    private static final String FIRST_ROOT_PATH = "layouts/scenebuilder/";
    private static final String SECOND_ROOT_PATH = ".fxml";
    private Level level;
    private Controller currentController;

    public SceneLoadingImpl(final Level inputLevel) {
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
        this.currentController = inputSceneType.getController();
        this.setLevelAndController(loader.getController(), this.currentController);
        return root;
    }

    @Override
    public final Controller getCurrentController() {
        if (this.currentController == null) {
            throw new IllegalAccessError();
        }
        return this.currentController;
    }

    private FXMLLoader getFxLoader(final SceneType inputScene) {
        return new FXMLLoader(ClassLoader.
                getSystemResource(FIRST_ROOT_PATH + inputScene.getName()
                        + SECOND_ROOT_PATH));
    }

    private void setLevelAndController(final View inputView, final Controller inputController) {
        inputController.setView(inputView);
        inputController.setLevel(this.level);
        inputView.setController(inputController);
    }
}
