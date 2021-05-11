package it.unibo.pyxis.element;

import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.Dimension;

public interface Element {

    /**
     * Returns the element's position.
     * @return
     *          The element's {@link Coord}
     */
    Coord getPosition();

    /**
     * Returns the element's dimension.
     * @return
     *         The element's {@link Dimension}
     */
    Dimension getDimension();

    /**
     * Execute an update on the element.
     */
    void update();
}
