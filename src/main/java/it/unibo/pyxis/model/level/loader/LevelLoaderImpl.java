package it.unibo.pyxis.model.level.loader;

import it.unibo.pyxis.model.level.Level;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.util.Objects;

public class LevelLoaderImpl implements LevelLoader {

    private final URL configurationDirectory;

    public LevelLoaderImpl(final URL configurationDirectory) {
        if (!Objects.isNull(configurationDirectory)) {
            final File file = new File(configurationDirectory.getPath());
            if (!(file.exists() || file.isDirectory())) {
                throw new IllegalArgumentException("Invalid Url to directory");
            }
        }
        this.configurationDirectory = configurationDirectory;
    }

    @Override
    public URL getConfigurationDir() {
        return this.configurationDirectory;
    }

    @Override
    public Level fromFile(final String filename) {
        return null;
    }
}
