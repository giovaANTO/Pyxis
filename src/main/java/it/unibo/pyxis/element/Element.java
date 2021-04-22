package it.unibo.pyxis.element;

import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.Dimension;

public interface Element {

    void setPosition(Coord elementCoord);

    Coord getPosition();

    void setDimension(Dimension elementDimension);

    Dimension getDimension();
}
