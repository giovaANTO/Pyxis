package it.unibo.pyxis.controller;

import it.unibo.pyxis.view.GameSceneView;
import it.unibo.pyxis.view.SelectLevelSceneView;
import it.unibo.pyxis.view.SettingsSceneView;

public class MenuController extends AbstractController {
    /**
     * Quits the application.
     */
    public final void quit() {
        this.getLinker().quit();
    }
    /**
     * Loads the {@link SelectLevelSceneView}.
     */
    public final void selectLevel() {
        this.getLinker().selectLevel();
    }
    /**
     * Loads the {@link SettingsSceneView}.
     */
    public final void showSettings() {
        this.getLinker().settings();
    }
    /**
     * Loads the {@link GameSceneView}.
     */
    public final void startNewGame() {
        this.getLinker().run();
    }
}
