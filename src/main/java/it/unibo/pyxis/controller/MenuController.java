package it.unibo.pyxis.controller;

public class MenuController extends AbstractController {
    /**
     * Quits the application.
     */
    public final void quit() {
        this.getLinker().quit();
    }
    /**
     * Loads the {@link it.unibo.pyxis.view.SelectLevelView}.
     */
    public final void selectLevel() {
        this.getLinker().selectLevel();
    }
    /**
     * Loads the {@link it.unibo.pyxis.view.SettingsView}.
     */
    public final void showSettings() {
        this.getLinker().settings();
    }
    /**
     * Loads the {@link it.unibo.pyxis.view.GameView}.
     */
    public final void startNewGame() {
        this.getLinker().run();
    }
}
