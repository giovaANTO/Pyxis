package it.unibo.pyxis.event;

import com.google.common.eventbus.EventBus;

public class EventHandler {

    private static Handler HANDLER_INSTANCE = null;

    private EventHandler() {};

    public static Handler getEventHanlder() {
        if(HANDLER_INSTANCE == null) {
            HANDLER_INSTANCE = new InternalHandler();
        }
        return HANDLER_INSTANCE;
    }

    private static final class InternalHandler implements Handler {

        private final static  String BUS_ID = "mainEventBus";
        private final EventBus eventBus;

        public InternalHandler() {
            this.eventBus = new EventBus(BUS_ID);
        }

        @Override
        public <E extends Event> void sendEvent(E event) {
            this.eventBus.post(event);
        }

        @Override
        public void register(Object object) {
            this.eventBus.register(object);
        }

        @Override
        public void unregister(Object object) {
            this.eventBus.unregister(object);
        }
    }

}
