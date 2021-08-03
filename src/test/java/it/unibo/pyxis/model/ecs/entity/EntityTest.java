package it.unibo.pyxis.model.ecs.entity;

import it.unibo.pyxis.model.ecs.component.Component;
import it.unibo.pyxis.model.ecs.entity.component.TypeA;
import it.unibo.pyxis.model.ecs.entity.component.TypeAComponent;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityTest {

    final Entity entity = new DummyEntity();

    @Test
    @Order(1)
    void registerComponent() {
        entity.registerComponent(new TypeAComponent());
        assertTrue(entity.has(TypeA.class));
    }

    @Test
    @Order(2)
    void getComponent() {
        entity.registerComponent(new TypeAComponent());
        assertDoesNotThrow(() -> entity.getComponent(TypeA.class));

    }

    @Test
    @Order(3)
    void removeComponent() {
        entity.registerComponent(new TypeAComponent());
        assertDoesNotThrow(() -> entity.removeComponent(TypeA.class));
    }
}