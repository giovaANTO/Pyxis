package it.unibo.pyxis.view;

import it.unibo.pyxis.controller.GameController;
import it.unibo.pyxis.view.drawer.Drawer;
import it.unibo.pyxis.view.drawer.DrawerImpl;
import it.unibo.pyxis.view.drawer.binder.Binder;
import it.unibo.pyxis.view.drawer.binder.CanvasRatioBinder;
import it.unibo.pyxis.view.drawer.binder.LabelSizeBinder;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class GameSceneView extends AbstractJavaFXView<GameController> implements RenderableView {

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

    private Drawer drawer;
    private Binder canvasBinder;
    private Set<LabelSizeBinder> labelBinders;

    public GameSceneView(final GameController inputController) {
        super(inputController);
    }

    /**
     * Draws all the {@link it.unibo.pyxis.model.element.Element}s of the
     * {@link it.unibo.pyxis.model.arena.Arena} in the {@link javafx.scene.canvas.Canvas}.
     */
    private void drawCanvas() {
        this.drawer.clear();
        this.drawer.drawBackground(this.getController().getLevelImage());
        this.getController().getBricks().forEach(this.drawer::draw);
        this.getController().getBalls().forEach(this.drawer::draw);
        this.getController().getPowerups().forEach(this.drawer::draw);
        this.drawer.draw(this.getController().getPad());
    }
    /**
     * Sets up the {@link it.unibo.pyxis.view.drawer.binder.Binder}s for the
     * {@link javafx.scene.canvas.Canvas} and the {@link javafx.scene.control.Label}s.
     */
    private void setupBinders() {
        this.canvasBinder = new CanvasRatioBinder(mainPane, arenaCanvas);
        this.labelBinders = Stream.concat(leftVBox.getChildren().stream(), rightVBox.getChildren().stream())
                .filter(n -> n instanceof Label)
                .map(n -> new LabelSizeBinder(mainPane, (Label) n))
                .collect(Collectors.toSet());
    }
    /**
     * Updates the {@link it.unibo.pyxis.view.drawer.binder.Binder}s.
     */
    private void updateBindNodesToContainer() {
        this.labelBinders.forEach(LabelSizeBinder::bind);
        this.canvasBinder.bind();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        stackPane.prefWidthProperty().bind(mainPane.widthProperty());
        stackPane.prefHeightProperty().bind(mainPane.heightProperty());
        leftVBox.prefWidthProperty().bind(mainPane.widthProperty().multiply(leftVBox.getPrefWidth() / mainPane.getPrefWidth()));
        leftVBox.prefHeightProperty().bind(mainPane.heightProperty());
        rightVBox.prefWidthProperty().bind(mainPane.widthProperty().multiply(rightVBox.getPrefWidth() / mainPane.getPrefWidth()));
        rightVBox.prefHeightProperty().bind(mainPane.heightProperty());
        this.drawer = new DrawerImpl(arenaCanvas.getGraphicsContext2D(), this.getController().getArenaDimension());
        this.currentLevel.setText(this.getController().getCurrentLevelNumber().toString());
        this.setupBinders();
        this.playInGameMusic();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void render() {
        this.updateBindNodesToContainer();
        this.currentLives.setText(this.getController().getLives().toString());
        this.currentScore.setText(this.getController().getScore().toString());
        this.drawCanvas();
    }
}
