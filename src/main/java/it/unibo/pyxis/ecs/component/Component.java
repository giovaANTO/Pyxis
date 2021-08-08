package it.unibo.pyxis.ecs.component;

import it.unibo.pyxis.ecs.Entity;

public interface Component<E extends Entity> {
    /**
     * Attaches this component into an {@link Entity}.
     */
    void attach();
    /**
     * Detaches this component.
     */
    void detach();
    /**
     * Returns the {@link Entity} linked to this {@link Component}.
     *
     * @return An {@link Entity} instance.
     */
    E getEntity();
    /**
     * Returns true if this {@link Component} is attached to an
     * {@link Entity}.
     *
     * @return True if the component is attached.
     *         False otherwise.
     */
    boolean isAttached();
}
