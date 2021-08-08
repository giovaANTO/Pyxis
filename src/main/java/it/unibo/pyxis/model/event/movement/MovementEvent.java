package it.unibo.pyxis.model.event.movement;

import it.unibo.pyxis.model.element.Element;
import it.unibo.pyxis.model.event.Event;

/**
 * Event fired when an {@link Element} change its
 * {@link it.unibo.pyxis.model.util.Coord}.
 *
 * @param <E> The {@link Element} that changes its
 * {@link it.unibo.pyxis.model.util.Coord}.
 */
@FunctionalInterface
public interface MovementEvent<E extends Element> extends Event {
    /**
     * Returns the {@link Element} who fired the {@link MovementEvent}.
     *
     * @return The {@link Element}.
     */
    E getElement();
}
