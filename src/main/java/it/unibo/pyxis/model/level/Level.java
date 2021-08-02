package it.unibo.pyxis.model.level;

import it.unibo.pyxis.model.arena.Arena;
import it.unibo.pyxis.model.event.notify.BrickDestructionEvent;
import it.unibo.pyxis.model.event.notify.DecreaseLifeEvent;
import it.unibo.pyxis.model.level.status.LevelStatus;

public interface Level {

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
     * Handle a {@link DecreaseLifeEvent}.
     * @param event
     *              The instance of {@link DecreaseLifeEvent}.
     */
    void handleDecreaseLife(DecreaseLifeEvent event);

    /**
     * Handle a {@link BrickDestructionEvent}.
     * @param event
     *              The instance of {@link BrickDestructionEvent}
     */
    void handleBrickDestruction(BrickDestructionEvent event);

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
