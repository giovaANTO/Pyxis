package it.unibo.pyxis.view.views;

import java.net.URL;
import java.util.ResourceBundle;
import it.unibo.pyxis.controller.controllers.EndLevelSceneController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public final class EndLevelSceneView extends AbstractJavaFXView<EndLevelSceneController> {

    @FXML
    private StackPane mainPane;
    @FXML
    private VBox vBox;
    @FXML
    private Label score;
    @FXML
    private Button nextLevelButton;

    public EndLevelSceneView(final EndLevelSceneController inputController) {
        super(inputController);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        this.vBox.prefWidthProperty().bind(this.mainPane.prefWidthProperty());
        this.vBox.prefHeightProperty().bind(this.mainPane.prefHeightProperty());
        this.score.setText(this.getController().getScore().toString());
        this.nextLevelButton.setDisable(this.getController().disableNextLevelButton());
    }
    /**
     * Applies all the {@link it.unibo.pyxis.controller.soundplayer.Sound}s and call
     * {@link EndLevelSceneController#menu()}.
     */
    public void menu() {
        this.playMainMenuMusic();
        this.playGenericButtonPressSound();
        this.getController().menu();
    }
    /**
     * Applies all the {@link it.unibo.pyxis.controller.soundplayer.Sound}s and call
     * {@link EndLevelSceneController#nextLevel()}.
     */
    public void nextLevel() {
        this.playStartGameButtonPressSound();
        this.getController().nextLevel();
    }
}
