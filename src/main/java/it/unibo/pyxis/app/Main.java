package it.unibo.pyxis.app;

import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.model.level.loader.LevelLoader;
import it.unibo.pyxis.model.level.loader.LevelLoaderImpl;

import java.net.URISyntaxException;

public class Main {
    public static void main(final String[] args) throws URISyntaxException {
        final LevelLoader loader = new LevelLoaderImpl(ClassLoader.getSystemResource("config"));
        Level loadedLevel = loader.fromFile("level1.yaml");
        loadedLevel.getArena().getBrickStream().forEach(b -> System.out.println(b.getPosition().getX() + " " + b.getPosition().getY()));
    }
}
