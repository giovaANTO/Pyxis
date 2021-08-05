package it.unibo.pyxis.view.views;

import it.unibo.pyxis.controller.controllers.MenuSceneController;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public final class MenuSceneView extends AbstractJavaFXView<MenuSceneController> {

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

    public MenuSceneView(final MenuSceneController inputController) {
        super(inputController);
    }

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

    public void startNewGame() {
        this.playInGameMusic();
        this.playStartGameButtonPressSound();
        this.getController().startNewGame();
    }
    public void showSettings() {
        this.playGenericButtonPressSound();
        this.getController().showSettings();
    }
    public void selectLevels() {
        this.playGenericButtonPressSound();
        this.getController().selectLevel();
    }
    public void quit() {
        this.playGenericButtonPressSound();
        this.getController().quit();
    }

}
