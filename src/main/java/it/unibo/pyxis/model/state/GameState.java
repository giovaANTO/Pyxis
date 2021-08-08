package it.unibo.pyxis.model.state;

import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.model.level.iterator.LevelIterator;

public interface GameState {
    /**
     * Returns the currently playing {@link Level} of the game.
     *
     * @return The currently playing {@link Level}.
     */
    Level getCurrentLevel();
    /**
     * Returns the {@link LevelIterator} of the {@link GameState}.
     *
     * @return The {@link LevelIterator}.
     */
    LevelIterator getLevelIterator();
    /**
     * Returns the current score of the game.
     *
     * @return The current score
     */
    int getScore();
    /**
     * Returns the currently state of the game.
     *
     * @return The currently state of the game.
     */
    StateEnum getState();
    /**
     * Sets the game in a new {@link StateEnum}.
     *
     * @param stateEnum The new {@link StateEnum} of the game.
     */
    void setState(StateEnum stateEnum);
    /**
     * Resets the game.
     */
    void reset();
    /**
     * Selects a starting {@link Level}.
     *
     * @param levelNumber The initial {@link Level} number.
     */
    void selectStartingLevel(int levelNumber);
    /**
     * Changes the current playing {@link Level}.
     * If no other levels are available set the {@link GameState} in a stopped mode.
     */
    void switchLevel();
    /**
     * Updates the game.
     *
     * @param delta The elapsed time between two calls on the update method.
     */
    void update(double delta);
    /**
     * Adds the {@link it.unibo.pyxis.model.level.Level} score to the total score.
     */
    void updateTotalScore();
}
