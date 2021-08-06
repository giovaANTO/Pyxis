package it.unibo.pyxis.model.state;

import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.model.level.iterator.LevelIterator;

public interface GameState {
    /**
     * Return the currently playing {@link Level} of the game.
     *
     * @return The currently playing {@link Level}.
     */
    Level getCurrentLevel();

    /**
     * Return the {@link LevelIterator} of the {@link GameState}.
     *
     * @return The {@link LevelIterator}.
     */
    LevelIterator getLevelIterator();

    /**
     * Return the current score of the game.
     *
     * @return The current score
     */
    int getScore();

    /**
     * Return the currently state of the game.
     *
     * @return The currently state of the game.
     */
    StateEnum getState();

    /**
     * Set the game in a new state.
     *
     * @param stateEnum The new state of the game.
     */
    void setState(StateEnum stateEnum);

    /**
     * Reset the game.
     */
    void reset();

    /**
     * Select a starting {@link Level}.
     *
     * @param levelNumber The initial {@link Level} number.
     */
    void selectStartingLevel(int levelNumber);

    /**
     * Change the current playing {@link Level}.
     * If no other levels are available set the {@link GameState} in a stopped mode.
     */
    void switchLevel();

    /**
     * Update the game.
     *
     * @param delta The passed time.
     */
    void update(double delta);

    /**
     * Adds the {@link it.unibo.pyxis.model.level.Level} score
     * to the total score.
     */
    void updateTotalScore();
}
