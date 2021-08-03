package it.unibo.pyxis.model.ecs.entity;

import it.unibo.pyxis.model.ecs.component.Component;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractEntity implements Entity {

    private final Map<Class<?>, Component<?>> componentMap = new HashMap<>();

    @Override
    public final <C extends Component<?>> void registerComponent(final C component) {
        final Class<?> componentClass = component.getClass().getInterfaces()[0];
        if (!this.has(componentClass)) {
            component.attach();
            this.componentMap.put(componentClass, component);
        }
    }

    @Override
    public final <C extends Component<?>> void removeComponent(final Class<C> componentInterface) {
        if (!this.has(componentInterface)) {
            throw new IllegalArgumentException("The component isn't registered in this entity");
        }
        final Component<?> removedComponent = this.componentMap.remove(componentInterface);
        removedComponent.detach();
    }

    @Override
    public final <C extends Component<?>> C getComponent(final Class<C> componentInterface) {
        if (!this.has(componentInterface)) {
            throw new IllegalArgumentException("The component isn't registered in this entity");
        }
        return componentInterface.cast(this.componentMap.get(componentInterface));
    }


    @Override
    public final boolean has(final Class<?> componentInterface) {
        return this.componentMap.containsKey(componentInterface);
    }
}
