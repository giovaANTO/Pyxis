package it.unibo.pyxis.model.state;

import it.unibo.pyxis.model.level.Level;

public interface GameState {
    /**
     * Return the currently playing {@link Level} of the game.
     * @return
     *          The currently playing {@link Level}
     */
    Level getCurrentLevel();

    /**
     * Return the current score of the game.
     * @return
     *          The current score
     */
    int getScore();

    /**
     * Return the currently state of the game.
     * @return
     *          The currently state of the game.
     */
    State getGameState();

    /**
     * Set the game in a new state.
     * @param state
     *           The new state of the game.
     */
    void setState(State state);

    /**
     * Update the game.
     * @param delta
     *              The passed time.
     */
    void update(int delta);
}
