package it.unibo.pyxis.model.ecs.component;

import it.unibo.pyxis.model.ecs.entity.Entity;

public interface Component<E extends Entity> {
    /**
     * Attach this component into an {@link Entity}.
     * @param entity
     *             The entity where this component should be attached
     */
    <T extends Entity> void attach(T entity);

    /**
     * Detach this component.
     */
    void detach();

    /**
     * Return true if this {@link Component} is attacched to an
     * {@link Entity}.
     * @return
     *         A boolean value.
     */
    boolean isAttached();
}
