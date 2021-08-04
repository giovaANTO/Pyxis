package it.unibo.pyxis.ecs.component.event;

import it.unibo.pyxis.ecs.entity.Entity;
import org.greenrobot.eventbus.EventBus;

public abstract class AbstractEventComponent<E extends Entity> implements EventComponent<E> {

    private final E entity;

    protected AbstractEventComponent(final E entity) {
        this.entity = entity;
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
    public E getEntity() {
        return this.entity;
    }

    @Override
    public boolean isAttached() {
        return EventBus.getDefault().isRegistered(this);
    }
}
