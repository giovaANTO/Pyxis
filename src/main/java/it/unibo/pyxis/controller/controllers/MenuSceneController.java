package it.unibo.pyxis.controller.controllers;

public class MenuSceneController extends AbstractController {

    public final void startNewGame() {
        this.getLinker().run();
    }

    public final void quit() {
        this.getLinker().quit();
    }

    public final void showSettings() {
        this.getLinker().settings();
    }

    public final void selectLevel() {
        this.getLinker().selectLevel();
    }
}
