package it.unibo.pyxis.model.ecs.component.physics;

import java.util.logging.Level;
import java.util.logging.Logger;
import it.unibo.pyxis.model.ecs.entity.Entity;

public abstract class AbstractPhysicsComponent<E extends Entity> implements PhysicsComponent<E> {

    private final E entity;
    private boolean isAttached;

    public AbstractPhysicsComponent(final E entity) {
        this.entity = entity;
        this.isAttached = false;
    }

    /**
     * Return a {@link Logger} instance.
     * @return
     *          A {@link Logger} instance
     */
    private Logger getLogger() {
        return Logger.getLogger(this.getClass().getName());
    }

    @Override
    public void attach() {
        this.isAttached = true;
        this.getLogger().log(Level.INFO, "Physics component attached");
    }

    @Override
    public void detach() {
        this.isAttached = false;
        this.getLogger().log(Level.INFO, "Physics component detached");
    }

    @Override
    public E getEntity() {
        return this.entity;
    }

    @Override
    public boolean isAttached() {
        return this.isAttached;
    }

    @Override
    public abstract void update(double elapsed);
}
