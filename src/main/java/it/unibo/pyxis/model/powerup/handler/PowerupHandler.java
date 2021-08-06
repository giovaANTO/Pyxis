package it.unibo.pyxis.model.powerup.handler;

import it.unibo.pyxis.model.powerup.effect.PowerupEffect;

import java.util.concurrent.Future;

public interface PowerupHandler {
    /**
     * Return the number of threads that are currently running.
     *
     * @return
     *          The threads number.
     */
    int activeCount();

    /**
     * Insert a new {@link it.unibo.pyxis.model.element.powerup.Powerup}.
     *
     * @param effect
     *          The effect to insert.
     */
    Future<?> addPowerup(PowerupEffect effect);
    /**
     * Return the paused status of the {@link PowerupHandler}.
     *
     * @return
     *          true if the internal executor of {@link PowerupHandler} is in
     *          a paused state, otherwise false.
     */
    boolean isPaused();
    /**
     * Pause the execution {@link PowerupHandler}.
     * The handler will continue to register new
     * {@link it.unibo.pyxis.model.element.powerup.Powerup} but these will applied
     * after a successive call of {@link PowerupHandler#resume()}.
     * All the active {@link it.unibo.pyxis.model.element.powerup.Powerup}s will be
     * set to a paused state and they'll continue their execution only when the
     * {@link PowerupHandler} will be resumed.
     * This method should be called only when the
     * {@link it.unibo.pyxis.model.state.GameState} is pause.
     */
    void pause();
    /**
     * Resume the execution of the {@link PowerupHandler}.
     * The active {@link it.unibo.pyxis.model.element.powerup.Powerup}
     * can continue their executions.
     */
    void resume();
    /**
     * Shutdown the internal executor of the {@link PowerupHandler}.
     */
    void shutdown();
    /**
     * Interrupt all the currently active
     * {@link it.unibo.pyxis.model.element.powerup.Powerup}s.
     */
    void stop();
}
