package it.unibo.pyxis.model.level.loader;

import it.unibo.pyxis.model.level.Level;

import java.io.File;
import java.net.URL;
import java.util.Objects;

public interface LevelLoader {
    /**
     * Return the number of files present in the configuration directory.
     * @return
     *          The integer indicating the number of files present in the configuration directory.
     */
    default int getFilesCount() {
        final File dir = new File(this.getConfigurationDir().getPath());
        return Objects.requireNonNull(
                dir.listFiles(f -> f.getName().endsWith(".yaml") || f.getName().endsWith(".yml"))
        ).length;
    }

    /**
     * Return the {@link URL} of the directory where the {@link LevelLoader} is currently working on.
     * @return
     *          An {@link URL} indicating the absolute.
     */
    URL getConfigurationDir();

    /**
     * Generate a new {@link Level} from a configuration yml file.
     * @param filename
     *                  The string containing the filename located in the configuration directory.
     * @return
     *                  A new {@link Level} from a configuration file.
     */
    Level fromFile(String filename);
}
