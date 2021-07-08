package it.unibo.pyxis.view.scene;

public final class LoaderManager {

    private final SceneLoader sceneLoader;

    private LoaderManager() { }

    public SceneLoader getInstance() {
        if (this.sceneLoader != null) {
            return this.sceneLoader;
        } else {
            this.sceneLoader = new SceneLoaderImpl()
        }
    }
}
