package it.unibo.pyxis.arena;

import java.util.stream.Stream;

import it.unibo.pyxis.util.Dimension;
import it.unibo.pyxis.element.ball.Ball;
import it.unibo.pyxis.element.brick.Brick;
import it.unibo.pyxis.element.pad.Pad;
import it.unibo.pyxis.element.powerup.Powerup;
import it.unibo.pyxis.event.notify.BrickDestructionEvent;

public interface Arena {

    /**
     * Update the elements of the {@link Arena}.
     * @param delta
     *              The passed time.
     */
    void update(Double delta);

    /**
     * Handle a {@link BrickDestructionEvent}.
     * @param event
     *              The instance of {@link BrickDestructionEvent}
     */
    void handleBrickDestruction(BrickDestructionEvent event);

    /**
     * Returns the dimensions of the {@link Arena}.
     *
     * @return
     *          A {@link Dimension} instance.
     */
    Dimension getDimension();

    /**
     * Return a {@link Stream} of {@link Ball} that are currently present in
     * the {@link Arena}.
     * @return
     *          A {@link Stream} of {@link Ball}.
     */
    Stream<Ball> getBallStream();

    /**
     * Return a {@link Stream} of {@link Brick} that are currently present in
     * the {@link Arena}.
     * @return
     *          A {@link Stream} of {@link Brick}.
     */
    Stream<Brick> getBrickStream();

    /**
     * Return a {@link Stream} of {@link Powerup} that are currently present in
     * the {@link Arena}.
     * @return
     *          A {@link Stream} of {@link Powerup}.
     */
    Stream<Powerup> getPowerupStream();

    /**
     * Get the current {@link Pad} in the {@link Arena}.
     * @return
     *          The {@link Pad} actually present in the {@link Arena}.
     */
    Pad getPad();

    /**
     * Set the {@link Pad} in the {@link Arena}.
     * @param pad
     *              The {@link Pad} to add.
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
}
