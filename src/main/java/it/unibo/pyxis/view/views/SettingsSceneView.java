package it.unibo.pyxis.view.views;


import it.unibo.pyxis.controller.controllers.SettingsSceneController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsSceneView extends AbstractJavaFXView {

    @FXML
    private AnchorPane menuPane;
    @FXML
    private Button backButton;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {

    }

    public final void backToMainMenu() {
        SettingsSceneController controller = (SettingsSceneController) this.getController();
        controller.backToMainMenu();
    }
}
