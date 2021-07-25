package it.unibo.pyxis.view.views;

import it.unibo.pyxis.controller.controllers.MenuSceneController;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuSceneView extends AbstractJavaFXView<MenuSceneController> {

    private static final Double SCALE_FACTOR = 1.5;

    @FXML
    private StackPane mainPane;
    @FXML
    private VBox vBox;
    @FXML
    private Button newGameButton;
    @FXML
    private Button settingsButton;
    @FXML
    private Button levelsButton;
    @FXML
    private Button quitButton;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {

        vBox.prefWidthProperty().bind(mainPane.prefWidthProperty());
        vBox.prefHeightProperty().bind(mainPane.prefHeightProperty());


        newGameButton.setPrefWidth(mainPane.getPrefWidth() / SCALE_FACTOR);
        settingsButton.setPrefWidth(mainPane.getPrefWidth() / SCALE_FACTOR);
        levelsButton.setPrefWidth(mainPane.getPrefWidth() / SCALE_FACTOR);
        quitButton.setPrefWidth(mainPane.getPrefWidth() / SCALE_FACTOR);

        StackPane.setAlignment(vBox, Pos.CENTER);
    }

    public final void startNewGame() {
        this.getController().startNewGame();
    }
    public final void showSettings() {
        this.getController().showSettings();
    }
    public final void selectLevels() {
        this.getController().selectLevel();
    }
    public final void quit() {
        this.getController().quit();
    }


}
