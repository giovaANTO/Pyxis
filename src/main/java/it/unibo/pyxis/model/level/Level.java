package it.unibo.pyxis.model.level;

import it.unibo.pyxis.model.arena.Arena;
import it.unibo.pyxis.ecs.Entity;
import it.unibo.pyxis.model.level.status.LevelStatus;

public interface Level extends Entity {

    /**
     * Return the number of the {@link Level} loaded.
     * @return
     *          An integer representing the {@link Level} number
     */
    int getLevelNumber();

    /**
     * Decrease a life.
     */
    void decreaseLife();

    /**
     * Return the total number of lifes.
     * @return
     *          The number of current lifes
     */
    int getLives();

    /**
     * Return the total score of this level.
     * @return
     *         The score
     */
    int getScore();

    /**
     * Get the {@link Arena} associated to this level.
     * @return
     *          The instance of {@link Arena}
     */
    Arena getArena();

    /**
     * Call an un update on the level updating the elements on the arena and check its status.
     * @param delta
     *              The time gap intercurred between an update
     */
    void update(double delta);

    /**
     * Increase the score of this level.
     * @param score
     *               The score to increase
     */
    void increaseScore(int score);

    /**
     * Sets a {@link LevelStatus}.
     * @param levelStatus
     *                    The input {@link LevelStatus} to set
     */
    void setLevelStatus(LevelStatus levelStatus);

    /**
     * Return the current {@link LevelStatus} of the {@link Level}.
     * @return
     *          The value of {@link LevelStatus}
     */
    LevelStatus getLevelStatus();

    /**
     * Clean up the current {@link Level} and the assigned {@link Arena}
     * unregistering them from the{@link org.greenrobot.eventbus.EventBus}.
     */
    void cleanUp();
}
