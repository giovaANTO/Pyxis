package it.unibo.pyxis.ecs;

import it.unibo.pyxis.ecs.utils.TestEntity;
import it.unibo.pyxis.ecs.utils.TestEventComponent;
import it.unibo.pyxis.ecs.utils.TestUpdateComponent;
import it.unibo.pyxis.ecs.component.event.EventComponent;
import it.unibo.pyxis.ecs.component.physics.UpdateComponent;
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
        this.entity.registerComponent(new TestUpdateComponent(this.entity));
        assertTrue(this.entity.hasComponent(UpdateComponent.class));

        this.entity.registerComponent(new TestEventComponent(this.entity));
        assertTrue(this.entity.hasComponent(EventComponent.class));
    }

    @Test
    void testRemoveComponent() {
        this.entity.registerComponent(new TestUpdateComponent(this.entity));
        assertTrue(this.entity.hasComponent(UpdateComponent.class));

        this.entity.removeComponent(UpdateComponent.class);
        assertFalse(this.entity.hasComponent(UpdateComponent.class));
    }

    @Test
    void testCantRemoveNotRegisteredComponent() {
        assertThrows(IllegalArgumentException.class, () -> this.entity.removeComponent(UpdateComponent.class));
    }

    @Test
    void testGetComponent() {
        final UpdateComponent<TestEntity> toAttachComponent = new TestUpdateComponent(this.entity);
        this.entity.registerComponent(toAttachComponent);
        assertTrue(this.entity.hasComponent(UpdateComponent.class));
        final UpdateComponent<TestEntity> fetchComponent = this.entity.getComponent(UpdateComponent.class);
        assertEquals(toAttachComponent, fetchComponent);
    }
}