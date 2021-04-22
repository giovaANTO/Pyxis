package it.unibo.pyxis.element.ball;

import it.unibo.pyxis.element.Element;
import it.unibo.pyxis.element.brick.Brick;
import it.unibo.pyxis.element.pad.Pad;
import it.unibo.pyxis.event.notify.CollisionEvent;

public interface Ball extends Element {

    void handleBrickCollision(CollisionEvent<Brick> collisionEvent);

    void handlePadCollision(CollisionEvent<Pad> collisionEvent);

    void setStatus();

    void setPace();
}
