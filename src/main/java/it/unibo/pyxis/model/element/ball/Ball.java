package it.unibo.pyxis.model.element.ball;

import it.unibo.pyxis.model.element.Element;
import it.unibo.pyxis.model.event.collision.BrickCollisionEvent;
import it.unibo.pyxis.model.event.collision.PadCollisionEvent;
import it.unibo.pyxis.model.util.Vector;

public interface Ball extends Element {

    /**
     * Handles the collision event between the ball and a brick.
     * @param collisionEvent
     *              Receive a {@link BrickCollisionEvent}
     */
    void handleBrickCollision(BrickCollisionEvent collisionEvent);

    /**
     * Handles the collision event between the ball and the pad.
     * @param collisionEvent
     *              Receive a {@link PadCollisionEvent}
     */
    void handlePadCollision(PadCollisionEvent collisionEvent);

    /**
     * Returns the ball's type.
     * @return
     *              The {@link BallType}
     */
    BallType getType();

    /**
     * Returns the ball's pace.
     * @return
     *              The pace's {@link Vector}
     */
    Vector getPace();

    /**
     * Sets the ball's type.
     * @param type
     *              The {@link BallType} to set
     */
    void setType(BallType type);

    /**
     * Sets the ball's pace.
     * @param pace
     *              The pace {@link Vector} to set
     */
    void setPace(Vector pace);

    /**
     * Allow to access to the {@link Ball} identifier.
     * @return
     *          The identifier of the {@link Ball}.
     */
    int getId();
}
