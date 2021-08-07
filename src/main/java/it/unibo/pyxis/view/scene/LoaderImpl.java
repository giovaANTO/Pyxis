package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.controller.controllers.Controller;
import it.unibo.pyxis.view.views.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class LoaderImpl implements Loader {

    private static final String FIRST_ROOT_PATH = "layouts/scenebuilder/";
    private static final String SECOND_ROOT_PATH = ".fxml";

    public final Parent getScene(final SceneType inputSceneType, final Controller inputController) {
        FXMLLoader loader = this.getFxLoader(inputSceneType);
        loader.setControllerFactory(param -> {
            Object viewController;
            try {
                Class<?> currentControllerClass = inputController.getClass();
                viewController = param.getConstructor(currentControllerClass).newInstance(inputController);
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
        this.setupController(loader.getController(), inputController);
        return root;
    }

    private FXMLLoader getFxLoader(final SceneType inputScene) {
        return new FXMLLoader(ClassLoader.
                getSystemResource(FIRST_ROOT_PATH + inputScene.getName()
                        + SECOND_ROOT_PATH));
    }

    private <C extends Controller> void setupController(final View<C> inputView, final C inputController) {
        inputController.setView(inputView);
    }
}
