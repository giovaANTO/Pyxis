package it.unibo.pyxis.view;

import it.unibo.pyxis.controller.PauseSceneController;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public final class PauseSceneView extends AbstractJavaFXView<PauseSceneController> {

    @FXML
    private StackPane mainPane;
    @FXML
    private VBox vBox;

    public PauseSceneView(final PauseSceneController inputController) {
        super(inputController);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        vBox.prefWidthProperty().bind(mainPane.prefWidthProperty());
        vBox.prefHeightProperty().bind(mainPane.prefHeightProperty());
    }
    /**
     * Applies the {@link it.unibo.pyxis.controller.soundplayer.Sound}s and calls the
     * {@link PauseSceneController#menu()}.
     */
    public void menu() {
        this.playMainMenuMusic();
        this.playGenericButtonPressSound();
        this.getController().menu();
    }
    /**
     * Applies the {@link it.unibo.pyxis.controller.soundplayer.Sound} and calls the
     * {@link PauseSceneController#quit()}.
     */
    public void quit() {
        this.playGenericButtonPressSound();
        this.getController().quit();
    }
    /**
     * Applies the {@link it.unibo.pyxis.controller.soundplayer.Sound} and calls the
     * {@link PauseSceneController#resume()}.
     */
    public void resume() {
        this.playStartGameButtonPressSound();
        this.getController().resume();
    }
    /**
     * Applies the {@link it.unibo.pyxis.controller.soundplayer.Sound} and calls the
     * {@link PauseSceneController#settings()}.
     */
    public void settings() {
        this.playGenericButtonPressSound();
        this.getController().settings();
    }
}
