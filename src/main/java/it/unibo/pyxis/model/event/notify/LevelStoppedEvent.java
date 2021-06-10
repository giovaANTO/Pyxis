package it.unibo.pyxis.model.event.notify;

import it.unibo.pyxis.model.event.Event;

@FunctionalInterface
public interface LevelStoppedEvent extends Event {
    /**
     * Return the score of the currently finished {@link it.unibo.pyxis.model.level.Level}.
     * @return
     *          The total score of the {@link it.unibo.pyxis.model.level.Level}
     */
    int getLevelScore();
}
