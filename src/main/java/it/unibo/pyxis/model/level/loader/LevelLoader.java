package it.unibo.pyxis.model.level.loader;

import it.unibo.pyxis.model.level.Level;

import java.net.URI;

public interface LevelLoader {
    /**
     * Return the number of files present in the configuration directory.
     * @return
     *          The integer indicating the number of files present in the configuration directory.
     */
    int getCount();

    /**
     * Return the {@link URI} of the directory where the {@link LevelLoader} is currently working on.
     * @return
     *          An {@link URI} indicating the absolute.
     */
    URI getConfigurationDir();

    /**
     * Generate a new {@link Level} from a configuration yml file.
     * @param filename
     *                  The string containing the filename located in the configuration directory.
     * @return
     *                  A new {@link Level} from a configuration file.
     */
    Level fromFile(String filename);
}
