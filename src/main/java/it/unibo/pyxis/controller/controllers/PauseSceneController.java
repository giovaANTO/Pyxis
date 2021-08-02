package it.unibo.pyxis.controller.controllers;

public class PauseSceneController extends AbstractController {

    public final void quit() {
        this.getLinker().quit();
    }

    public final void settings() {
        this.getLinker().settings();
    }

    public final void resume() {
        this.getLinker().resume();
    }

    public final void menu() {
        this.getLinker().menu();
    }
}
