package it.unibo.pyxis.model.state;

import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.model.level.iterator.LevelIterator;

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
    StateEnum getState();

    /**
     * Set the game in a new state.
     * @param stateEnum
     *           The new state of the game.
     */
    void setState(StateEnum stateEnum);

    /**
     * Update the game.
     * @param delta
     *              The passed time.
     */
     void update(double delta);

    /**
     * Reset the game.
     */
    void reset();

    /**
     * Select a starting {@link Level}.
     * @param levelNumber
     *          The initial {@link Level} number
     */
    void selectStartingLevel(int levelNumber);

    /**
     * Return the {@link LevelIterator} of the {@link GameState}.
     * @return
     *          The {@link LevelIterator}.
     */
    LevelIterator getLevelIterator();

    void switchLevel();
}
