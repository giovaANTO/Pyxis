package it.unibo.pyxis.view;

import java.net.URL;
import java.util.ResourceBundle;
import it.unibo.pyxis.controller.EndLevelController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public final class EndLevelView extends AbstractJavaFXView<EndLevelController> {

    @FXML
    private StackPane mainPane;
    @FXML
    private VBox vBox;
    @FXML
    private Label endLevelLabel, levelScore, totalScore;
    @FXML
    private Button nextLevelButton;
    private static final String WIN_TEXT = "You successfully completed this level.";
    private static final String LOOSE_TEXT = "You've been defeated.";
    private static final String TOTAL_SCORE_TEXT = "Total score: ";
    private static final String LEVEL_SCORE_TEXT = "Level score: ";

    public EndLevelView(final EndLevelController inputController) {
        super(inputController);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        this.vBox.prefWidthProperty().bind(this.mainPane.prefWidthProperty());
        this.vBox.prefHeightProperty().bind(this.mainPane.prefHeightProperty());
        if (this.getController().haveWon()) {
            this.endLevelLabel.setText(WIN_TEXT);
        } else {
            this.endLevelLabel.setText(LOOSE_TEXT);
        }
        this.totalScore.setText(TOTAL_SCORE_TEXT
                + this.getController().getTotalScore().toString());
        this.levelScore.setText(LEVEL_SCORE_TEXT
                + this.getController().getLevelScore().toString());
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
