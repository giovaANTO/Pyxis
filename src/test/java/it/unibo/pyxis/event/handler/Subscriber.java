package it.unibo.pyxis.event.handler;

import com.google.common.base.Objects;
import com.google.common.eventbus.Subscribe;

public class Subscriber {

    private boolean isHandled = false;
    private int countHandled = 0;

    @Subscribe
    public void onTestEvent(TestEvent testEvent) {
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
