package it.unibo.pyxis.view.drawer;

import it.unibo.pyxis.model.element.Element;
import javafx.scene.image.Image;

public interface Drawer {
    /**
     * Clear the linked {@link javafx.scene.canvas.Canvas} removing all
     * {@link it.unibo.pyxis.model.element.Element}s inside it.
     */
    void clear();

    /**
     * Draw an {@link it.unibo.pyxis.model.element.Element} inside the {@link javafx.scene.canvas.Canvas}.
     * @param element
     *                  The element to draw.
     */
    void draw(Element element);

    /**
     * Draw the {@link javafx.scene.canvas.Canvas} backround.
     * @param levelImage
     *               The current level to be drawed
     */
    void drawBackground(Image levelImage);

}
