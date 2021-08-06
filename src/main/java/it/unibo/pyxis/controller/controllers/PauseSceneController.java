package it.unibo.pyxis.controller.controllers;

public class PauseSceneController extends AbstractController {

    public final void menu() {
        this.getLinker().menu();
    }

    public final void quit() {
        this.getLinker().quit();
    }

    public final void resume() {
        this.getLinker().resume();
    }

    public final void settings() {
        this.getLinker().settings();
    }
}
