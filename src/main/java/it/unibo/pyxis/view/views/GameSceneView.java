package it.unibo.pyxis.view.views;

import it.unibo.pyxis.controller.controllers.GameSceneController;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.paint.Color.*;

public final class GameSceneView extends AbstractJavaFXView<GameSceneController> implements RenderableView {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private AnchorPane gamePane;

    @FXML
    private Canvas canvas;

    @FXML
    private Label livesText, currentLives, scoreText, currentScore, levelText, currentLevel;

    public GameSceneView(final GameSceneController inputController) {
        super(inputController);
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        System.out.println(this.getController());
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(BLACK);
        gc.fillRect(50, 50, 100, 100);
    }

    @Override
    public void render() {
        // Render something in sync with the gameloop
    }
}
