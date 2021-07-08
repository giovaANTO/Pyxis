package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.model.level.Level;

public interface LoaderManager {

    void setInstance(Level level);

    SceneLoader getInstance();
}
