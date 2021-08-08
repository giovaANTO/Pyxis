package it.unibo.pyxis.ecs.component.event;

import it.unibo.pyxis.ecs.Entity;
import org.greenrobot.eventbus.EventBus;

public abstract class AbstractEventComponent<E extends Entity> implements EventComponent<E> {

    private final E entity;

    protected AbstractEventComponent(final E entity) {
        this.entity = entity;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final void attach() {
        EventBus.getDefault().register(this);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final void detach() {
        EventBus.getDefault().unregister(this);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final E getEntity() {
        return this.entity;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean isAttached() {
        return EventBus.getDefault().isRegistered(this);
    }
}
