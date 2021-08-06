package it.unibo.pyxis.model.powerup.handler.pool;

import it.unibo.pyxis.model.powerup.effect.PowerupEffect;
import it.unibo.pyxis.model.powerup.effect.PowerupEffectType;

import java.util.Map;
import java.util.concurrent.Future;

public interface PowerupPool {
    /**
     * Return the map of the currently registered
     * {@link it.unibo.pyxis.model.element.powerup.Powerup}.
     *
     * @param type
     *          The type of {@link it.unibo.pyxis.model.element.powerup.Powerup}.
     * @return
     *          A map of currently active
     *          {@link it.unibo.pyxis.model.element.powerup.Powerup} threads.
     *          Map's keys are the threads id and the values are {@link Thread}
     *          instances.
     */
    Map<Long, Thread> getTypeMap(PowerupEffectType type);
    /**
     * Interrupt all the currently actives
     * {@link it.unibo.pyxis.model.element.powerup.Powerup} threads.
     */
    void stop();

    /**
     * Submit a new {@link it.unibo.pyxis.model.element.powerup.Powerup} effect
     * to the pool.
     *
     * @param effect
     *          The {@link PowerupEffect} instance to submit.
     * @return
     *          A {@link Future} instance of the running task.
     */
    Future<?> submit(PowerupEffect effect);
}
