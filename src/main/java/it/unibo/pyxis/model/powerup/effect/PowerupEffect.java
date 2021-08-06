package it.unibo.pyxis.model.powerup.effect;

import it.unibo.pyxis.model.arena.Arena;

public interface PowerupEffect {
    /**
     * Apply the effect of the {@link it.unibo.pyxis.model.element.powerup.Powerup}.
     *
     * @param arena
     *          The instance of {@link Arena}.
     */
    void applyEffect(Arena arena);
    /**
     * Return the time of the {@link it.unibo.pyxis.model.element.powerup.Powerup}.
     *
     * @return
     *          The time of the {@link it.unibo.pyxis.model.element.powerup.Powerup}'s
     *          application.
     */
    int getApplyTime();
    /**
     * Return the type of the effect.
     *
     * @return
     *          The type of effect applied.
     */
    PowerupEffectType getType();
    /**
     * Remove the effect of the {@link it.unibo.pyxis.model.element.powerup.Powerup}.
     *
     * @param arena
     *          The instance of {@link Arena}.
     */
    void removeEffect(Arena arena);
}
