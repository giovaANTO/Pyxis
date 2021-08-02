package it.unibo.pyxis.view.views;

import it.unibo.pyxis.controller.controllers.PauseSceneController;

import java.net.URL;
import java.util.ResourceBundle;

public final class PauseSceneView  extends AbstractJavaFXView<PauseSceneController> {

    public PauseSceneView(final PauseSceneController inputController) {
        super(inputController);
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {

    }

    public void quit() {
        this.getController().quit();
    }

    public void settings() {
        this.getController().settings();
    }

    public void resume() {
        this.getController().resume();
    }

    public void menu() {
        this.getController().menu();
    }
}
