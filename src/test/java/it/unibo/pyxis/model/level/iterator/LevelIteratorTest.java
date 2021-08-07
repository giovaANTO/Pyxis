package it.unibo.pyxis.model.level.iterator;

import it.unibo.pyxis.model.level.Level;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class LevelIteratorTest {

    @Test
    public void testLevelChanging() {
        Path resourceDirectory = Paths.get("src","test","resources","level-files","iterator");
        final Iterator<Level> levelIterator = new LevelIterator();
        Level levelIterated = levelIterator.next();
        assertNotNull(levelIterated);
        assertEquals(1, levelIterated.getLevelNumber());
        assertTrue(levelIterator.hasNext());

        levelIterated = levelIterator.next();
        assertNotNull(levelIterated);
        assertEquals(2, levelIterated.getLevelNumber());
        assertTrue(levelIterator.hasNext());
    }
}