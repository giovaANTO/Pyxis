package it.unibo.pyxis.view.views;

import it.unibo.pyxis.controller.controllers.GameSceneController;
import it.unibo.pyxis.controller.linker.Linker;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import it.unibo.pyxis.view.drawer.CanvasRatioBinder;
import it.unibo.pyxis.view.drawer.ArenaCanvasDrawer;
import it.unibo.pyxis.view.drawer.LabelSizeBinder;

public final class GameSceneView extends AbstractJavaFXView<GameSceneController> implements RenderableView {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private StackPane stackPane;

    @FXML
    private Canvas arenaCanvas;

    @FXML
    private VBox leftVBox, rightVBox;

    @FXML
    private Label currentLives, currentScore, currentLevel;

    private ArenaCanvasDrawer drawer;
    private CanvasRatioBinder canvasBinder;
    private Set<LabelSizeBinder> labelBinders;

    public GameSceneView(final GameSceneController inputController) {
        super(inputController);
    }

    public void initialize(final URL location, final ResourceBundle resources) {
        stackPane.prefWidthProperty().bind(mainPane.widthProperty());
        stackPane.prefHeightProperty().bind(mainPane.heightProperty());
        leftVBox.prefWidthProperty().bind(mainPane.widthProperty().multiply(leftVBox.getPrefWidth() / mainPane.getPrefWidth()));
        leftVBox.prefHeightProperty().bind(mainPane.heightProperty());
        rightVBox.prefWidthProperty().bind(mainPane.widthProperty().multiply(rightVBox.getPrefWidth() / mainPane.getPrefWidth()));
        rightVBox.prefHeightProperty().bind(mainPane.heightProperty());
        this.drawer = new ArenaCanvasDrawer(arenaCanvas.getGraphicsContext2D(), this.getController().getArenaDimension());
        this.setupBinders();

        final Linker linker = this.getController().getLinker();
        final EventHandler<KeyEvent> keyEventEventHandler = keyEvent -> {
            switch (keyEvent.getCode()) {
                case A:
                    linker.insertCommand(level -> level.getArena().movePadLeft());
                    break;
                case D:
                    linker.insertCommand(level -> level.getArena().movePadRigth());
                    break;
                case ESCAPE:
                    System.out.println("ESC");
                    break;
                default:
                    break;
            }
        };
        this.mainPane.addEventHandler(KeyEvent.KEY_PRESSED, keyEventEventHandler);
    }

    private void setupBinders() {
        this.canvasBinder = new CanvasRatioBinder(mainPane.widthProperty(), mainPane.heightProperty(),
                mainPane.getPrefWidth(), mainPane.getPrefHeight(),
                arenaCanvas.widthProperty(), arenaCanvas.heightProperty(),
                arenaCanvas.getWidth(), arenaCanvas.getHeight());
        this.labelBinders = Stream.concat(leftVBox.getChildren().stream(), rightVBox.getChildren().stream())
                                .filter(n -> n instanceof Label)
                                .map(n -> new LabelSizeBinder(mainPane.widthProperty(), mainPane.heightProperty(),
                                            mainPane.getPrefWidth(), mainPane.getPrefHeight(),
                                            (Label) n))
                                .collect(Collectors.toSet());
    }

    @Override
    public void render() {
        this.updateBindNodesToContainer();
        this.currentLives.setText(this.getController().getLives().toString());
        this.currentScore.setText(this.getController().getScore().toString());
        this.drawCanvas();
    }

    private void updateBindNodesToContainer() {
        this.labelBinders.forEach(b -> b.bindWithSize());
        this.canvasBinder.bindWithRatioToContainer();
    }

    private void drawCanvas() {
        this.drawer.clearCanvas();
        this.getController().getBricks().forEach(b -> this.drawer.fillBrick(b.getPosition(), b.getDimension(), b.getBrickType()));
        this.getController().getBalls().forEach(b -> this.drawer.fillBall(b.getPosition(), b.getDimension(), b.getType()));
        this.getController().getPowerups().forEach(p -> this.drawer.fillPowerup(p.getPosition(), p.getDimension(), p.getType()));
        this.drawer.fillPad(this.getController().getPad());
    }

}
