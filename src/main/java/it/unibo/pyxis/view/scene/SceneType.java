package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.controller.controllers.*;

public enum SceneType {

    MENU_SCENE("MenuScene", new MenuSceneController()),
    SETTINGS_SCENE("SettingsScene", new SettingsSceneController()),
    SELECT_LEVEL_SCENE("SelectLevelScene", new SelectLevelSceneController()),
    GAME_SCENE("GameScene", new GameSceneController()),
    PAUSE_SCENE("PauseScene", new PauseSceneController()),
    END_LEVEL_SCENE("EndLevelScene", new EndLevelSceneController()),
    QUITTING_SCENE("QuittingScene", new QuittingSceneController());

    private final String name;
    private final Controller controller;

    SceneType(final String inputName, final Controller inputController) {
        this.name = inputName;
        this.controller = inputController;
    }
    public String getName() {
        return this.name;
    }
    public Controller getController() {
        return this.controller;
    }
}
