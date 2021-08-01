package it.unibo.pyxis.view.views;

import java.net.URL;
import java.util.ResourceBundle;
import it.unibo.pyxis.controller.controllers.SettingsSceneController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public final class SettingsSceneView extends AbstractJavaFXView<SettingsSceneController> {

    @FXML
    private AnchorPane menuPane;
    @FXML
    private Button backButton;

    public SettingsSceneView(final SettingsSceneController inputController) {
        super(inputController);
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
    }

    public void backToMainMenu() {
        this.getController().backToMainMenu();
    }

}
