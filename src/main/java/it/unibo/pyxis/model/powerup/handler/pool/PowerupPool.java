package it.unibo.pyxis.model.powerup.handler.pool;

import it.unibo.pyxis.model.powerup.effect.PowerupEffect;
import it.unibo.pyxis.model.powerup.effect.PowerupEffectType;

import java.util.Map;

public interface PowerupPool {
    /**
     * Returns the map of the currently registered
     * {@link it.unibo.pyxis.model.element.powerup.Powerup}.
     *
     * @param type The type of {@link it.unibo.pyxis.model.element.powerup.Powerup}.
     * @return A map of currently active
     *         {@link it.unibo.pyxis.model.element.powerup.Powerup} threads.
     *         Map's keys are the threads id and the values are {@link Thread}
     *         instances.
     */
    Map<Long, Thread> getTypeMap(PowerupEffectType type);
    /**
     * Interrupts all the currently actives
     * {@link it.unibo.pyxis.model.element.powerup.Powerup} threads.
     */
    void stop();
    /**
     * Submits a new {@link it.unibo.pyxis.model.element.powerup.Powerup} effect
     * to the pool.
     *
     * @param effect The {@link PowerupEffect} instance to submit.
     */
    void submit(PowerupEffect effect);
}
