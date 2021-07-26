package it.unibo.pyxis.view.views;

import it.unibo.pyxis.controller.controllers.GameSceneController;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;
import it.unibo.pyxis.view.drawer.GameCanvasDrawer;

public final class GameSceneView extends AbstractJavaFXView<GameSceneController> implements RenderableView {

    @FXML
    private Canvas canvas;

    @FXML
    private Label currentLives, currentScore, currentLevel;

    private GameCanvasDrawer drawer;

    public GameSceneView(final GameSceneController inputController) {
        super(inputController);
    }

    public void initialize(final URL location, final ResourceBundle resources) {
        final GameSceneController controller = this.getController();
        this.drawer = new GameCanvasDrawer(this.canvas.getGraphicsContext2D(),
                    this.canvas.getWidth() / controller.getArenaWidth(),
                    this.canvas.getHeight() / controller.getArenaHeight());
    }

    @Override
    public void render() {
        final GameSceneController controller = this.getController();

        this.currentLives.setText(controller.getLives().toString());
        this.currentScore.setText(controller.getScore().toString());
        controller.getBricks().forEach(b -> this.drawer.fillBrick(b.getPosition(), b.getDimension(), b.getBrickType()));
        controller.getBalls().forEach(b -> this.drawer.fillBall(b.getPosition(), b.getDimension(), b.getType()));
        this.drawer.fillPad(controller.getPad());
    }


}
