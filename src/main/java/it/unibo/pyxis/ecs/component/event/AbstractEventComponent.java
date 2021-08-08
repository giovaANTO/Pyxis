package it.unibo.pyxis.ecs.component.event;

import it.unibo.pyxis.ecs.Entity;
import it.unibo.pyxis.ecs.component.AbstractComponent;
import org.greenrobot.eventbus.EventBus;

public abstract class AbstractEventComponent<E extends Entity> extends AbstractComponent<E> implements EventComponent<E> {

    protected AbstractEventComponent(final E entity) {
        super(entity);
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
    public final boolean isAttached() {
        return EventBus.getDefault().isRegistered(this);
    }
}
