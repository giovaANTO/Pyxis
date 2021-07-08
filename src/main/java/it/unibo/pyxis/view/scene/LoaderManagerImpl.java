package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.model.level.Level;
import javafx.stage.Stage;

public final class LoaderManagerImpl implements LoaderManager {

    private SceneLoader sceneLoader;

    public void setInstance(final Stage inputStage, final Level inputLevel) {
        if (this.sceneLoader == null) {
            this.sceneLoader = new SceneLoaderImpl(inputStage, inputLevel);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public SceneLoader getInstance() {
        if (this.sceneLoader == null) {
            throw new IllegalArgumentException();
        }
        return this.sceneLoader;
    }
}
