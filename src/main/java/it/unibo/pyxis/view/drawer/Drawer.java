package it.unibo.pyxis.view.drawer;

import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;
import javafx.scene.image.Image;

public interface Drawer {
    /**
     * Clear the linked {@link javafx.scene.canvas.Canvas} removing all
     * {@link it.unibo.pyxis.model.element.Element}s inside it.
     */
    void clear();

    /**
     * Draw an {@link it.unibo.pyxis.model.element.Element} inside the {@link javafx.scene.canvas.Canvas}.
     * @param spriteImage
     *                      The {@link Image} to load.
     * @param position
     *                      The {@link Coord} indicating the position of the {@link Image}.
     * @param dimension
     *                      The {@link Dimension} of the image
     */
    void draw(Image spriteImage, Coord position, Dimension dimension);

    /**
     * Draw the {@link javafx.scene.canvas.Canvas} backround.
     * @param backgroundImage
     *                          The background's {@link Image}
     */
    void fillBackground(Image backgroundImage);
}
