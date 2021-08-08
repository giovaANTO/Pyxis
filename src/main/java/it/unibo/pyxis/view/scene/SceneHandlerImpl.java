package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.controller.controllers.Controller;
import it.unibo.pyxis.controller.linker.Linker;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class SceneHandlerImpl implements SceneHandler {

    private final Linker linker;
    private final Loader loader;
    private final Stage stage;
    private Controller currentController;

    public SceneHandlerImpl(final Stage inputStage, final Linker inputLinker) {
        this.linker = inputLinker;
        this.loader = new LoaderImpl();
        this.stage = inputStage;
        this.stage.setOnCloseRequest(event -> {
            this.linker.quit();
        });
    }

    @Override
    public void close() {
        this.stage.close();
    }

    @Override
    public void switchScene(final SceneType inputSceneType) {
        this.currentControllerSetup(inputSceneType);
        this.stage.setScene(this.loadNewScene(inputSceneType));
        this.stage.show();
    }

    /**
     *
     * @param inputSceneType
     */
    private void currentControllerSetup(final SceneType inputSceneType) {
        this.currentController = inputSceneType.getController();
        this.currentController.setLinker(this.linker);
    }

    @Override
    public Controller getCurrentController() {
        return this.currentController;
    }

    /**
     *
     * @param inputSceneType
     * @return
     */
    private Scene loadNewScene(final SceneType inputSceneType) {
        return new Scene(this.loader.getScene(inputSceneType, this.currentController));
    }
}
