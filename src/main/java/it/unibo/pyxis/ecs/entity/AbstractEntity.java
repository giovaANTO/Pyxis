package it.unibo.pyxis.ecs.entity;

import it.unibo.pyxis.ecs.component.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public abstract class AbstractEntity implements Entity {

    private final Map<Class<?>, Component<?>> componentMap = new HashMap<>();

    /**
     * Extract the interface of an input {@link Component}.
     * @param component
     *                  The {@link Component}
     * @return
     *                  A {@link Class} representing the {@link Component} interface
     *                  or null if the component isn't extending any interface.
     */
    private Class<?> findComponentInterface(final Component<?> component) {
        Class<?> actualClass = component.getClass();
        Class<?>[] compInterfaces = actualClass.getInterfaces();
        while (compInterfaces.length == 0 && !actualClass.getName().equals(Object.class.getName())) {
            actualClass = actualClass.getSuperclass();
            compInterfaces = actualClass.getInterfaces();
        }
        return compInterfaces.length != 0 ? compInterfaces[0] : null;
    }

    /**
     * @param inputInterface
     * @return
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

    @Override
    public final <C extends Component<?>> void registerComponent(final C component) {
        final Class<?> componentClass = findComponentInterface(component);
        if (!this.hasComponent(componentClass)) {
            component.attach();
            this.componentMap.put(componentClass, component);
        } else {
            throw new IllegalArgumentException("The input component can't be registered in this entity");
        }
    }

    @Override
    public final <C extends Component<?>> void removeComponent(final Class<C> componentInterface) {
        if (!this.hasComponent(componentInterface)) {
            throw new IllegalArgumentException("The component isn't registered in this entity");
        }
        final Class<?> regInterface = this.extractRegisteredInterface(componentInterface).orElseThrow();
        final Component<?> removedComponent = this.componentMap.remove(regInterface);
        removedComponent.detach();
    }

    @Override
    public final <C extends Component<?>> C getComponent(final Class<C> componentInterface) {
        if (!this.hasComponent(componentInterface)) {
            throw new IllegalArgumentException("The component isn't registered in this entity");
        }
        final Class<?> regInterface = this.extractRegisteredInterface(componentInterface).orElseThrow();
        return componentInterface.cast(this.componentMap.get(regInterface));
    }

    @Override
    public final boolean hasComponent(final Class<?> componentInterface) {
        return this.extractRegisteredInterface(componentInterface).isPresent();
    }
}
