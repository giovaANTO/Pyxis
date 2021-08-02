package it.unibo.pyxis.view.drawer;

import java.io.File;
import java.util.Objects;

import it.unibo.pyxis.model.element.ball.BallType;
import it.unibo.pyxis.model.element.brick.BrickType;
import it.unibo.pyxis.model.element.pad.Pad;
import it.unibo.pyxis.model.element.powerup.PowerupType;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.CoordImpl;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.DimensionImpl;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class ArenaCanvasDrawer {

    private static final String SEPARATOR = File.separator;
    private static final String SPRITES_PATH = "sprites" + SEPARATOR;
    private static final String BACKGROUNDS_PATH = "backgrounds" + SEPARATOR;
    private static final String BACKGROUND_END_PATH = "BACKGROUND.png";
    private static final String BRICK_END_PATH = "BRICK.png";
    private static final String BALL_END_PATH = "BALL.png";
    private static final String POWERUP_END_PATH = "POWERUP.png";
    private static final String PAD_END_PATH = "PAD.png";

    private final GraphicsContext gc;
    private final Dimension arenaDimension;

    public ArenaCanvasDrawer(final GraphicsContext gc, final Dimension arenaDimension) {
        this.gc = gc;
        this.arenaDimension = arenaDimension;
    }

    public final void clearCanvas() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }

    public final void fillBrick(final Coord position, final Dimension dimension, final BrickType type) {
        this.fillSpriteImage(position, dimension, type.getTypeString() + BRICK_END_PATH);
    }

    public final void fillBall(final Coord position, final Dimension dimension, final BallType type) {
        this.fillSpriteImage(position, dimension, type.getType() + BALL_END_PATH);
    }

    public final void fillPowerup(final Coord position, final Dimension dimension, final PowerupType type) {
        this.fillSpriteImage(position, dimension, /*type.toString() +*/ POWERUP_END_PATH);
    }

    public final void fillPad(final Pad pad) {
        this.fillSpriteImage(pad.getPosition(), pad.getDimension(), PAD_END_PATH);
    }

    public final void fillBackground(final int levelNumber) {
        this.fillImage(new CoordImpl(this.arenaDimension.getWidth() / 2, this.arenaDimension.getHeight() / 2),
                this.arenaDimension, BACKGROUNDS_PATH + levelNumber + BACKGROUND_END_PATH);
    }

    private void fillSpriteImage(final Coord position, final Dimension dimension, final String endPath) {
        this.fillImage(position, dimension, SPRITES_PATH + endPath);
    }

    private void fillImage(final Coord position, final Dimension dimension, final String path) {
        this.drawImage(loadImage(path), modelToViewPositionScale(position, dimension), modelToViewDimensionScale(dimension));
    }

    /**
     * Draws the accordingly scaled {@link Image} into the {@link Canvas}.
     * @param image
     * @param scaledPosition
     * @param scaledDimension
     */
    private void drawImage(final Image image, final Coord scaledPosition, final Dimension scaledDimension) {
        gc.drawImage(image, scaledPosition.getX(), scaledPosition.getY(), scaledDimension.getWidth(), scaledDimension.getHeight());
    }

    /**
     * Converts the {@link Coord} of an {@link Element} of the model to the relative {@link Coord} of the View.
     * @param position
     * @param dimension
     * @return
     *          the converted {@link Coord} of an {@link Element} of the model to the relative {@link Coord} of the View.
     */
    private Coord modelToViewPositionScale(final Coord position, final Dimension dimension) {
        return new CoordImpl((position.getX() - dimension.getWidth() / 2) * this.gc.getCanvas().getWidth() / this.arenaDimension.getWidth(),
                (position.getY() - dimension.getHeight() / 2) * this.gc.getCanvas().getHeight() / this.arenaDimension.getHeight());
    }

    /**
     * Converts the {@link Dimension} of an {@link Element} of the model to the relative {@link Dimension} of the View.
     * @param dimension
     * @return
     *          the converted {@link Dimension} of an {@link Element} of the model to the relative {@link Dimension} of the View.
     */
    private Dimension modelToViewDimensionScale(final Dimension dimension) {
        return new DimensionImpl(dimension.getWidth() * this.gc.getCanvas().getWidth() / this.arenaDimension.getWidth(),
                                    dimension.getHeight() * this.gc.getCanvas().getHeight() / this.arenaDimension.getHeight());
    }

    /**
     * Returns the {@link Image} for the requested sprite path.
     * @param endPath
     * @return
     *          the {@link Image} for the requested sprite path.
     */
    private Image loadImage(final String path) {
        return new Image(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream(path)));
    }

}
