package it.unibo.pyxis.model.level.loader;

import it.unibo.pyxis.model.level.Level;
import java.net.URL;

public interface LevelLoader {

    /**
     * Return the {@link URL} of the directory where the {@link LevelLoader} is currently working on.
     * @return
     *          An {@link URL} indicating the absolute.
     */
    String getConfigurationDir();

    /**
     * Generate a new {@link Level} from a configuration yml file.
     * @param filename
     *                  The string containing the filename located in the configuration directory.
     * @return
     *                  A new {@link Level} from a configuration file.
     */
    Level fromFile(String filename);
}
