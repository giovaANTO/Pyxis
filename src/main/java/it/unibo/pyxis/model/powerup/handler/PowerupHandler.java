package it.unibo.pyxis.model.powerup.handler;

import it.unibo.pyxis.model.powerup.effect.PowerupEffect;

public interface PowerupHandler {
    /**
     * Returns the number of threads that are currently running.
     *
     * @return The threads number.
     */
    int activeCount();

    /**
     * Inserts a new {@link it.unibo.pyxis.model.element.powerup.Powerup}.
     *
     * @param effect The effect to insert.
     */
    void addPowerup(PowerupEffect effect);
    /**
     * Returns the paused status of the {@link PowerupHandler}.
     *
     * @return True if the internal executor of {@link PowerupHandler} is in
     *         a paused state.
     *         False otherwise.
     */
    boolean isPaused();
    /**
     * Pauses the execution {@link PowerupHandler}.
     * The handler will continue to register new
     * {@link it.unibo.pyxis.model.element.powerup.Powerup} but these will be applied
     * after a successive call of {@link PowerupHandler#resume()}.
     * All the active {@link it.unibo.pyxis.model.element.powerup.Powerup}s will be
     * set to a paused state and they will continue their execution only when the
     * {@link PowerupHandler} will be resumed.
     * This method should be called only when the
     * {@link it.unibo.pyxis.model.state.GameState} is pause.
     */
    void pause();
    /**
     * Resumes the execution of the {@link PowerupHandler}.
     * The active {@link it.unibo.pyxis.model.element.powerup.Powerup}s
     * can continue their executions.
     */
    void resume();
    /**
     * Shutdowns the internal executor of the {@link PowerupHandler}.
     */
    void shutdown();
    /**
     * Interrupts all the currently active
     * {@link it.unibo.pyxis.model.element.powerup.Powerup}s.
     */
    void stop();
}
