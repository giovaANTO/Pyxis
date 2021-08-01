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

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;

import it.unibo.pyxis.view.drawer.NodePropertyToContainerBinder;
import it.unibo.pyxis.view.drawer.ArenaCanvasDrawer;
import it.unibo.pyxis.view.drawer.LabelPropertyToContainerBinder;

public final class GameSceneView extends AbstractJavaFXView<GameSceneController> implements RenderableView {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private StackPane stackPane;

    @FXML
    private Canvas arenaCanvas;

    @FXML
    private Label currentLives, currentScore, currentLevel;

    private ArenaCanvasDrawer drawer;
    private NodePropertyToContainerBinder canvasToMainPaneBinder;
    private Set<LabelPropertyToContainerBinder> labelsToMainPaneBinders;

    public GameSceneView(final GameSceneController inputController) {
        super(inputController);
    }

    public void initialize(final URL location, final ResourceBundle resources) {
        stackPane.prefHeightProperty().bind(mainPane.heightProperty());
        stackPane.prefWidthProperty().bind(mainPane.widthProperty());
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
        this.canvasToMainPaneBinder = new NodePropertyToContainerBinder(mainPane.widthProperty(), mainPane.heightProperty(),
                mainPane.getPrefWidth(), mainPane.getPrefHeight(),
                arenaCanvas.widthProperty(), arenaCanvas.heightProperty(),
                arenaCanvas.getWidth(), arenaCanvas.getHeight());
        this.labelsToMainPaneBinders = this.mainPane.getChildren()
                                .stream()
                                .filter(n -> n instanceof Label)
                                .map(n -> {
                                    final Label l = (Label) n;
                                    return new LabelPropertyToContainerBinder(mainPane.widthProperty(), mainPane.heightProperty(),
                                            mainPane.getPrefWidth(), mainPane.getPrefHeight(),
                                            l);
                                })
                                .collect(Collectors.toSet());
    }

    public void back() {
        this.getController().back();
    }

    public void update() {
        this.getController().getLinker().getGameState().getCurrentLevel().update(500.0);
    }

    public void dofortenX() {
        this.update();
        this.update();
        this.update();
        this.update();
        this.update();
        this.update();
        this.update();
        this.update();
        this.update();
        this.update();
    }

    @Override
    public void render() {
        this.bindNodesToContainer();
        this.currentLives.setText(this.getController().getLives().toString());
        this.currentScore.setText(this.getController().getScore().toString());
        this.drawCanvas();
    }

    private void bindNodesToContainer() {
        this.labelsToMainPaneBinders.forEach(b -> b.bindWithRatioToContainer());
        this.canvasToMainPaneBinder.bindWithRatioToContainer();
    }

    private void drawCanvas() {
        this.drawer.clearCanvas();
        this.getController().getBricks().forEach(b -> this.drawer.fillBrick(b.getPosition(), b.getDimension(), b.getBrickType()));
        this.getController().getBalls().forEach(b -> this.drawer.fillBall(b.getPosition(), b.getDimension(), b.getType()));
        this.getController().getPowerups().forEach(p -> this.drawer.fillPowerup(p.getPosition(), p.getDimension(), p.getType()));
        this.drawer.fillPad(this.getController().getPad());
    }

}
