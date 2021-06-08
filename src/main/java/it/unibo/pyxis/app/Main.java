package it.unibo.pyxis.app;


import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.model.level.iterator.LevelIterator;
import java.util.Iterator;

public class Main {
    public static void main(final String[] args) {
        final Iterator<Level> levelIterator = new LevelIterator();
        final Level firstLevel = levelIterator.next();

        firstLevel.getArena().getBrickStream().forEach(b -> {
            System.out.println("Brick type: {" + b.getBrickType() + "} x:" + b.getPosition().getX() + " y: " + b.getPosition().getY());
        });

        System.out.println(levelIterator.hasNext());

        final Level secondLevel = levelIterator.next();
        secondLevel.getArena().getBrickStream().forEach(b -> {
            System.out.println("Brick type: {" + b.getBrickType() + "} x:" + b.getPosition().getX() + " y: " + b.getPosition().getY());
        });

    }
}
