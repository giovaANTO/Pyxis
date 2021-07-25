package it.unibo.pyxis.view.views;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

import it.unibo.pyxis.controller.controllers.GameSceneController;
import it.unibo.pyxis.view.drawer.GameCanvasDrawer;


public class GameSceneView extends AbstractJavaFXView {

    @FXML
    private Canvas canvas;

    @FXML
    private Label currentLives, currentScore, currentLevel;

    private GameCanvasDrawer drawer;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {

    }

    public void initBottone() {
        final GameSceneController controller = (GameSceneController) this.getController();
        drawer = new GameCanvasDrawer(this.canvas.getGraphicsContext2D(),
                this.canvas.getWidth() / controller.getArenaWidth(),
                this.canvas.getHeight() / controller.getArenaHeight());
        render();
    }

    public void render() {
        final GameSceneController controller = (GameSceneController) this.getController();

        controller.getBricks().stream().forEach(b -> drawer.fillBrick(b.getPosition(), b.getDimension(), b.getBrickType()));
        controller.getBalls().stream().forEach(b -> drawer.fillBall(b.getPosition(), b.getDimension(), b.getType()));
        drawer.fillPad(controller.getPad());
    }

}
