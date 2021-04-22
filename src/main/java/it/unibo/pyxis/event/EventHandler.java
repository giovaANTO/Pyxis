package it.unibo.pyxis.event;
import com.google.common.eventbus.EventBus;


public final class EventHandler {

    private static Handler handlerInstance;

    private EventHandler() { }

    public static Handler getEventHandler() {
        if (handlerInstance == null) {
            handlerInstance = new InternalHandler();
        }
        return handlerInstance;
    }

    private static final class InternalHandler implements Handler {

        private static final String BUS_ID = "mainEventBus";
        private final EventBus eventBus;

        InternalHandler() {
            this.eventBus = new EventBus(BUS_ID);
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
}
