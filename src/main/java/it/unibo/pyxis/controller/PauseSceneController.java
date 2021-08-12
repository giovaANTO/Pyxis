package it.unibo.pyxis.controller;

import it.unibo.pyxis.view.MenuSceneView;
import it.unibo.pyxis.view.SettingsSceneView;

public class PauseSceneController extends AbstractController {
    /**
     * Loads the {@link MenuSceneView}.
     */
    public final void menu() {
        this.getLinker().menu();
    }
    /**
     * Quits the application.
     */
    public final void quit() {
        this.getLinker().quit();
    }
    /**
     * Resumes the current game.
     */
    public final void resume() {
        this.getLinker().resume();
    }
    /**
     * Loads the {@link SettingsSceneView}.
     */
    public final void settings() {
        this.getLinker().settings();
    }
}
