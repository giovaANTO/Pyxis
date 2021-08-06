package it.unibo.pyxis.ecs;

import it.unibo.pyxis.ecs.utils.TestEntity;
import it.unibo.pyxis.ecs.utils.TestEventComponent;
import it.unibo.pyxis.ecs.utils.TestPhysicsComponent;
import it.unibo.pyxis.ecs.component.event.EventComponent;
import it.unibo.pyxis.ecs.component.physics.PhysicsComponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityTest {

    private TestEntity entity;

    @BeforeEach
    void init() {
        this.entity = new TestEntity();
    }

    @Test
    void testRegisterComponent() {
        this.entity.registerComponent(new TestPhysicsComponent(this.entity));
        assertTrue(this.entity.hasComponent(PhysicsComponent.class));

        this.entity.registerComponent(new TestEventComponent(this.entity));
        assertTrue(this.entity.hasComponent(EventComponent.class));
    }

    @Test
    void testRemoveComponent() {
        this.entity.registerComponent(new TestPhysicsComponent(this.entity));
        assertTrue(this.entity.hasComponent(PhysicsComponent.class));

        this.entity.removeComponent(PhysicsComponent.class);
        assertFalse(this.entity.hasComponent(PhysicsComponent.class));
    }

    @Test
    void testCantRemoveNotRegisteredComponent() {
        assertThrows(IllegalArgumentException.class, () -> this.entity.removeComponent(PhysicsComponent.class));
    }

    @Test
    void testGetComponent() {
        final PhysicsComponent<TestEntity> toAttachComponent = new TestPhysicsComponent(this.entity);
        this.entity.registerComponent(toAttachComponent);
        assertTrue(this.entity.hasComponent(PhysicsComponent.class));
        final PhysicsComponent<TestEntity> fetchComponent = this.entity.getComponent(PhysicsComponent.class);
        assertEquals(toAttachComponent, fetchComponent);
    }
}