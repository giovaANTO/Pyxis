package it.unibo.pyxis.element;

import it.unibo.pyxis.util.Coord;

public interface Element {

    void setPosition(Coord elementCoord);

    Coord getPosition();

    void setDimension();

    void getDimension();
}
