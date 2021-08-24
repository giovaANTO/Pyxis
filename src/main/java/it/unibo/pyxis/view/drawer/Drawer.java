package it.unibo.pyxis.view.drawer;

import it.unibo.pyxis.model.element.Element;
import javafx.scene.image.Image;

public interface Drawer {
    /**
     * Clears the linked {@link javafx.scene.canvas.Canvas} removing all
     * {@link it.unibo.pyxis.model.element.Element}s inside it.
     */
    void clear();

    /**
     * Draws an {@link it.unibo.pyxis.model.element.Element} inside the
     * {@link javafx.scene.canvas.Canvas}.
     *
     * @param element The {@link Element} to draw.
     */
    void draw(Element element);

    /**
     * Draws the {@link javafx.scene.canvas.Canvas} background.
     *
     * @param levelImage The {@link it.unibo.pyxis.model.level.Level} to be drawn.
     */
    void drawBackground(Image levelImage);

}
