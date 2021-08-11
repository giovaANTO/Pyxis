package it.unibo.pyxis.ecs.utils;

import it.unibo.pyxis.ecs.component.physics.AbstractUpdateComponent;

public class TestUpdateComponent extends AbstractUpdateComponent<TestEntity> implements TPhysicsComponent {

    private int numberOfUpdates = 0;

    public TestUpdateComponent(final TestEntity entity) {
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
