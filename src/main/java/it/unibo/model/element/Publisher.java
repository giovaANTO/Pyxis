package it.unibo.model.element;

import it.unibo.model.event.Event;

public interface Publisher {
    void trigger(Event event);
}
