package it.unibo.pyxis.model.level.loader;

import it.unibo.pyxis.model.level.Level;

public interface LevelLoader {
    /**
     * Generate a new {@link Level} from a configuration yml file.
     * @param filename
     *          The string containing the filename located in the configuration
     *          directory.
     * @return
     *          A new {@link Level} from a configuration file.
     */
    Level fromFile(String filename);
}
