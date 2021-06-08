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
        assertTrue(levelIterator.hasNext());
        assertNotNull(levelIterator.next());
        assertTrue(levelIterator.hasNext());
        assertNotNull(levelIterator.next());
        assertFalse(levelIterator.hasNext());
    }
}