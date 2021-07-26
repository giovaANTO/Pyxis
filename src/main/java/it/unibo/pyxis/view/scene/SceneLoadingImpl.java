package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.controller.controllers.Controller;
import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.view.views.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

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
        this.currentController = inputSceneType.getController();
        FXMLLoader loader = this.getFxLoader(inputSceneType);
        loader.setControllerFactory(param -> {
            Object viewController;
            try {
                Class<?> currentControllerClass = this.currentController.getClass();
                viewController = param.getConstructor(currentControllerClass).newInstance(this.currentController);
            } catch (ReflectiveOperationException ex) {
                throw new RuntimeException(ex);
            }
            return viewController;
        });
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setupController(loader.getController(), this.currentController);
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

    private <C extends Controller> void setupController(final View<C> inputView, final C inputController) {
        inputController.setView(inputView);
        inputController.setLevel(this.level);
    }
}
