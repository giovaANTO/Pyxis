package it.unibo.pyxis.app;

import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.model.level.iterator.LevelIterator;

import java.util.Iterator;

public class Main {
    public static void main(final String[] args) {

        final Iterator<Level> levelIterator = new LevelIterator();
        final Level firstLevel = levelIterator.next();

        firstLevel.getArena().getBricks().forEach(b -> {
            System.out.println("Brick type: {" + b.getBrickType() + "} x:" + b.getPosition().getX() + " y: " + b.getPosition().getY());
        });


        /*final Iterator<Level> levelIterator = new LevelIterator();
        final Level firstLevel = levelIterator.next();



        final Pad pad = firstLevel.getArena().getPad();
        System.out.println("Pad x:" + pad.getPosition().getX() + " y:" + pad.getPosition().getY());

        firstLevel.getArena().getBalls().forEach(System.out::println);
        levelIterator.hasNext();
        */
        /*
            System.out.println(levelIterator.hasNext());

            final Level secondLevel = levelIterator.next();
            secondLevel.getArena().getBricks().forEach(b -> {
                System.out.println("Brick type: {" + b.getBrickType() + "} x:" + b.getPosition().getX() + " y: " + b.getPosition().getY());
            });
        */
    }
}
