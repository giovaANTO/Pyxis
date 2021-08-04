package it.unibo.pyxis.model.ecs.entity;

import it.unibo.pyxis.model.ecs.component.Component;

public interface Entity {
    /**
     * Register a new {@link Component} in the {@link Entity}.
     * @param component
     *                              The component to register
     * @param <C>
     *                              A class that extends {@link Component}
     */
    <C extends Component<?>> void registerComponent(C component);

    /**
     * Remove a {@link Component} previously registered in the {@link Entity}.
     * @param <C>
     *                              A class that extends {@link Component}
     * @param componentInterface
 *                              The component class to remove
     */
    <C extends Component<?>> void removeComponent(Class<C> componentInterface);

    /**
     * Return a {@link Component} previously registered in the {@link Entity}.
     * @param componentInterface
     *                              The interface of the component
     * @return
     *                              A registered {@link Component}
     */
    <C extends Component<?>> C getComponent(Class<C> componentInterface);

    /**
     * Check if a {@link Component} with a given the {@link Entity}.
     * @param componentInterface
     *                              The interface of the component
     * @return
     *                              True if the interface has the {@link Component} or
     *                              false otherwise.
     */
    boolean hasComponent(Class<?> componentInterface);
}
