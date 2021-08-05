package it.unibo.pyxis.model.level;

import it.unibo.pyxis.model.arena.Arena;
import it.unibo.pyxis.model.event.notify.BrickDestructionEvent;
import it.unibo.pyxis.model.event.notify.DecreaseLifeEvent;
import it.unibo.pyxis.model.level.status.LevelStatus;

public interface Level {
    /**
     * Clean up the current {@link Level} and the assigned {@link Arena}
     * unregistering them from the{@link org.greenrobot.eventbus.EventBus}.
     */
    void cleanUp();
    /**
     * Decrease a life.
     */
    void decreaseLife();
    /**
     * Get the {@link Arena} associated to this level.
     *
     * @return
     *          The instance of {@link Arena}.
     */
    Arena getArena();
    /**
     * Return the number of the {@link Level} loaded.
     *
     * @return
     *          An integer representing the {@link Level} number.
     */
    int getLevelNumber();

    /**
     * Return the current {@link LevelStatus} of the {@link Level}.
     *
     * @return
     *          The value of {@link LevelStatus}
     */
    LevelStatus getLevelStatus();

    /**
     * Return the total number of lives.
     *
     * @return
     *          The number of current lives.
     */
    int getLives();

    /**
     * Return the total score of this level.
     *
     * @return
     *          The score.
     */
    int getScore();

    /**
     * Handle a {@link BrickDestructionEvent}.
     *
     * @param event
     *          The instance of {@link BrickDestructionEvent}
     */
    void handleBrickDestruction(BrickDestructionEvent event);

    /**
     * Handle a {@link DecreaseLifeEvent}.
     *
     * @param event
     *          The instance of {@link DecreaseLifeEvent}.
     */
    void handleDecreaseLife(DecreaseLifeEvent event);

    /**
     * Call an un update on the {@link Level} updating each
     * {@link it.unibo.pyxis.model.element.Element} in the {@link Arena} and check
     * its status.
     *
     * @param delta
     *          The time gap elapsed between an update.
     */
    void update(double delta);
}
