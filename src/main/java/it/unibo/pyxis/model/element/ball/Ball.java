package it.unibo.pyxis.model.element.ball;

import it.unibo.pyxis.model.element.Element;
import it.unibo.pyxis.model.event.collision.BallCollisionWithBorderEvent;
import it.unibo.pyxis.model.event.collision.BallCollisionWithBrickEvent;
import it.unibo.pyxis.model.event.collision.BallCollisionWithPadEvent;
import it.unibo.pyxis.model.hitbox.HitEdge;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.Vector;

import java.util.Map;

public interface Ball extends Element {

    /**
     * Return the collision information {@link Map}
     * of the {@link Ball}.
     * @return
     *         The {@link Map} containing the collision informations of the
     *         {@link Ball}.
     */
    Map<HitEdge, Dimension> getCollisionInformations();

    /**
     * Clear all the collision informations of the {@link Ball}.
     */
    void clearCollisionInformations();

    /**
     * Register a new {@link Ball} collision.
     * @param hitEdge
     *                  {@link HitEdge} repsenting the edge hitted in the collision.
     * @param offset
     *                  Offset of the collision
     */
    void registerCollision(HitEdge hitEdge, Dimension offset);

    /**
     * Handles the collision event between the ball and a brick.
     * @param collisionEvent
     *              Receive a {@link BallCollisionWithBrickEvent}
     */
    void handleBrickCollision(BallCollisionWithBrickEvent collisionEvent);

    /**
     * Handles the collision event between the ball and the border.
     * @param collisionEvent
     *              Receive a {@link BallCollisionWithBorderEvent}
     */
    void handleBorderCollision(BallCollisionWithBorderEvent collisionEvent);

    /**
     * Handles the collision event between the ball and the pad.
     * @param collisionEvent
     *              Receive a {@link BallCollisionWithPadEvent}
     */
    void handlePadCollision(BallCollisionWithPadEvent collisionEvent);

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
