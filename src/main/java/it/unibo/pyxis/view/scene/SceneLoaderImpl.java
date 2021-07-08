package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.controller.controllers.Controller;
import it.unibo.pyxis.model.level.Level;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneLoaderImpl implements SceneLoader {

    private final SceneLoading sceneLoading;
    private final Stage stage;

    public SceneLoaderImpl(final Stage inputStage, final Level inputLevel) {
        this.sceneLoading = new SceneLoadingImpl(inputLevel);
        this.stage = inputStage;
    }

    @Override
    public final void switchScene(final SceneType inputSceneType) {
        this.stage.setScene(this.loadNewScene(inputSceneType));
        this.stage.show();
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
        System.out.println(inputSceneType);
        return new Scene(this.sceneLoading.getScene(inputSceneType));
    }
}
