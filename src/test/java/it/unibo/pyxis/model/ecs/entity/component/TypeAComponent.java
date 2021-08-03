package it.unibo.pyxis.model.ecs.entity.component;

import it.unibo.pyxis.model.ecs.entity.Entity;

public class TypeAComponent implements TypeA {

    private Entity entity;
    @Override
    public <A extends Entity> void attach(A entity) {
        this.entity = entity;
        System.out.println("Attached");
    }

    @Override
    public void detach() {
        System.out.println("Detached");
    }

    @Override
    public boolean isAttached() {
        return false;
    }
}
