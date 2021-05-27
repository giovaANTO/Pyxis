package it.unibo.pyxis.model.powerup.effect;

import it.unibo.pyxis.model.arena.Arena;

public interface PowerupEffect {

    /**
     * Apply the effect of the powerup.
     * @param arena
     *                 The instance of {@link Arena}
     */
    void applyEffect(Arena arena);

    /**
     * Remove the effect of the powerup.
     * @param arena
     *                 The instance of {@link Arena}
     */
    void removeEffect(Arena arena);

    /**
     * Return the time of the powerup.
     * @return
     *                  The time of the powerup's application.
     */
     int getApplyTime();

    /**
     * Return the type of the effect.
     * @return
     *                 The type of effect applied
     */
    PowerupEffectType getType();
}
