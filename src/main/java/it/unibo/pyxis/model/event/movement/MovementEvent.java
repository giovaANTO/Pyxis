package it.unibo.pyxis.model.event.movement;

import it.unibo.pyxis.model.element.Element;
import it.unibo.pyxis.model.event.Event;

/**
 * Represent a generic movement event.
 */
@FunctionalInterface
public interface MovementEvent<E extends Element> extends Event {
    E getElement();
}
