package it.unibo.pyxis.view.views;

import it.unibo.pyxis.controller.controllers.SettingsSceneController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class SettingsSceneView extends AbstractView {

    @FXML
    private AnchorPane menuPane;
    @FXML
    private Button backButton;

    @Override
    public final void init() {
    }

    public final void backToMainMenu() {
        SettingsSceneController controller = (SettingsSceneController) this.getController();
        controller.backToMainMenu();
    }
}
