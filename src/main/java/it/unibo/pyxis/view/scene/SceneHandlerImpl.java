package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.controller.Controller;
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
        this.stage.setOnCloseRequest(event -> this.linker.quit());
    }
    /**
     * Loads the new current {@link Controller} from the new {@link Scene} loaded,
     * and binds it to the {@link Linker}.
     *
     * @param inputSceneType The {@link SceneType} to get the current {@link Controller}
     *                       from.
     */
    private void currentControllerSetup(final SceneType inputSceneType) {
        this.currentController = inputSceneType.getController();
        this.currentController.setLinker(this.linker);
    }
    /**
     * Loads and returns the new {@link Scene} loaded by the {@link Loader}.
     *
     * @param inputSceneType The {@link SceneType} to load.
     * @return The new {@link Scene} loaded.
     */
    private Scene loadNewScene(final SceneType inputSceneType) {
        return new Scene(this.loader.getScene(inputSceneType, this.currentController));
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void close() {
        this.stage.close();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Controller getCurrentController() {
        return this.currentController;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void switchScene(final SceneType inputSceneType) {
        this.currentControllerSetup(inputSceneType);
        this.stage.setScene(this.loadNewScene(inputSceneType));
        this.stage.show();
    }
}
