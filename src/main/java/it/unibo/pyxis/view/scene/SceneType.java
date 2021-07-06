package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.view.Controller;

public enum SceneType {

    MENU_SCENE(null, null),
    SETTINGS_SCENE(null, null),
    SELECT_LEVEL_SCENE(null, null),
    GAME_SCENE(null, null),
    PAUSE_SCENE(null, null),
    END_LEVEL_SCENE(null, null),
    QUITTING_SCENE(null, null);

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
