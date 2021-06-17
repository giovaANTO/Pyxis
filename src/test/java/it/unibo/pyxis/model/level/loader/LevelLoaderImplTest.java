package it.unibo.pyxis.model.level.loader;

import it.unibo.pyxis.model.element.brick.Brick;
import it.unibo.pyxis.model.element.brick.BrickImpl;
import it.unibo.pyxis.model.element.brick.BrickType;
import it.unibo.pyxis.model.element.pad.Pad;
import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.model.util.CoordImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LevelLoaderImplTest {

    private LevelLoader loader;

    /**
     * This field shouldn't be private !
     */
    @TempDir
    public Path tempPath;

    @Test
    void testGetFilesCount() throws IOException {
        this.loader = new LevelLoaderImpl(tempPath.toUri().toURL());
        Files.createFile(tempPath.resolve("myfile.yaml"));
        Files.createFile(tempPath.resolve("myfile2.yml"));
        Files.createFile(tempPath.resolve("invalid.ext"));
        assertEquals(2, this.loader.getFilesCount());
    }

    @Test
    void testLevelCreation() throws MalformedURLException, URISyntaxException {
        Path resourceDirectory = Paths.get("src","test","resources","level-files");
        this.loader = new LevelLoaderImpl(resourceDirectory.toUri().toURL());
        assertEquals(1, this.loader.getFilesCount());

        final Level loadedLevel = loader.fromFile("level-test.yaml");
        final Set<Brick> brickSet = new HashSet<>(loadedLevel.getArena().getBricks());
        assertEquals(3, brickSet.size());

        assertTrue(brickSet.contains(new BrickImpl(BrickType.BLUE, new CoordImpl(1,1))));
        assertTrue(brickSet.contains(new BrickImpl(BrickType.RED, new CoordImpl(2,2))));
        assertTrue(brickSet.contains(new BrickImpl(BrickType.GREEN, new CoordImpl(1,4))));
    }
}