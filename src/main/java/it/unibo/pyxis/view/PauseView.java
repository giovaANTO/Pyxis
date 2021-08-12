package it.unibo.pyxis.view;

import it.unibo.pyxis.controller.PauseController;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public final class PauseView extends AbstractJavaFXView<PauseController> {

    @FXML
    private StackPane mainPane;
    @FXML
    private VBox vBox;

    public PauseView(final PauseController inputController) {
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
     * Applies the {@link it.unibo.pyxis.view.soundplayer.Sound}s and calls the
     * {@link PauseController#menu()}.
     */
    public void menu() {
        this.playGenericButtonPressSound();
        this.getController().menu();
    }
    /**
     * Applies the {@link it.unibo.pyxis.view.soundplayer.Sound} and calls the
     * {@link PauseController#quit()}.
     */
    public void quit() {
        this.playGenericButtonPressSound();
        this.getController().quit();
    }
    /**
     * Applies the {@link it.unibo.pyxis.view.soundplayer.Sound} and calls the
     * {@link PauseController#resume()}.
     */
    public void resume() {
        this.playStartGameButtonPressSound();
        this.getController().resume();
    }
    /**
     * Applies the {@link it.unibo.pyxis.view.soundplayer.Sound} and calls the
     * {@link PauseController#settings()}.
     */
    public void settings() {
        this.playGenericButtonPressSound();
        this.getController().settings();
    }
}
