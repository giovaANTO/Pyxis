package it.unibo.pyxis.view;

import it.unibo.pyxis.controller.MenuController;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public final class MenuView extends AbstractJavaFXView<MenuController> {

    private static final Double SCALE_FACTOR = 1.5;
    private static final String IMG_PATH = "images/Pyxis.png";

    @FXML
    private StackPane mainPane;
    @FXML
    private VBox vBox;
    @FXML
    private ImageView img;

    public MenuView(final MenuController inputController) {
        super(inputController);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        this.vBox.prefWidthProperty().bind(this.mainPane.prefWidthProperty());
        this.vBox.prefHeightProperty().bind(this.mainPane.prefHeightProperty());
        this.img.setImage(new Image(Objects.requireNonNull(
                ClassLoader.getSystemResourceAsStream(IMG_PATH))));
        StackPane.setAlignment(this.vBox, Pos.CENTER);
        this.playMainMenuMusic();
    }

    /**
     * Applies the {@link it.unibo.pyxis.view.soundplayer.Sound} and calls the
     * {@link MenuController#quit()}.
     */
    public void quit() {
        this.playGenericButtonPressSound();
        this.getController().quit();
    }

    /**
     * Applies the {@link it.unibo.pyxis.view.soundplayer.Sound} and calls the
     * {@link MenuController#selectLevel()}.
     */
    public void selectLevels() {
        this.playGenericButtonPressSound();
        this.getController().selectLevel();
    }

    /**
     * Applies the {@link it.unibo.pyxis.view.soundplayer.Sound} and calls the
     * {@link MenuController#showSettings()}.
     */
    public void showSettings() {
        this.playGenericButtonPressSound();
        this.getController().showSettings();
    }

    /**
     * Applies the {@link it.unibo.pyxis.view.soundplayer.Sound} and calls the
     * {@link MenuController#startNewGame()}.
     */
    public void startNewGame() {
        this.playStartGameButtonPressSound();
        this.getController().startNewGame();
    }
}
