package it.unibo.pyxis.view.drawer;

import it.unibo.pyxis.ecs.component.sprite.SpriteComponent;
import it.unibo.pyxis.model.element.Element;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.CoordImpl;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.DimensionImpl;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public final class DrawerImpl implements Drawer {

    private final GraphicsContext gc;
    private final Dimension arenaDimension;

    public DrawerImpl(final GraphicsContext gc, final Dimension arenaDimension) {
        this.gc = gc;
        this.arenaDimension = arenaDimension;
    }
    /**
     *
     * @param spriteImage
     * @param position
     * @param dimension
     */
    private void drawImg(final Image spriteImage, final Coord position, final Dimension dimension) {
        final Coord scalePos = this.modelToViewPositionScale(position, dimension);
        final Dimension scaleDim = this.modelToViewDimensionScale(dimension);
        gc.drawImage(spriteImage, scalePos.getX(), scalePos.getY(), scaleDim.getWidth(), scaleDim.getHeight());
    }
    /**
     * Converts the {@link Coord} of an {@link it.unibo.pyxis.model.element.Element}
     * of the model to the relative {@link Coord} of the View.
     *
     * @param position The {@link Coord} of the
     *                 {@link it.unibo.pyxis.model.element.Element} to draw.
     * @param dimension The {@link Dimension} of the
     *                 {@link it.unibo.pyxis.model.element.Element} to draw.
     * @return The converted {@link Coord} of an
     *         {@link it.unibo.pyxis.model.element.Element} of the model to the
     *         relative {@link Coord} of the View.
     */
    private Coord modelToViewPositionScale(final Coord position, final Dimension dimension) {
        final double widthProportion = this.gc.getCanvas().getWidth() / this.arenaDimension.getWidth();
        final double heightProportion = this.gc.getCanvas().getHeight() / this.arenaDimension.getHeight();
        final double scaledX = (position.getX() - dimension.getWidth() / 2) * widthProportion;
        final double scaledY = (position.getY() - dimension.getHeight() / 2) * heightProportion;
        return new CoordImpl(scaledX, scaledY);
    }
    /**
     * Converts the {@link Dimension} of an
     * {@link it.unibo.pyxis.model.element.Element} of the model to the relative
     * {@link Dimension} of the View.
     *
     * @param dimension The {@link Dimension} of the
     *                  {@link it.unibo.pyxis.model.element.Element} to draw.
     * @return The converted {@link Dimension} of an
     *         {@link it.unibo.pyxis.model.element.Element} of the model to the
     *         relative {@link Dimension} of the View.
     */
    private Dimension modelToViewDimensionScale(final Dimension dimension) {
        final double widthProportion = this.gc.getCanvas().getWidth() / this.arenaDimension.getWidth();
        final double heightProportion = this.gc.getCanvas().getHeight() / this.arenaDimension.getHeight();
        final double scaledWidth = dimension.getWidth() * widthProportion;
        final double scaledHeight = dimension.getHeight() * heightProportion;
        return new DimensionImpl(scaledWidth, scaledHeight);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(final Element element) {
        final Image spriteImage = element.getComponent(SpriteComponent.class).obtainSprite();
        this.drawImg(spriteImage, element.getPosition(), element.getDimension());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void drawBackground(final Image levelImage) {
        final Dimension arenaDim = this.arenaDimension;
        final Coord position = new CoordImpl(arenaDim.getWidth() / 2, arenaDim.getHeight() / 2);
        this.drawImg(levelImage, position, arenaDim);
    }
}
