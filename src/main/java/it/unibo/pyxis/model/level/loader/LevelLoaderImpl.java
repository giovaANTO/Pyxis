package it.unibo.pyxis.model.level.loader;

import it.unibo.pyxis.model.level.Level;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.net.URL;
import java.util.Map;
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
        this.openFile(filename);
        return null;
    }


    private Map<String, Object> openFile(final String filename) {
        try (InputStream stream = new BufferedInputStream(new FileInputStream(this.getFile(filename)))) {
            final Yaml yamlConfLoader = new Yaml();
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

    /**
     * Get a configuration file from the config directory.
     * @param filename
     *                  The name of the file that should be opened with the relative extension.
     * @return
     *                  A new {@link File} instance.
     * @throws IllegalArgumentException
     *                  If file doesn't exists or isn't readable
     */
    private File getFile(final String filename) throws IllegalArgumentException {
        final File filePath = new File(this.configurationDirectory.getPath(), filename);
        if (!filePath.exists() || !filePath.canRead()) {
            throw new IllegalArgumentException("File : " + filename + " doesn't exists or isn't readable");
        }
        return filePath;
    }

}
