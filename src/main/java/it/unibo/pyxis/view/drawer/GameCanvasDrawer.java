package it.unibo.pyxis.view.drawer;

import it.unibo.pyxis.model.element.ball.BallType;
import it.unibo.pyxis.model.element.brick.BrickType;
import it.unibo.pyxis.model.element.pad.Pad;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.CoordImpl;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.DimensionImpl;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameCanvasDrawer {

    private final GraphicsContext gc;
    private final double xCanvasScaleFactor;
    private final double yCanvasScaleFactor;

    public GameCanvasDrawer(final GraphicsContext gc, final double xCanvasScaleFactor, final double yCanvasScaleFactor) {
        this.gc = gc;
        this.xCanvasScaleFactor = xCanvasScaleFactor;
        this.yCanvasScaleFactor = yCanvasScaleFactor;
    }

    public void fillBrick(final Coord position, final Dimension dimension, final BrickType type) {
        final Coord scaledPosition = modelToViewPositionScale(position, dimension);
        final Dimension scaledDimension = modelToViewDimensionScale(dimension);

        gc.setFill(Color.valueOf(type.getTypeString()));
        gc.fillRect(scaledPosition.getX(), scaledPosition.getY(), scaledDimension.getWidth(), scaledDimension.getHeight());
    }

    public void fillBall(final Coord position, final Dimension dimension, final BallType type) {
        final Coord scaledPosition = modelToViewPositionScale(position, dimension);
        final Dimension scaledDimension = modelToViewDimensionScale(dimension);

        gc.setFill(Color.AQUA);
        gc.fillOval(scaledPosition.getX(), scaledPosition.getY(), scaledDimension.getWidth(), scaledDimension.getHeight());
    }

    public void fillPad(final Pad pad) {
        final Coord scaledPosition = modelToViewPositionScale(pad.getPosition(), pad.getDimension());
        final Dimension scaledDimension = modelToViewDimensionScale(pad.getDimension());

        gc.setFill(Color.BLACK);
        gc.fillRect(scaledPosition.getX(), scaledPosition.getY(), scaledDimension.getWidth(), scaledDimension.getHeight());
    }

    private Coord modelToViewPositionScale(final Coord position, final Dimension dimension) {
        return new CoordImpl((position.getX() - dimension.getWidth() / 2) * xCanvasScaleFactor,
                             (position.getY() - dimension.getHeight() / 2) * yCanvasScaleFactor);
    }

    private Dimension modelToViewDimensionScale(final Dimension dimension) {
        return new DimensionImpl(dimension.getWidth() * xCanvasScaleFactor, dimension.getHeight() * yCanvasScaleFactor);
    }

}
