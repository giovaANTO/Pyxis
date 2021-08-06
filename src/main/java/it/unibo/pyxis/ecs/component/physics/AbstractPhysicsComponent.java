package it.unibo.pyxis.ecs.component.physics;

import java.util.logging.Level;
import java.util.logging.Logger;

import it.unibo.pyxis.ecs.component.AbstractComponent;
import it.unibo.pyxis.ecs.Entity;

public abstract class AbstractPhysicsComponent<E extends Entity> extends AbstractComponent<E> implements PhysicsComponent<E> {

    private boolean isAttached;

    public AbstractPhysicsComponent(final E entity) {
        super(entity);
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
    public boolean isAttached() {
        return this.isAttached;
    }

    @Override
    public abstract void update(double elapsed);
}
