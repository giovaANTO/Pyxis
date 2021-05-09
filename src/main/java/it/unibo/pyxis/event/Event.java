package it.unibo.pyxis.event;

/**
 * Describe an event fired in the application model.
 * An event is created as a response of a certain action that involve one or more entities.
 *
 * Examples of events are :
 * <ul>
 *     <li> a movement of an element </li>
 *     <li> a collision </li>
 *     <li> a notification of a status change </li>
 *     <li> etc..</li>
 * </ul>
 *
 * Instances of Event and relative extensions can be dispatched using {@link EventHandlerImpl} class.
 */
public interface Event {
}
