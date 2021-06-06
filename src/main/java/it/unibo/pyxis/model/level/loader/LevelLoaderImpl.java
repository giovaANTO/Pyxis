package it.unibo.pyxis.model.level.loader;

import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.model.level.loader.assistant.LoaderAssistant;
import it.unibo.pyxis.model.level.loader.assistant.LoaderAssistantImpl;
import it.unibo.pyxis.model.level.loader.skeleton.arena.ArenaSkeleton;
import it.unibo.pyxis.model.level.loader.skeleton.arena.ArenaSkeletonImpl;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;

public final class LevelLoaderImpl implements LevelLoader {

    private final URL configurationDirectory;
    private final LoaderAssistant loaderAssistant;

    public LevelLoaderImpl(final URL configurationDirectory) {
        if (!Objects.isNull(configurationDirectory)) {
            final File file = new File(configurationDirectory.getPath());
            if (!(file.exists() || file.isDirectory())) {
                throw new IllegalArgumentException("Invalid Url to directory");
            }
        }
        this.configurationDirectory = configurationDirectory;
        this.loaderAssistant = new LoaderAssistantImpl();
    }

    @Override
    public URL getConfigurationDir() {
        return this.configurationDirectory;
    }

    @Override
    public Level fromFile(final String filename) {
        return loaderAssistant.createLevel(this.skeletonFromFile(filename));
    }

    /**
     * Create a skeleton file from a yaml source.
     * @param filename
     *                 The yaml file name used for loading the level
     * @return
     *                 A {@link ArenaSkeleton} object with the loaded data.
     */
    private ArenaSkeleton skeletonFromFile(final String filename) {
        try (InputStream stream = new BufferedInputStream(new FileInputStream(this.getFile(filename)))) {
            final Yaml yamlConfLoader = new Yaml(new Constructor(ArenaSkeletonImpl.class));
            return (ArenaSkeleton) yamlConfLoader.load(stream);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return new ArenaSkeletonImpl();
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
        if (!(filePath.exists() || filePath.canRead())) {
            throw new IllegalArgumentException("File : " + filename + " doesn't exists or isn't readable");
        }
        return filePath;
    }
}
