package it.unibo.pyxis.ecs;

import it.unibo.pyxis.ecs.component.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class EntityImpl implements Entity {

    private final Map<Class<?>, Component<?>> componentMap = new HashMap<>();

    /**
     * Extracts a registered {@link Component} interface from the one in input.
     * The method will check first if the given interface is already registered in the
     * {@link Entity}, if not it will search for one of the other super interfaces.
     *
     * @param inputInterface The starting interface
     * @return An {@link Optional} with the registered interface if inputInterface is
     * present or an empty one otherwise.
     */
    private Optional<Class<?>> extractRegisteredInterface(final Class<?> inputInterface) {
        if (Objects.isNull(inputInterface)) {
            return Optional.empty();
        } else if (this.componentMap.containsKey(inputInterface)) {
            return Optional.of(inputInterface);
        }
        Class<?>[] superInterfaces = inputInterface.getInterfaces();
        return Arrays.stream(superInterfaces).filter(this.componentMap::containsKey).findFirst();
    }
    /**
     * Extracts the interface of an input {@link Component}.
     *
     * @param component The {@link Component}.
     * @return An {@link Optional} with the {@link Component} interface.
     */
    private Optional<Class<?>> findComponentInterface(final Component<?> component) {
        Class<?> actualClass = component.getClass();
        while (!actualClass.getName().equals(Object.class.getName())) {
            Class<?>[] compInterfaces = actualClass.getInterfaces();
            if (compInterfaces.length != 0) {
                final Optional<Class<?>> assignableComponentClass = Arrays.stream(compInterfaces)
                        .filter(Component.class::isAssignableFrom)
                        .findFirst();
                if (assignableComponentClass.isPresent()) {
                    return assignableComponentClass;
                }
            }
            actualClass = actualClass.getSuperclass();
        }
        return Optional.empty();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final <C extends Component<?>> C getComponent(final Class<C> componentInterface) {
        if (!this.hasComponent(componentInterface)) {
            throw new IllegalArgumentException("The component isn't registered in this entity");
        }
        final Class<?> regInterface = this.extractRegisteredInterface(componentInterface).orElseThrow();
        return componentInterface.cast(this.componentMap.get(regInterface));
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean hasComponent(final Class<?> componentInterface) {
        return this.extractRegisteredInterface(componentInterface).isPresent();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final <C extends Component<?>> void registerComponent(final C component) {
        final Optional<Class<?>> componentClass = findComponentInterface(component);
        if (componentClass.isPresent() && !this.hasComponent(componentClass.get())) {
            component.attach();
            this.componentMap.put(componentClass.get(), component);
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final <C extends Component<?>> void removeComponent(final Class<C> componentInterface) {
        if (!this.hasComponent(componentInterface)) {
            throw new IllegalArgumentException("The component isn't registered in this entity");
        }
        final Class<?> regInterface = this.extractRegisteredInterface(componentInterface).orElseThrow();
        final Component<?> removedComponent = this.componentMap.remove(regInterface);
        removedComponent.detach();
    }
}
