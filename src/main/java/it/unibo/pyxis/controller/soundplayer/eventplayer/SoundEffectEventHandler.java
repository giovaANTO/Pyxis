package it.unibo.pyxis.controller.soundplayer.eventplayer;

import it.unibo.pyxis.model.event.collision.BallCollisionWithBorderEvent;
import it.unibo.pyxis.model.event.collision.BallCollisionWithBrickEvent;
import it.unibo.pyxis.model.event.collision.BallCollisionWithPadEvent;
import it.unibo.pyxis.model.event.notify.DecreaseLifeEvent;
import it.unibo.pyxis.model.event.notify.PowerupActivationEvent;

public interface SoundEffectEventHandler {

    /**
     * Handles the collision event between the ball and a brick.
     *
     * @param collisionEvent Receive a {@link BallCollisionWithBrickEvent}.
     */
    void handleBallBrickCollision(BallCollisionWithBrickEvent collisionEvent);
    /**
     * Handles the collision event between the ball and the border.
     *
     * @param collisionEvent Receive a {@link BallCollisionWithBorderEvent}.
     */
    void handleBorderCollision(BallCollisionWithBorderEvent collisionEvent);
    /**
     * Handles the collision event between the ball and the pad.
     *
     * @param collisionEvent Receive a {@link BallCollisionWithPadEvent}.
     */
    void handlePadCollision(BallCollisionWithPadEvent collisionEvent);
    /**
     * Handles a {@link PowerupActivationEvent}.
     *
     * @param event The instance of {@link PowerupActivationEvent}.
     */
    void handlePowerupActivation(PowerupActivationEvent event);
    /**
     * Handles a {@link DecreaseLifeEvent}.
     *
     * @param event The instance of {@link DecreaseLifeEvent}.
     */
    void handleDecreaseLife(DecreaseLifeEvent event);
    /**
     * Shuts down the {@link SoundEffectEventHandler}.
     */
    void shutdown();
}
