package it.unibo.pyxis.controller.controllers;

public class MenuSceneController extends AbstractController {
    /**
     * Quits the application.
     */
    public final void quit() {
        this.getLinker().quit();
    }
    /**
     * Loads the {@link it.unibo.pyxis.view.views.SelectLevelSceneView}.
     */
    public final void selectLevel() {
        this.getLinker().selectLevel();
    }
    /**
     * Loads the {@link it.unibo.pyxis.view.views.SettingsSceneView}.
     */
    public final void showSettings() {
        this.getLinker().settings();
    }
    /**
     * Loads the {@link it.unibo.pyxis.view.views.GameSceneView}.
     */
    public final void startNewGame() {
        this.getLinker().run();
    }
}
