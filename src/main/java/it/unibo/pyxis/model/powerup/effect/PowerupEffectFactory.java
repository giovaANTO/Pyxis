package it.unibo.pyxis.model.powerup.effect;

/**
 * Factory used for creating {@link PowerupEffect}.
 */
public interface PowerupEffectFactory {
    /**
     * Create a {@link PowerupEffect} that will modify the Pad's width.
     * @param applicationTime
     *                          The application time of the Powerup.
     * @param increaseVal
     *                          The value that should be incremented to the Pad's width
     * @return
     *          A new {@link PowerupEffect} instance
     */
    PowerupEffect modifyPadWidthEffect(int applicationTime, double increaseVal);

    /**
     * Create a {@link PowerupEffect} that will set the ball in atomic mode.
     *
     * @param applicationTime
     *                          The application time of the Powerup.
     * @return
     *          A new {@link PowerupEffect} instance
     */
    PowerupEffect atomicBallEffect(int applicationTime);

    /**
     * Create a {@link PowerupEffect} that will set the ball in steel mode.
     *
     * @param applicationTime
     *                          The application time of the Powerup.
     * @return
     *         A new {@link PowerupEffect} instance
     */
    PowerupEffect steelBall(int applicationTime);
}
