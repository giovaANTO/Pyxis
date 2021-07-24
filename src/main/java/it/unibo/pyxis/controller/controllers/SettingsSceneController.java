package it.unibo.pyxis.controller.controllers;

import it.unibo.pyxis.view.scene.SceneType;

public class SettingsSceneController extends AbstractController {

    public final void backToMainMenu() {
        this.getLinker().switchScene(SceneType.MENU_SCENE);
    }

}
