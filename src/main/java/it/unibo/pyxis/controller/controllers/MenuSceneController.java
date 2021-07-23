package it.unibo.pyxis.controller.controllers;

import it.unibo.pyxis.view.scene.SceneType;

public class MenuSceneController extends AbstractController {

    public final void startNewGame() {
        this.getLinker().run();
    }

    public final void quit() {
        this.getLinker().quit();
    }

    public final void showSettings() {
        this.getLinker().switchScene(SceneType.SETTINGS_SCENE);
    }

    public final void selectLevel() {
        this.getLinker().switchScene(SceneType.SELECT_LEVEL_SCENE);
    }
}
