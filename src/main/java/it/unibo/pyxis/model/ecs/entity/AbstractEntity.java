package it.unibo.pyxis.model.ecs.entity;

import it.unibo.pyxis.model.ecs.component.Component;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractEntity implements Entity {

    private final Map<Class<?>, Component<?>> componentMap = new HashMap<>();

    @Override
    public final <C extends Component<?>> void registerComponent(final C component) {
        final Class<?> componentClass = component.getClass();
        if (!this.has(componentClass)) {
            component.attach(this);
            this.componentMap.put(componentClass, component);
        }
    }

    @Override
    public final <C extends Component<?>> void removeComponent(final Class<?> componentClass) {
        if (!this.has(componentClass)) {
            throw new IllegalArgumentException("The component isn't registered in this entity");
        }
        final Component<?> removedComponent = this.componentMap.remove(componentClass);
        removedComponent.detach();
    }

    @Override
    public final Component<?> getComponent(final Class<?> componentClass) {
        if (!this.has(componentClass)) {
            throw new IllegalArgumentException("The component isn't registered in this entity");
        }
        return this.componentMap.get(componentClass);
    }

    @Override
    public final boolean has(final Class<?> componentClass) {
        return this.componentMap.containsKey(componentClass);
    }
}
