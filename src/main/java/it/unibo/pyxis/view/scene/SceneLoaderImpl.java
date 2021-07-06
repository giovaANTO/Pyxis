package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.view.model.Model;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class SceneLoaderImpl implements SceneLoader {

    final SceneFactory sceneFactory;
    final Model model;

    SceneLoaderImpl(final Stage inputStage, final SceneType inputSceneType, final Model inputModel) {
        this.sceneFactory = new SceneFactoryImpl();
        this.model = inputModel;
    }

    @Override
    public void switchScene(final Stage inputStage, final SceneType inputSceneType) {

    }

    private Parent loadNewScene(final SceneType inputSceneType) {

    }
}
