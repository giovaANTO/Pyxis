package it.unibo.pyxis.view;

import java.net.URL;
import java.util.ResourceBundle;
import it.unibo.pyxis.controller.EndLevelController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public final class EndLevelSceneView extends AbstractJavaFXView<EndLevelController> {

    @FXML
    private StackPane mainPane;
    @FXML
    private VBox vBox;
    @FXML
    private Label score;
    @FXML
    private Button nextLevelButton;

    public EndLevelSceneView(final EndLevelController inputController) {
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
     * Applies all the {@link it.unibo.pyxis.view.soundplayer.Sound}s and call
     * {@link EndLevelController#menu()}.
     */
    public void menu() {
        this.playGenericButtonPressSound();
        this.getController().menu();
    }
    /**
     * Applies all the {@link it.unibo.pyxis.view.soundplayer.Sound}s and call
     * {@link EndLevelController#nextLevel()}.
     */
    public void nextLevel() {
        this.playStartGameButtonPressSound();
        this.getController().nextLevel();
    }
}
