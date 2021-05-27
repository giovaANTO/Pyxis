package it.unibo.pyxis.model.event.notify;

import it.unibo.pyxis.model.event.Event;
import java.util.Optional;

/**
 * Event fired when the ball's position in the lower part of the arena.
 */
@FunctionalInterface
public interface DecreaseLifeEvent extends Event {
    /**
     * Return the score gained.
     * @return
     *          The gained score.
     */
    Optional<Integer> getScore();
}
