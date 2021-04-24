package it.unibo.pyxis.element.powerup.effect;

import it.unibo.pyxis.arena.Arena;

public interface PowerupEffect {
    /**
     * Return the activation time of the powerup.
     * @return powerup's activation time.
     */
    long getTime();

    /**
     * Apply the powerup effects.
     * @param arena the instance of the arena
     */
    void applyEffects(Arena arena);

    /**
     * Remove the powerup effects.
     * @param arena the instance of the arena
     */
    void removeEffects(Arena arena);

    /**
     * Create a new powerup thread that will apply and remove the effects
     * after a certain timeout.
     */
    void apply();
}
