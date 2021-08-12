package it.unibo.pyxis.controller;

import it.unibo.pyxis.view.MenuView;
import it.unibo.pyxis.view.SettingsView;

public class PauseController extends AbstractController {
    /**
     * Loads the {@link MenuView}.
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
     * Loads the {@link SettingsView}.
     */
    public final void settings() {
        this.getLinker().settings();
    }
}
