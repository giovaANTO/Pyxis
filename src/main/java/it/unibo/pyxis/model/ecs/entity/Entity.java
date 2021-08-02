package it.unibo.pyxis.model.ecs.entity;

import it.unibo.pyxis.model.ecs.component.Component;

public interface Entity {

    /**
     * Register a new {@link Component} in the {@link Entity}.
     * @param component
     *            The component to register
     * @param <C>
     *            A class that extends {@link Component}
     */
    <C extends Component<?>> void registerComponent(C component);

    /**
     * Remove a {@link Component} previously registered in the {@link Entity}.
     * @param component
     *             The component to register
     * @param <C>
     *              A class that extends {@link Component}
     */
    <C extends Component<?>> void removeComponent(C component);

    /**
     * Return a {@link Component} previously registered in the {@link Entity}.
     * @param <C>
     *          A class that extends {@link Component}
     * @return
     *          A registered {@link Component}
     */
    <C extends Component<?>> C getComponent();
}
