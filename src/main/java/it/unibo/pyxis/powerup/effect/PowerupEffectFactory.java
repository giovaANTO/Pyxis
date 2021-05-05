package it.unibo.pyxis.powerup.effect;

/**
 * Factory used for creating {@link PowerupEffect}.
 */
public interface PowerupEffectFactory {
    /**
     * Create a {@link PowerupEffect} that will modify the Pad's width.
     * @param applicationTime   The application time of the Powerup.
     * @param increaseVal       The value that should be incremented to the Pad's width
     * @return
     *          A new {@link PowerupEffect} class
     */
    PowerupEffect modifyPadWidth(int applicationTime, double increaseVal);
}
