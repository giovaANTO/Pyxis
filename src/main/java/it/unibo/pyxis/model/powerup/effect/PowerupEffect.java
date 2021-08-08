package it.unibo.pyxis.model.powerup.effect;

import it.unibo.pyxis.model.arena.Arena;

public interface PowerupEffect {
    /**
     * Applies the effect of the {@link it.unibo.pyxis.model.element.powerup.Powerup}.
     *
     * @param arena The instance of {@link Arena}.
     */
    void applyEffect(Arena arena);
    /**
     * Returns the time of the {@link it.unibo.pyxis.model.element.powerup.Powerup}.
     *
     * @return An integer representing the time of the
     *         {@link it.unibo.pyxis.model.element.powerup.Powerup}'s application.
     */
    int getApplyTime();
    /**
     * Returns the type of the effect.
     *
     * @return The {@link PowerupEffectType}.
     */
    PowerupEffectType getType();
    /**
     * Removes the effect of the {@link it.unibo.pyxis.model.element.powerup.Powerup}.
     *
     * @param arena The instance of {@link Arena}.
     */
    void removeEffect(Arena arena);
}
