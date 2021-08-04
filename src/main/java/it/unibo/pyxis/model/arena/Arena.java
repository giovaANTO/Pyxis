package it.unibo.pyxis.model.arena;

import java.util.Set;

import it.unibo.pyxis.model.event.notify.PowerupActivationEvent;
import it.unibo.pyxis.model.powerup.handler.PowerupHandler;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.element.ball.Ball;
import it.unibo.pyxis.model.element.brick.Brick;
import it.unibo.pyxis.model.element.pad.Pad;
import it.unibo.pyxis.model.element.powerup.Powerup;
import it.unibo.pyxis.model.event.notify.BrickDestructionEvent;

public interface Arena {

    /**
     * Add a {@link Ball} in the {@link Arena}.
     * @param ball
     *           The {@link Ball} to add.
     */
    void addBall(Ball ball);
    /**
     * Add a {@link Brick} in the {@link Arena}.
     * @param brick
     *              The {@link Brick} to add.
     */
    void addBrick(Brick brick);
    /**
     * Add a default {@link Ball} to the {@link Arena}.
     */
    void addDefaultBall();
    /**
     * Add a new {@link Powerup} in the {@link Arena}.
     * @param powerup
     *               The {@link Powerup} to add.
     */
    void addPowerup(Powerup powerup);
    /**
     * Check if {@link Ball} or {@link Powerup} is colliding with a border.
     *
     * Removes the {@link Ball} or {@link Powerup} colliding with the bottom border,
     * Otherwise sends a {@link it.unibo.pyxis.model.event.collision.CollisionEvent}
     * with the edge the {@link Ball} is colliding with.
     */
    void checkBorderCollision();
    /**
     * Procedure of cleanup of the {@link Arena}.
     * Unregister all the elements from the {@link org.greenrobot.eventbus.EventBus}
     * and shutdown the {@link it.unibo.pyxis.model.powerup.handler.PowerupHandler}.
     */
    void cleanUp();
    /**
     * Decrease the {@link Pad}'s {@link Dimension}'s width of an input amount.
     * @param amount
     *          The amount to decrease.
     */
    void decreasePadWidth(double amount);
    /**
     * Return a {@link java.util.Set} of {@link Ball} that are currently present in
     * the {@link Arena}.
     * @return
     *          A {@link java.util.Set} of {@link Ball}.
     */
    Set<Ball> getBalls();
    /**
     * Return a {@link java.util.Set} of {@link Brick} that are currently present in
     * the {@link Arena}.
     * @return
     *          A {@link java.util.Set} of {@link Brick}.
     */
    Set<Brick> getBricks();
    /**
     * Returns the dimensions of the {@link Arena}.
     *
     * @return
     *          A {@link Dimension} instance.
     */
    Dimension getDimension();
    /**
     * Return the last {@link Ball} id inserted in the {@link Arena}.
     * @return
     *          The integer representing the last id inserted
     *          in the {@link Arena}
     */
    int getLastBallId();
    /**
     * Get the current {@link Pad} in the {@link Arena}.
     * @return
     *          The {@link Pad} actually present in the {@link Arena}.
     */
    Pad getPad();
    /**
     * Return the {@link PowerupHandler} of the {@link Arena}.
     * @return
     *          A {@link PowerupHandler}.
     */
    PowerupHandler getPowerupHandler();
    /**
     * Return a {@link java.util.Set} of {@link Powerup} that are currently present in
     * the {@link Arena}.
     * @return
     *          A {@link java.util.Set} of {@link Powerup}.
     */
    Set<Powerup> getPowerups();
    /**
     * Return a random {@link Ball} registered in this {@link Arena}.
     * @return
     *          A {@link Ball} in the {@link Arena}
     */
    Ball getRandomBall();
    /**
     * Handle a {@link BrickDestructionEvent}.
     * @param event
     *              The instance of {@link BrickDestructionEvent}
     */
    void handleBrickDestruction(BrickDestructionEvent event);
    /**
     * Handle a {@link PowerupActivationEvent}.
     * @param event
     *              The instance of {@link PowerupActivationEvent}
     */
    void handlePowerupActivation(PowerupActivationEvent event);
    /**
     * Increase the {@link Pad}'s {@link Dimension}'s width of an input amount.
     * @param amount
     *          The amount to increase.
     */
    void increasePadWidth(double amount);
    /**
     * Check if the {@link Arena} is cleared, or rather, there aren't any bricks left except for the ones
     * of indestructible type.
     * @return
     *          True if the {@link Arena} is cleared, False otherwise.
     */
    boolean isCleared();
    /**
     * Move pad to the left of the {@link Arena}.
     */
    void movePadLeft();
    /**
     * Move pad to the rigth of the {@link Arena}.
     */
    void movePadRight();
    /**
     * Set a default {@link Pad} in the {@link Arena}.
     */
    void setDefaultPad();
    /**
     * Set the {@link Pad} in the {@link Arena}.
     * @param pad
     *          The {@link Pad} to add.
     */
    void setPad(Pad pad);
    /**
     * Update the elements of the {@link Arena}.
     * @param delta
     *              The passed time.
     */
    void update(double delta);
}
