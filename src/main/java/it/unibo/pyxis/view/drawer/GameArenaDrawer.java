package it.unibo.pyxis.view.drawer;

import java.io.File;

import it.unibo.pyxis.model.element.ball.BallType;
import it.unibo.pyxis.model.element.brick.BrickType;
import it.unibo.pyxis.model.element.pad.Pad;
import it.unibo.pyxis.model.element.powerup.PowerupType;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.CoordImpl;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.DimensionImpl;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

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
        final ImageView imageView = new ImageView(new Image(ClassLoader.getSystemResourceAsStream(SPRITES_PATH + type.getTypeString() + BRICK_END_PATH)));

        this.setupImageView(imageView, modelToViewPositionScale(position, dimension), modelToViewDimensionScale(dimension));

        this.arenaPane.getChildren().add(imageView);
    }

    public final void fillBall(final Coord position, final Dimension dimension, final BallType type) {
        final ImageView imageView = new ImageView(new Image(ClassLoader.getSystemResourceAsStream(SPRITES_PATH + type.getType() + BALL_END_PATH)));

        this.setupImageView(imageView, modelToViewPositionScale(position, dimension), modelToViewDimensionScale(dimension));

        arenaPane.getChildren().add(imageView);
    }

    public final void fillPowerup(final Coord position, final Dimension dimension, final PowerupType type) {
//        final ImageView imageView = new ImageView(new Image(ClassLoader.getSystemResourceAsStream(SPRITES_PATH + type.getTypeString() + BALL_END_PATH)));
//
//        this.setupImageView(imageView, modelToViewPositionScale(position, dimension), modelToViewDimensionScale(dimension));
//
//        arenaPane.getChildren().add(imageView);
    }

    public final void fillPad(final Pad pad) {
        final Coord scaledPosition = modelToViewPositionScale(pad.getPosition(), pad.getDimension());
        final Dimension scaledDimension = modelToViewDimensionScale(pad.getDimension());
    }

    /**
     * Assigns to the {@link ImageView} the scaled position and dimension relative to the dimension of the Arena.
     * @param imageView
     * @param scaledPosition
     * @param scaledDimension
     */
    private void setupImageView(final ImageView imageView, final Coord scaledPosition, final Dimension scaledDimension) {
        imageView.setX(scaledPosition.getX());
        imageView.setY(scaledPosition.getY());
        imageView.setFitWidth(scaledDimension.getWidth());
        imageView.setFitHeight(scaledDimension.getHeight());
    }

    /**
     * Converts the {@link Coord} of an {@link Element} of the model to the relative {@link Coord} of the View.
     * @param position
     * @param dimension
     * @return
     *          the converted {@link Coord} of an {@link Element} of the model to the relative {@link Coord} of the View.
     */
    private Coord modelToViewPositionScale(final Coord position, final Dimension dimension) {
        return new CoordImpl((position.getX() - dimension.getWidth() / 2) * this.xCanvasScaleFactor,
                             (position.getY() - dimension.getHeight() / 2) * this.yCanvasScaleFactor);
    }

    /**
     * Converts the {@link Dimension} of an {@link Element} of the model to the relative {@link Dimension} of the View.
     * @param dimension
     * @return
     *          the converted {@link Dimension} of an {@link Element} of the model to the relative {@link Dimension} of the View.
     */
    private Dimension modelToViewDimensionScale(final Dimension dimension) {
        return new DimensionImpl(dimension.getWidth() * this.xCanvasScaleFactor, dimension.getHeight() * this.yCanvasScaleFactor);
    }

}
