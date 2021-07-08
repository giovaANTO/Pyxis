package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.controller.controllers.Controller;
import it.unibo.pyxis.model.level.Level;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneLoaderImpl implements SceneLoader {

    private final SceneLoading sceneLoading;

    public SceneLoaderImpl(final Level inputLevel) {
        this.sceneLoading = new SceneLoadingImpl(inputLevel);
    }

    @Override
    public final void switchScene(final Stage inputStage, final SceneType inputSceneType) {
        inputStage.setScene(this.loadNewScene(inputSceneType));
        inputStage.show();
    }

    @Override
    public final void setLevel(final Level inputLevel) {
        this.sceneLoading.setLevel(inputLevel);
    }

    @Override
    public final Controller getCurrentController() {
        return this.sceneLoading.getCurrentController();
    }

    private Scene loadNewScene(final SceneType inputSceneType) {
        return new Scene(this.sceneLoading.getScene(inputSceneType));
    }
}
