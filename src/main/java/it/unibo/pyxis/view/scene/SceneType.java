package it.unibo.pyxis.view.scene;


import it.unibo.pyxis.controller.controllers.Controller;

public enum SceneType {

    MENU_SCENE("MenuScene", null),
    SETTINGS_SCENE("SettingsScene", null),
    SELECT_LEVEL_SCENE("SelectLevelScene", null),
    GAME_SCENE("GameScene", null),
    PAUSE_SCENE("PauseScene", null),
    END_LEVEL_SCENE("EndLevelScene", null),
    QUITTING_SCENE("QuittingScene", null);

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
