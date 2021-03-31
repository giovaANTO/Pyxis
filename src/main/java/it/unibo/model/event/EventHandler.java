package it.unibo.model.event;

import it.unibo.model.element.Subscriber;
import java.util.Set;

/**
 * EvenHandler interface describe the behavior of an Event Handler
 * of the application domain. An event handler act as a publisher of
 * events between the various Subscriber entities.
 */
public interface EventHandler {

    /**
     * Send an event to registered subscribers objects
     *
     * @param event
     *                  Event that should be sent
     */
    void publish(Event event);

    void subscribe(Subscriber subscriber, EventType eventType);

    void unsubscribe(Subscriber subscriber, EventType eventType);

    Set<Subscriber> getSubscribers();
}
