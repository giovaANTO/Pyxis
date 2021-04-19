package it.unibo.pyxis.element.ball;

import it.unibo.pyxis.element.Element;

public interface Ball extends Element {

    void handleBrickCollision();

    void handlePadCollision();

    void setStatus();

    void setPace();
}
