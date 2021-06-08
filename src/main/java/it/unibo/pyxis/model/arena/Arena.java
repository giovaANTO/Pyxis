package it.unibo.pyxis.model.arena;

import java.util.Set;

import it.unibo.pyxis.model.event.notify.PowerupActivationEvent;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.element.ball.Ball;
import it.unibo.pyxis.model.element.brick.Brick;
import it.unibo.pyxis.model.element.pad.Pad;
import it.unibo.pyxis.model.element.powerup.Powerup;
import it.unibo.pyxis.model.event.notify.BrickDestructionEvent;

public interface Arena {

    /**
     * Update the elements of the {@link Arena}.
     * @param delta
     *              The passed time.
     */
    void update(int delta);

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
     * Returns the dimensions of the {@link Arena}.
     *
     * @return
     *          A {@link Dimension} instance.
     */
    Dimension getDimension();

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
     * Return a {@link java.util.Set} of {@link Powerup} that are currently present in
     * the {@link Arena}.
     * @return
     *          A {@link java.util.Set} of {@link Powerup}.
     */
    Set<Powerup> getPowerups();

    /**
     * Get the current {@link Pad} in the {@link Arena}.
     * @return
     *          The {@link Pad} actually present in the {@link Arena}.
     */
    Pad getPad();

    /**
     * Set the {@link Pad} in the {@link Arena}.
     * @param inputPad
     *          The {@link Pad} to add.
     */
    void setPad(Pad inputPad);

    /**
     * Add a {@link Brick} in the {@link Arena}.
     * @param brick
 *              The {@link Brick} to add.
     */
    void addBrick(Brick brick);

    /**
     * Add a {@link Ball} in the {@link Arena}.
     * @param ball
 *              The {@link Ball} to add.
     */
    void addBall(Ball ball);

    /**
     * Add a new {@link Powerup} in the {@link Arena}.
     * @param powerup
 *               The {@link Powerup} to add.
     */
    void addPowerup(Powerup powerup);

    /**
     * Check if the {@link Arena} is cleared, or rather, there aren't any bricks left except for the ones
     * of indestructible type.
     * @return
     *          True if the {@link Arena} is cleared, False otherwise.
     */
    boolean isCleared();
}
