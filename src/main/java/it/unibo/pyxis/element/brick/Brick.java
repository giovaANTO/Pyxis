package it.unibo.pyxis.element.brick;

import it.unibo.pyxis.element.Element;

public interface Brick extends Element {

    void handleBallMovement();

    int getDurability();
}
