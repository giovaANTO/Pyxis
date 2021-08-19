package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.controller.Controller;
import it.unibo.pyxis.controller.EndLevelController;
import it.unibo.pyxis.controller.GameController;
import it.unibo.pyxis.controller.MenuController;
import it.unibo.pyxis.controller.PauseController;
import it.unibo.pyxis.controller.SelectLevelController;
import it.unibo.pyxis.controller.SettingsController;

public enum SceneType {
    /**
     * The main menu's Scene.
     */
    MENU_SCENE("MenuScene", new MenuController()),

    /**
     * The settings menu's Scene.
     */
    SETTINGS_SCENE("SettingsScene", new SettingsController()),

    /**
     * The select level menu's Scene.
     */
    SELECT_LEVEL_SCENE("SelectLevelScene", new SelectLevelController()),

    /**
     * The game Scene.
     */
    GAME_SCENE("GameScene", new GameController()),

    /**
     * The pause menu's Scene.
     */
    PAUSE_SCENE("PauseScene", new PauseController()),

    /**
     * The end level menu's Scene.
     */
    END_LEVEL_SCENE("EndLevelScene", new EndLevelController());

    private final String name;
    private final Controller controller;

    SceneType(final String inputName, final Controller inputController) {
        this.name = inputName;
        this.controller = inputController;
    }
    /**
     * Return the {@link javafx.scene.Scene} name.
     *
     * @return The name of the {@link SceneType}.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Return the {@link Controller} bound to the {@link javafx.scene.Scene}.
     *
     * @return The {@link Controller} bound to the {@link SceneType}.
     */
    public Controller getController() {
        return this.controller;
    }
}
