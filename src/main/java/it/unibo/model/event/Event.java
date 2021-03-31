package it.unibo.model.event;

import java.security.Timestamp;

/**
 * Base event interface that describe the behaviour of
 * an event sent from a Publisher and consumed by a Subscriber
 * in the application domain.
 */
public interface Event {

    /**
     * Return the event typology.
     *
     * @return
     *          the event typology.
     */
    EventType getEventType();

    /**
     * Set the dispatch timestamp of the event.
     *
     * @param  eventDispatchTimestamp
     *                                  The dispatch timestamp of the event
     *
     */
    void setEventDispatchTimestamp(Timestamp eventDispatchTimestamp);

    /**
     * Return the dispatch timestamp of the event.
     *
     * @return
     *          the Timestamp object that rappresent the dispatching time
     *          of an event.
     */
    Timestamp getEventDispatchTimestamp();
}
