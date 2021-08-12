package it.unibo.pyxis.controller;

import it.unibo.pyxis.view.GameView;
import it.unibo.pyxis.view.SelectLevelView;
import it.unibo.pyxis.view.SettingsView;

public class MenuController extends AbstractController {
    /**
     * Quits the application.
     */
    public final void quit() {
        this.getLinker().quit();
    }
    /**
     * Loads the {@link SelectLevelView}.
     */
    public final void selectLevel() {
        this.getLinker().selectLevel();
    }
    /**
     * Loads the {@link SettingsView}.
     */
    public final void showSettings() {
        this.getLinker().settings();
    }
    /**
     * Loads the {@link GameView}.
     */
    public final void startNewGame() {
        this.getLinker().run();
    }
}
