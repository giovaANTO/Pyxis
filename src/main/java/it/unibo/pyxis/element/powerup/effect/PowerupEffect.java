package it.unibo.pyxis.element.powerup.effect;
import it.unibo.pyxis.arena.Arena;

@FunctionalInterface
public interface PowerupEffect {
    /**
     * Create a new powerup thread that will apply and remove the effects
     * after a certain timeout.
     * @param arena the arena instance where the powerup should be applied
     */
    void apply(Arena arena);
}
