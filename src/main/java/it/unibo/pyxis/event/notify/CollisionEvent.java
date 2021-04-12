package it.unibo.pyxis.event.notify;

public interface CollisionEvent<T> extends NotifyEvent {
    T getCollidedObject();
}
