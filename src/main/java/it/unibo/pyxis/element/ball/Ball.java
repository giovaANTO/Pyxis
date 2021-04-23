package it.unibo.pyxis.element.ball;

import it.unibo.pyxis.element.Element;
import it.unibo.pyxis.element.brick.Brick;
import it.unibo.pyxis.element.pad.Pad;
import it.unibo.pyxis.event.notify.CollisionEvent;

public interface Ball extends Element {

    /**
     * Handles the collision event between the ball and a brick.
     * @param collisionEvent
     */
    void handleBrickCollision(CollisionEvent<Brick> collisionEvent);

    /**
     * Handles the collision event between the ball and the pad.
     * @param collisionEvent
     */
    void handlePadCollision(CollisionEvent<Pad> collisionEvent);


    void setStatus();

    void setPace();
}
