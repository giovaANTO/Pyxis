package it.unibo.pyxis.event;

public interface Handler {

    <E extends Event> void sendEvent(E event);
    
    void register(Object object);
    
    void unregister(Object object);

}
