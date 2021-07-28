package it.unibo.pyxis.view.views;

import it.unibo.pyxis.controller.controllers.GameSceneController;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

import it.unibo.pyxis.view.drawer.CanvasPropertyBinder;
import it.unibo.pyxis.view.drawer.GameArenaDrawer;

public final class GameSceneView extends AbstractJavaFXView<GameSceneController> implements RenderableView {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private StackPane stackPane;

    @FXML
    private Canvas arenaCanvas;

    @FXML
    private Label currentLives, currentScore, currentLevel;

    private GameArenaDrawer drawer;
    private CanvasPropertyBinder canvasToMainPaneBinder;

    public GameSceneView(final GameSceneController inputController) {
        super(inputController);
    }

    public void initialize(final URL location, final ResourceBundle resources) {
        stackPane.prefHeightProperty().bind(mainPane.heightProperty());
        stackPane.prefWidthProperty().bind(mainPane.widthProperty());
        this.drawer = new GameArenaDrawer(arenaCanvas.getGraphicsContext2D(), this.getController().getArenaDimension());
        this.canvasToMainPaneBinder = new CanvasPropertyBinder(mainPane.widthProperty(), mainPane.heightProperty(),
                mainPane.getPrefWidth(), mainPane.getPrefHeight(),
                arenaCanvas.getWidth(), arenaCanvas.getHeight());
    }

    public void back() {
        this.getController().back();
    }

    @Override
    public void render() {
        this.currentLives.setText(this.getController().getLives().toString());
        this.currentScore.setText(this.getController().getScore().toString());
        this.renderCanvas();
    }

    private void renderCanvas() {
        final Canvas tempCanvas = new Canvas(arenaCanvas.getWidth(), arenaCanvas.getHeight());

        canvasToMainPaneBinder.bindWithRatioToContainer(tempCanvas.widthProperty(), tempCanvas.heightProperty());
        this.drawCanvas(tempCanvas);
        this.showCanvas(tempCanvas);
    }

    private void drawCanvas(final Canvas canvas) {
        this.drawer.setGc(canvas.getGraphicsContext2D());
        this.getController().getBricks().forEach(b -> this.drawer.fillBrick(b.getPosition(), b.getDimension(), b.getBrickType()));
        this.getController().getBalls().forEach(b -> this.drawer.fillBall(b.getPosition(), b.getDimension(), b.getType()));
        this.getController().getPowerups().forEach(p -> this.drawer.fillPowerup(p.getPosition(), p.getDimension(), p.getType()));
        this.drawer.fillPad(this.getController().getPad());
    }

    private void showCanvas(final Canvas newArenaCanvas) {
        stackPane.getChildren().removeAll(arenaCanvas);
        arenaCanvas = newArenaCanvas;
        stackPane.getChildren().add(arenaCanvas);
        StackPane.setAlignment(arenaCanvas, Pos.CENTER);
    }
}
