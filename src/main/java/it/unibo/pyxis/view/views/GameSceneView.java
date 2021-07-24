package it.unibo.pyxis.view.views;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class GameSceneView extends AbstractView {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private AnchorPane gamePane;

    @FXML
    private Canvas canvas;

    @FXML
    private Label livesText, currentLives, scoreText, currentScore, levelText, currentLevel;

    @Override
    public final void init() {
    }


}
