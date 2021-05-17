package it.unibo.pyxis.powerup.handler;

import it.unibo.pyxis.powerup.effect.PowerupEffect;

import java.util.concurrent.Future;

public interface PowerupHandler {
    /**
     * Insert a new powerup.
     * @param effect
     *               the effect to insert
     */
    Future<?> addPowerup(PowerupEffect effect);

    /**
     * Pause the execution handler.
     * The handler will continue to register new powerups but these will applied
     * after a succesive call of {@link PowerupHandler#resume()}.
     * All the active powerups will be set to a paused state and they'll continue their execution only when the
     * handler will be resumed.
     * This method should be called only when the game is set on a pause.
     */
    void pause();

    /**
     * Resume the execution of the handler.
     * The active powerups can continue their executions.
     */
    void resume();

    /**
     * Return the paused status of the handler.
     * @return
     *          true if the internal executor of {@link PowerupHandler} is in a paused state
     */
    boolean isPaused();

    /**
     * Interrupt all the currently active powerups.
     */
    void stop();

    /**
     * Shutdown the internal executor of the handler.
     */
    void shutdown();

    /**
     * Return the number of threads that are currently running.
     * @return
     *          The thread number
     */
    int activeCount();
}
