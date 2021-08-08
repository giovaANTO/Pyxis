package it.unibo.pyxis.ecs;

import it.unibo.pyxis.ecs.component.Component;

public interface Entity {
    /**
     * Returns a {@link Component} previously registered in the {@link Entity}.
     *
     * @param componentInterface The interface of the component.
     * @param <C> A class that extends {@link Component}.
     * @return A registered {@link Component}.
     */
    <C extends Component<?>> C getComponent(Class<C> componentInterface);

    /**
     * Checks if a {@link Component} with a given the {@link Entity}.
     *
     * @param componentInterface The interface of the component.
     * @return True if the interface has the {@link Component}.
     *         False otherwise.
     */
    boolean hasComponent(Class<?> componentInterface);

    /**
     * Registers a new {@link Component} in the {@link Entity}.
     *
     * @param component The component to register.
     * @param <C> A class that extends {@link Component}.
     */
    <C extends Component<?>> void registerComponent(C component);

    /**
     * Removes a {@link Component} previously registered in the {@link Entity}.
     *
     * @param <C> A class that extends {@link Component}.
     * @param componentInterface The component class to remove.
     */
    <C extends Component<?>> void removeComponent(Class<C> componentInterface);
}
