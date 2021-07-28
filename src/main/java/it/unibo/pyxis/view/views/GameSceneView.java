package it.unibo.pyxis.view.views;

import it.unibo.pyxis.controller.controllers.GameSceneController;
import javafx.beans.binding.Bindings;
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
                arenaCanvas.widthProperty(), arenaCanvas.heightProperty(),
                arenaCanvas.getWidth(), arenaCanvas.getHeight());
    }

    public void back() {
        this.getController().back();
    }

    public void update() {
        this.getController().getLinker().getGameState().getCurrentLevel().update(500.0);
    }

    @Override
    public void render() {
        canvasToMainPaneBinder.bindWithRatioToContainer();
        this.currentLives.setText(this.getController().getLives().toString());
        this.currentScore.setText(this.getController().getScore().toString());
        this.drawer.clearCanvas();
        this.getController().getBricks().forEach(b -> this.drawer.fillBrick(b.getPosition(), b.getDimension(), b.getBrickType()));
        this.getController().getBalls().forEach(b -> this.drawer.fillBall(b.getPosition(), b.getDimension(), b.getType()));
        this.getController().getPowerups().forEach(p -> this.drawer.fillPowerup(p.getPosition(), p.getDimension(), p.getType()));
        this.drawer.fillPad(this.getController().getPad());
    }

}
