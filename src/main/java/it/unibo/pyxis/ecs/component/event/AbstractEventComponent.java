package it.unibo.pyxis.ecs.component.event;

import it.unibo.pyxis.ecs.Entity;
import it.unibo.pyxis.ecs.component.AbstractComponent;
import org.greenrobot.eventbus.EventBus;

public abstract class AbstractEventComponent<E extends Entity> extends AbstractComponent<E> implements EventComponent<E> {

    protected AbstractEventComponent(final E entity) {
        super(entity);
    }

    @Override
    public void attach() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void detach() {
        EventBus.getDefault().unregister(this);
    }

    @Override
    public boolean isAttached() {
        return EventBus.getDefault().isRegistered(this);
    }
}
