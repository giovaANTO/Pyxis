package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.controller.Controller;
import it.unibo.pyxis.view.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class LoaderImpl implements Loader {

    private static final String FIRST_ROOT_PATH = "layouts/scenebuilder/";
    private static final String SECOND_ROOT_PATH = ".fxml";

    /**
     * Returns the {@link FXMLLoader} located on the resources of the input
     * {@link SceneType}.
     *
     * @param inputScene The {@link SceneType} to load.
     * @return The {@link FXMLLoader} already located on the resources.
     */
    private FXMLLoader getFxLoader(final SceneType inputScene) {
        String scenePath = FIRST_ROOT_PATH + inputScene.getName() + SECOND_ROOT_PATH;
        return new FXMLLoader(ClassLoader.getSystemResource(scenePath));
    }
    /**
     * Binds the input {@link Controller} with the input {@link View}.
     *
     * @param inputView       The input {@link View}.
     * @param inputController The input {@link Controller}.
     * @param <C>             The {@link Controller} type bound to the {@link View}.
     */
    private <C extends Controller> void setupController(final View<C> inputView, final C inputController) {
        inputController.setView(inputView);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final Parent getScene(final SceneType inputSceneType, final Controller inputController) {
        FXMLLoader loader = this.getFxLoader(inputSceneType);
        loader.setControllerFactory(param -> {
            Object viewController;
            try {
                Class<?> currentControllerClass = inputController.getClass();
                viewController = param.getConstructor(currentControllerClass).
                        newInstance(inputController);
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
}
