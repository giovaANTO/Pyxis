package it.unibo.pyxis.event;
import com.google.common.eventbus.EventBus;


public final class EventHandlerImpl implements EventHandler {

    private final EventBus eventBus = new EventBus();
    private static EventHandler eventHandlerInstance;

    private EventHandlerImpl() { }

    public static EventHandler getEventHandler() {
        if (eventHandlerInstance == null) {
            eventHandlerInstance = new EventHandlerImpl();
        }
        return eventHandlerInstance;
    }

    @Override
    public <E extends Event> void sendEvent(final E event) {
        this.eventBus.post(event);
    }

    @Override
    public void register(final Object object) {
        this.eventBus.register(object);
    }

    @Override
    public void unregister(final Object object) {
        this.eventBus.unregister(object);
    }
}
