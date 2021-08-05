package it.unibo.pyxis.ecs.component;

import it.unibo.pyxis.ecs.Entity;

public abstract class AbstractComponent<E extends Entity> implements Component<E> {

    private final E entity;

    public AbstractComponent(final E entity) {
        this.entity = entity;
    }

    @Override
    public final E getEntity() {
        return this.entity;
    }

    @Override
    public abstract void attach();

    @Override
    public abstract void detach();

    @Override
    public abstract boolean isAttached();
}
