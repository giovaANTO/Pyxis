package it.unibo.pyxis.view;

import it.unibo.pyxis.controller.MenuSceneController;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public final class MenuSceneView extends AbstractJavaFXView<MenuSceneController> {

    private static final Double SCALE_FACTOR = 1.5;
    private static final String SEP = File.separator;
    private static final String IMG_PATH = SEP + "images" + SEP;
    private static final String TITLE = "Pyxis.png";

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
    @FXML
    private ImageView img;

    public MenuSceneView(final MenuSceneController inputController) {
        super(inputController);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        this.vBox.prefWidthProperty().bind(this.mainPane.prefWidthProperty());
        this.vBox.prefHeightProperty().bind(this.mainPane.prefHeightProperty());
        this.newGameButton.setPrefWidth(this.mainPane.getPrefWidth() / SCALE_FACTOR);
        this.settingsButton.setPrefWidth(this.mainPane.getPrefWidth() / SCALE_FACTOR);
        this.levelsButton.setPrefWidth(this.mainPane.getPrefWidth() / SCALE_FACTOR);
        this.quitButton.setPrefWidth(this.mainPane.getPrefWidth() / SCALE_FACTOR);
        this.img.setImage(new Image(Objects.requireNonNull(
                getClass().getResourceAsStream(IMG_PATH + TITLE))));
        StackPane.setAlignment(this.vBox, Pos.CENTER);
        this.playMainMenuMusic();
    }
    /**
     * Applies the {@link it.unibo.pyxis.view.soundplayer.Sound} and calls the
     * {@link MenuSceneController#quit()}.
     */
    public void quit() {
        this.playGenericButtonPressSound();
        this.getController().quit();
    }
    /**
     * Applies the {@link it.unibo.pyxis.view.soundplayer.Sound} and calls the
     * {@link MenuSceneController#selectLevel()}.
     */
    public void selectLevels() {
        this.playGenericButtonPressSound();
        this.getController().selectLevel();
    }
    /**
     * Applies the {@link it.unibo.pyxis.view.soundplayer.Sound} and calls the
     * {@link MenuSceneController#showSettings()}.
     */
    public void showSettings() {
        this.playGenericButtonPressSound();
        this.getController().showSettings();
    }
    /**
     * Applies the {@link it.unibo.pyxis.view.soundplayer.Sound} and calls the
     * {@link MenuSceneController#startNewGame()}.
     */
    public void startNewGame() {
        this.playStartGameButtonPressSound();
        this.getController().startNewGame();
    }
}
