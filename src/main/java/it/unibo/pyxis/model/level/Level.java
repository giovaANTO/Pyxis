package it.unibo.pyxis.model.level;

import it.unibo.pyxis.model.arena.Arena;
import it.unibo.pyxis.ecs.Entity;
import it.unibo.pyxis.model.level.status.LevelStatus;

public interface Level extends Entity {
    /**
     * Cleans up the current {@link Level} and the assigned {@link Arena}
     * unregistering them from the {@link org.greenrobot.eventbus.EventBus}.
     */
    void cleanUp();
    /**
     * Decreases a life.
     */
    void decreaseLife();
    /**
     * Gets the {@link Arena} associated to this {@link Level}.
     *
     * @return The instance of {@link Arena}.
     */
    Arena getArena();
    /**
     * Returns the number of the {@link Level} loaded.
     *
     * @return An integer representing the {@link Level} number.
     */
    int getLevelNumber();
    /**
     * Returns the current {@link LevelStatus} of the {@link Level}.
     *
     * @return The value of {@link LevelStatus}.
     */
    LevelStatus getLevelStatus();
    /**
     * Returns the total number of lives still available.
     *
     * @return An integer representing the number of current lives.
     */
    int getLives();
    /**
     * Returns the total score of this level.
     *
     * @return An integer representing the score.
     */
    int getScore();
    /**
     * Increases the score of the {@link Level} of a certain amount.
     *
     * @param score The amount to add.
     */
    void increaseScore(int score);
    /**
     * Sets a {@link LevelStatus}.
     *
     * @param levelStatus The input {@link LevelStatus} to set.
     */
    void setLevelStatus(LevelStatus levelStatus);
    /**
     * Calls an un update on the {@link Level} updating each
     * {@link it.unibo.pyxis.model.element.Element} in the {@link Arena} and check
     * its status.
     *
     * @param delta The elapsed time between two calls on the update method.
     */
    void update(double delta);
}
