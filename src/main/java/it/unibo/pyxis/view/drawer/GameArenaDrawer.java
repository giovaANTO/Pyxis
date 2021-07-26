package it.unibo.pyxis.view.drawer;

import java.io.File;

import it.unibo.pyxis.model.element.ball.BallType;
import it.unibo.pyxis.model.element.brick.BrickType;
import it.unibo.pyxis.model.element.pad.Pad;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.CoordImpl;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.DimensionImpl;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class GameArenaDrawer {

    private static final String SEPARATOR = File.separator;
    private static final String SPRITES_PATH = "sprites" + SEPARATOR;
    private static final String BRICK_END_PATH = "BRICK.png";
    private static final String BALL_END_PATH = "BALL.png";

    private final AnchorPane arenaPane;
    private final double xCanvasScaleFactor;
    private final double yCanvasScaleFactor;

    public GameArenaDrawer(final AnchorPane arenaPane, final double xCanvasScaleFactor, final double yCanvasScaleFactor) {
        this.arenaPane = arenaPane;
        this.xCanvasScaleFactor = xCanvasScaleFactor;
        this.yCanvasScaleFactor = yCanvasScaleFactor;
    }

    public final void fillBrick(final Coord position, final Dimension dimension, final BrickType type) {
        final Coord scaledPosition = modelToViewPositionScale(position, dimension);
        final Dimension scaledDimension = modelToViewDimensionScale(dimension);

        final ImageView imageView = new ImageView(new Image(ClassLoader.getSystemResourceAsStream(SPRITES_PATH + type.getTypeString() + BRICK_END_PATH)));
        imageView.setX(scaledPosition.getX());
        imageView.setY(scaledPosition.getY());
        imageView.setFitWidth(scaledDimension.getWidth());
        imageView.setFitHeight(scaledDimension.getHeight());
        arenaPane.getChildren().add(imageView);
    }

    public final void fillBall(final Coord position, final Dimension dimension, final BallType type) {
        final Coord scaledPosition = modelToViewPositionScale(position, dimension);
        final Dimension scaledDimension = modelToViewDimensionScale(dimension);

        final ImageView imageView = new ImageView(new Image(ClassLoader.getSystemResourceAsStream(SPRITES_PATH + type.getType() + BALL_END_PATH)));
        imageView.setX(scaledPosition.getX());
        imageView.setY(scaledPosition.getY());
        imageView.setFitWidth(scaledDimension.getWidth());
        imageView.setFitHeight(scaledDimension.getHeight());
        arenaPane.getChildren().add(imageView);
    }

    public final void fillPad(final Pad pad) {
        final Coord scaledPosition = modelToViewPositionScale(pad.getPosition(), pad.getDimension());
        final Dimension scaledDimension = modelToViewDimensionScale(pad.getDimension());
    }

    private Coord modelToViewPositionScale(final Coord position, final Dimension dimension) {
        return new CoordImpl((position.getX() - dimension.getWidth() / 2) * this.xCanvasScaleFactor,
                             (position.getY() - dimension.getHeight() / 2) * this.yCanvasScaleFactor);
    }

    private Dimension modelToViewDimensionScale(final Dimension dimension) {
        return new DimensionImpl(dimension.getWidth() * this.xCanvasScaleFactor, dimension.getHeight() * this.yCanvasScaleFactor);
    }

}
