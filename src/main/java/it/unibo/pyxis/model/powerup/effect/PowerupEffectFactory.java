package it.unibo.pyxis.model.powerup.effect;

/**
 * Factory used for creating {@link PowerupEffect}.
 */
public interface PowerupEffectFactory {
    /**
     * Creates a {@link PowerupEffect} that will set the
     * {@link it.unibo.pyxis.model.element.ball.Ball} in atomic mode.
     *
     * @param applicationTime The application time of the
     *                        {@link it.unibo.pyxis.model.element.powerup.Powerup}.
     * @return A new {@link PowerupEffect} instance.
     */
    PowerupEffect atomicBallEffect(int applicationTime);
    /**
     * Creates a {@link PowerupEffect} that will modify the
     * {@link it.unibo.pyxis.model.element.pad.Pad}'s width.
     *
     * @param applicationTime The application time of the
     *                        {@link it.unibo.pyxis.model.element.powerup.Powerup}.
     * @param increaseVal The value that should be incremented to
     *                    the {@link it.unibo.pyxis.model.element.pad.Pad}'s width.
     * @return A new {@link PowerupEffect} instance.
     */
    PowerupEffect modifyPadWidthEffect(int applicationTime, double increaseVal);
    /**
     * Creates a {@link PowerupEffect} that will spawn two additional
     * {@link it.unibo.pyxis.model.element.ball.Ball}s in the
     * {@link it.unibo.pyxis.model.arena.Arena}.
     *
     * @return A new {@link PowerupEffect} instance.
     */
    PowerupEffect spawnBalls();
    /**
     * Creates a {@link PowerupEffect} that will set the
     * {@link it.unibo.pyxis.model.element.ball.Ball} in steel mode.
     *
     * @param applicationTime The application time of the
     *                        {@link it.unibo.pyxis.model.element.powerup.Powerup}.
     * @return A new {@link PowerupEffect} instance.
     */
    PowerupEffect steelBall(int applicationTime);
}
