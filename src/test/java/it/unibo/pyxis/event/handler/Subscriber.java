package it.unibo.pyxis.event.handler;

import com.google.common.base.Objects;
import com.google.common.eventbus.Subscribe;
import it.unibo.pyxis.event.EventHandler;
import it.unibo.pyxis.event.movement.PowerupMovementEvent;

public class Subscriber {

    private boolean isHandled = false;
    private int countHandled = 0;
    private final String name;

    public Subscriber (final String name) {
        this.name = name;
    }


    @Subscribe
    public void onTestEvent(TestEvent testEvent) {
        System.out.println("Sono " + this.name + " ho ricevuto un TestEvent");
        testEvent.handle();
        this.isHandled = true;
        this.countHandled++;
    }


    public boolean getIsHandled() {
        return  this.isHandled;
    }

    public int getCountHandled() {
        return this.countHandled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subscriber)) return false;
        Subscriber that = (Subscriber) o;
        return isHandled == that.isHandled;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isHandled);
    }
}
