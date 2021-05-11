package it.unibo.pyxis.element.ball;

import it.unibo.pyxis.element.Element;
import it.unibo.pyxis.element.brick.Brick;
import it.unibo.pyxis.element.pad.Pad;
import it.unibo.pyxis.event.notify.CollisionEvent;
import it.unibo.pyxis.util.Vector;

public interface Ball extends Element {

    /**
     * Handles the collision event between the ball and a brick.
     * @param collisionEvent {@link CollisionEvent}
     */
    void handleBrickCollision(CollisionEvent<Brick> collisionEvent);

    /**
     * Handles the collision event between the ball and the pad.
     * @param collisionEvent {@link CollisionEvent}
     */
    void handlePadCollision(CollisionEvent<Pad> collisionEvent);

    /**
     * Returns the ball's type.
     * @return
     *              The {@link BallType}
     */
    BallType getType();

    /**
     * Returns the ball's pace.
     * @return
     *              The {@link Vector}
     */
    Vector getPace();

    /**
     * Sets the ball's type.
     * @param type {@link BallType}
     */
    void setType(BallType type);

    /**
     * Sets the ball's pace.
     * @param pace {@link Vector}
     */
    void setPace(Vector pace);
}
