package it.unibo.pyxis.view.views;

import java.net.URL;
import java.util.ResourceBundle;
import it.unibo.pyxis.controller.controllers.EndLevelSceneController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public final class EndLevelSceneView extends AbstractJavaFXView<EndLevelSceneController> {

    @FXML
    private Button nextLevelButton, menuButton;

    public EndLevelSceneView(final EndLevelSceneController inputController) {
        super(inputController);
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        this.nextLevelButton.setDisable(this.getController().disableNextLevelButton());
    }

    public void menu() {
        this.getController().menu();
    }

    public void nextLevel() {
        this.getController().nextLevel();
    }
}
