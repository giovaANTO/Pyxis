package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.view.model.Model;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneLoaderImpl implements SceneLoader {

    private final SceneFactory sceneFactory;
    private final Model model;

    SceneLoaderImpl(final Stage inputStage, final SceneType inputSceneType, final Model inputModel) {
        this.sceneFactory = new SceneFactoryImpl();
        this.model = inputModel;
    }

    @Override
    public final void switchScene(final Stage inputStage, final SceneType inputSceneType) {
        Scene newScene = this.loadNewScene(inputSceneType);
        inputStage.setScene(newScene);
        inputStage.show();
    }

    private Scene loadNewScene(final SceneType inputSceneType) {
        Parent root = this.sceneFactory.getScene(inputSceneType);
        return new Scene(root);
    }
}
