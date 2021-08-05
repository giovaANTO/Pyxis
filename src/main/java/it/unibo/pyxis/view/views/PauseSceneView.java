package it.unibo.pyxis.view.views;

import it.unibo.pyxis.controller.controllers.PauseSceneController;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public final class PauseSceneView  extends AbstractJavaFXView<PauseSceneController> {

    @FXML
    private StackPane mainPane;
    @FXML
    private VBox vBox;

    public PauseSceneView(final PauseSceneController inputController) {
        super(inputController);
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        vBox.prefWidthProperty().bind(mainPane.prefWidthProperty());
        vBox.prefHeightProperty().bind(mainPane.prefHeightProperty());
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
