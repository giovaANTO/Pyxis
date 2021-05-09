package it.unibo.pyxis.event;

public interface EventHandler {

    <E extends Event> void sendEvent(E event);
    
    void register(Object object);
    
    void unregister(Object object);
}
