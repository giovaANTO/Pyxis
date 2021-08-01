package it.unibo.pyxis.model.powerup.effect;

public enum PowerupEffectType {
    /**
     * Type of {@link it.unibo.pyxis.model.element.powerup.Powerup}
     * that affect the the {@link it.unibo.pyxis.model.element.pad.Pad}.
     */
    PAD_POWERUP,
    /**
     * Type of {@link it.unibo.pyxis.model.element.powerup.Powerup} that affect the balls of the
     * {@link it.unibo.pyxis.model.arena.Arena}.
     */
    BALL_POWERUP,
    /**
     * Type of {@link it.unibo.pyxis.model.element.powerup.Powerup}
     * that affect the {@link it.unibo.pyxis.model.arena.Arena} enviroment.
     */
    ARENA_POWERUP;
}
