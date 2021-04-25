package it.unibo.pyxis.element.powerup.effect;
import it.unibo.pyxis.arena.Arena;

public interface PowerupEffect {

    /**
     * Create a new powerup thread that will apply and remove the effects
     * after a certain timeout.
     *
     * @param arena
     *              The arena instance where the powerup should be applied
     */
    void apply(Arena arena);

    /**
     * Get the type of effect this powerup apply.
     *
     * @return powerupEffectType
     *                            The type of effect applied
     */
    PowerupEffectType getType();
}
