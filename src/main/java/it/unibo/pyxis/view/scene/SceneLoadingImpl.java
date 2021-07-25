package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.view.views.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import it.unibo.pyxis.controller.controllers.*;

import java.io.File;
import java.io.IOException;

public class SceneLoadingImpl implements SceneLoading {

    private static final String SEPARATOR = File.separator;
    private static final String FIRST_ROOT_PATH = "layouts" + SEPARATOR + "scenebuilder"
            + SEPARATOR;
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
        System.out.println(FIRST_ROOT_PATH + inputScene.getName()
                + SECOND_ROOT_PATH);
        return new FXMLLoader(ClassLoader.
                getSystemResource(FIRST_ROOT_PATH + inputScene.getName()
                        + SECOND_ROOT_PATH));
    }

    private <C extends Controller> void setLevelAndController(final View<C> inputView, final C inputController) {
        inputController.setView(inputView);
        inputController.setLevel(this.level);
        inputView.setController(inputController);
    }
}
