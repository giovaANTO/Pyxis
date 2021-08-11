package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.controller.*;

public enum SceneType {
    /**
     * The main menu's Scene.
     */
    MENU_SCENE("MenuScene", new MenuSceneController()),
    /**
     * The settings menu's Scene.
     */
    SETTINGS_SCENE("SettingsScene", new SettingsSceneController()),
    /**
     * The select level menu's Scene.
     */
    SELECT_LEVEL_SCENE("SelectLevelScene", new SelectLevelSceneController()),
    /**
     * The game Scene.
     */
    GAME_SCENE("GameScene", new GameSceneController()),
    /**
     * The pause menu's Scene.
     */
    PAUSE_SCENE("PauseScene", new PauseSceneController()),
    /**
     * The end level menu's Scene.
     */
    END_LEVEL_SCENE("EndLevelScene", new EndLevelSceneController());

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
