package it.unibo.pyxis.element.ball;

import it.unibo.pyxis.element.Element;
import it.unibo.pyxis.element.brick.Brick;
import it.unibo.pyxis.element.pad.Pad;
import it.unibo.pyxis.event.notify.CollisionEvent;

public interface Ball extends Element {

    void handleBrickCollision(CollisionEvent<Brick> collision);

    void handlePadCollision(CollisionEvent<Pad> collision);

    void setStatus();

    void setPace();
}
