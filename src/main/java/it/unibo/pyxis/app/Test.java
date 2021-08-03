package it.unibo.pyxis.app;

import it.unibo.pyxis.model.arena.ArenaImpl;
import it.unibo.pyxis.model.arena.component.ArenaPhysicsComponent;
import it.unibo.pyxis.model.util.DimensionImpl;

public class Test {
    public static void main(String[] args) {
        final ArenaPhysicsComponent c = new ArenaPhysicsComponent(new ArenaImpl(new DimensionImpl(1,1)));
        c.update(1);
    }
}
