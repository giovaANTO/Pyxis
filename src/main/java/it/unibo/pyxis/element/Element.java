package it.unibo.pyxis.element;

import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.Dimension;

public interface Element {

    /**
     * Sets the element's coord.
     * @param elementCoord
     */
    void setPosition(Coord elementCoord);

    /**
     * Returns the element's position.
     * @return
     */
    Coord getPosition();

    /**
     * Sets the element's dimension.
     * @param elementDimension
     */
    void setDimension(Dimension elementDimension);

    /**
     * Returns the element's dimension.
     * @return
     */
    Dimension getDimension();
}
