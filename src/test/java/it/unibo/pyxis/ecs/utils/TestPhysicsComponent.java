package it.unibo.pyxis.ecs.utils;

import it.unibo.pyxis.ecs.component.physics.AbstractPhysicsComponent;

public class TestPhysicsComponent extends AbstractPhysicsComponent<TestEntity> implements TPhysicsComponent {

    private int numberOfUpdates = 0;

    public TestPhysicsComponent(final TestEntity entity) {
        super(entity);
    }

    @Override
    public void update(double elapsed) {
        this.numberOfUpdates++;
    }

    @Override
    public int getNumberOfUpdates() {
        return numberOfUpdates;
    }
}
