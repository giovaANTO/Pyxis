package it.unibo.pyxis.controller.controllers;

public class PauseSceneController extends AbstractController {
    /**
     * Loads the {@link it.unibo.pyxis.view.views.MenuSceneView}.
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
     * Loads the {@link it.unibo.pyxis.view.views.SettingsSceneView}.
     */
    public final void settings() {
        this.getLinker().settings();
    }
}
