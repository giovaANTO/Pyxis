package it.unibo.pyxis.element.powerup.effect;

/**
 * Factory used for creating {@link PowerupEffect}.
 */
public interface PowerupEffectFactory {

    /**
     * Create a new powerup effect that enlarge the pad dimension.
     * @return a {@link PowerupEffect} class
     */
    PowerupEffect enlargePad();

    /**
     * Create a new powerup effect that reduce the pad dimension.
     * @return a{@link PowerupEffect} class
     */
    PowerupEffect reducePad();

    /**
     * Create a new powerup effect that set the Ball in the atomic state.
     * @return a {@link PowerupEffect} class
     */
    PowerupEffect atomicBall();

    /**
     * Create a new powerup effect that set the Ball in the iron state.
     * @return a {@link PowerupEffect} class
     */
    PowerupEffect ironBall();
}
