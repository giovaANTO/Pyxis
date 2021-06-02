package it.unibo.pyxis.model.level.loader;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class LevelLoaderImplTest {

    private LevelLoader loader;

    /**
     * This field shouldn't be private !
     */
    @TempDir
    public Path tempPath;

    @Test
    void getFilesCount() throws IOException {
        this.loader = new LevelLoaderImpl(tempPath.toUri().toURL());
        Files.createFile(tempPath.resolve("myfile.yaml"));
        Files.createFile(tempPath.resolve("myfile2.yml"));
        Files.createFile(tempPath.resolve("invalid.ext"));
        assertEquals(2, this.loader.getFilesCount());
    }
}