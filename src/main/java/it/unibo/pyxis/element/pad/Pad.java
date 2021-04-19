package it.unibo.pyxis.element.pad;

import it.unibo.pyxis.element.Element;

public interface Pad extends Element {

    void handleBallMovement();

    void handlePowerupMovement();
}
