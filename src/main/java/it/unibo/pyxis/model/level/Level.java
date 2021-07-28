package it.unibo.pyxis.model.level;

import it.unibo.pyxis.model.arena.Arena;
import it.unibo.pyxis.model.event.notify.DecreaseLifeEvent;
import it.unibo.pyxis.model.level.status.LevelStatus;

public interface Level {
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
     * Handle a {@link DecreaseLifeEvent}.
     * @param event
     *              The instance of {@link DecreaseLifeEvent}.
     */
    void handleDecreaseLife(DecreaseLifeEvent event);

    /**
     * Return the current {@link LevelStatus} of the {@link Level}.
     * @return
     *          The value of {@link LevelStatus}
     */
    LevelStatus getLevelStatus();
}
