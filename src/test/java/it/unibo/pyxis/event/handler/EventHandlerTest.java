package it.unibo.pyxis.event.handler;

import it.unibo.pyxis.event.EventHandler;
import it.unibo.pyxis.event.Handler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventHandlerTest {

    private Subscriber firstSubscriber;
    private Subscriber secondSubscriber;
    private Handler eventHandler;

    @BeforeEach
    void setUp() {
        this.firstSubscriber = new Subscriber("Subscriber 1");
        this.secondSubscriber = new Subscriber("Subscriber 2");
        this.eventHandler = EventHandler.getEventHanlder();
        // Register the subscribers
        this.eventHandler.register(firstSubscriber);
        this.eventHandler.register(secondSubscriber);
    }

    @Test
    public void testSingletonInstance() {
        assertNotNull(this.eventHandler);
    }

    @Test
    public void testEventSending() {
        System.out.println("testEventSending");
        this.sendTestEvent();
        // Both the subscribers should handle the event
        assertTrue(this.firstSubscriber.getIsHandled());
        assertTrue(this.secondSubscriber.getIsHandled());
    }

    @Test
    public void testUnregister() {
        System.out.println("testUnregister");
        this.eventHandler.unregister(this.firstSubscriber);
        this.sendTestEvent();
        // First subscriber should not receive the event
        assertFalse(this.firstSubscriber.getIsHandled());
        assertTrue(this.secondSubscriber.getIsHandled());
    }

    @Test
    public void testDuplicatedSubscriber() {
        System.out.println("testDuplicatedSubscriber");
        this.eventHandler.register(this.firstSubscriber);
        this.sendTestEvent();

        assertEquals(this.firstSubscriber.getCountHandled(), 1);
    }


    @Test
    public void testPowerupEvent() {
        System.out.println("testPowerupEvent");
    }

    private void sendTestEvent() {
        this.eventHandler.sendEvent(new TestEvent() {
            @Override
            public void handle() {
                System.out.println("Handled!");
            }
        });
    }
}