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
     * @param componentClass
     *                              The component class to remove
     * @param <C>
     *                              A class that extends {@link Component}
     */
    <C extends Component<?>> void removeComponent(Class<?> componentClass);

    /**
     * Return a {@link Component} previously registered in the {@link Entity}.
     * @param componentClass
     *                              The interface of the component
     * @return
     *                              A registered {@link Component}
     */
    Component<?> getComponent(Class<?> componentClass);

    /**
     * Check if a {@link Component} with a given the {@link Entity}.
     * @param componentClass
     *                              The interface of the component
     * @return
     *                              True if the interface has the {@link Component} or
     *                              false otherwise.
     */
    boolean has(Class<?> componentClass);
}
