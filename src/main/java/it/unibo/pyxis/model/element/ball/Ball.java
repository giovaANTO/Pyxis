package it.unibo.pyxis.model.element.ball;

import it.unibo.pyxis.model.element.Element;
import it.unibo.pyxis.model.event.collision.BallCollisionWithBorderEvent;
import it.unibo.pyxis.model.event.collision.BallCollisionWithBrickEvent;
import it.unibo.pyxis.model.event.collision.BallCollisionWithPadEvent;
import it.unibo.pyxis.model.util.Vector;

public interface Ball extends Element {
    /**
     * Allow to access to the {@link Ball} identifier.
     * @return
     *          The identifier of the {@link Ball}.
     */
    int getId();
    /**
     * Returns the ball's pace.
     * @return
     *              The pace's {@link Vector}
     */
    Vector getPace();
    /**
     * Returns the ball's type.
     * @return
     *              The {@link BallType}
     */
    BallType getType();
    /**
     * Handles the collision event between the ball and the border.
     * @param collisionEvent
     *              Receive a {@link BallCollisionWithBorderEvent}
     */
    void handleBorderCollision(BallCollisionWithBorderEvent collisionEvent);
    /**
     * Handles the collision event between the ball and a brick.
     * @param collisionEvent
     *              Receive a {@link BallCollisionWithBrickEvent}
     */
    void handleBrickCollision(BallCollisionWithBrickEvent collisionEvent);

    /**
     * Handles the collision event between the ball and the pad.
     * @param collisionEvent
     *              Receive a {@link BallCollisionWithPadEvent}
     */
    void handlePadCollision(BallCollisionWithPadEvent collisionEvent);
    /**
     * Sets the ball's pace.
     * @param pace
     *              The pace {@link Vector} to set
     */
    void setPace(Vector pace);
    /**
     * Sets the ball's type.
     * @param type
     *              The {@link BallType} to set
     */
    void setType(BallType type);
}
