package it.unibo.pyxis.model.powerup.handler.pool;

import it.unibo.pyxis.model.powerup.effect.PowerupEffect;
import it.unibo.pyxis.model.powerup.effect.PowerupEffectType;
import java.util.Map;
import java.util.concurrent.Future;

public interface PowerupPool {

    /**
     * Submit a new powerup effect to the pool.
     * @param effect
     *                  The {@link PowerupEffect} instance to submit
     * @return
     *          A {@link Future} instance of the running task
     */
    Future<?> submit(PowerupEffect effect);

    /**
     * Return the map of the currently registered powerups.
     * @param type
     *              The type of powerup
     * @return
     *              Return a map of currently active powerup threads. Map's keys are the
     *              threads id and the values are {@link Thread} instances
     */
    Map<Long, Thread> getTypeMap(PowerupEffectType type);

    /**
     * Interrupt all the currently actives powerup threads.
     */
    void stop();
}
