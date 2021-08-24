package it.unibo.pyxis.controller;

public class PauseController extends AbstractController {
    /**
     * Loads the {@link it.unibo.pyxis.view.MenuView}.
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
     * Loads the {@link it.unibo.pyxis.view.SettingsView}.
     */
    public final void settings() {
        this.getLinker().settings();
    }

}
