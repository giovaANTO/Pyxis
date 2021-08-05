package it.unibo.pyxis.model.level.iterator;

public enum Config {

    /**
     * Represent the extension (.yaml, .yml) of a level configuration file.
     */
    LEVEL_FILE_EXTENSION(".yaml"),
    /**
     * Represent the prefix of a generic level configuration file.
     */
    LEVEL_FILE_PREFIX("level"),
    /**
     * Represent the name of the source folder of level configurations files.
     */
    LEVEL_RESOURCE_FOLDER("config");

    private final String value;

    Config(final String inputValue) {
        this.value = inputValue;
    }

    /**
     * Return the value of a configuration variable.
     *
     * @return
     *          A String representing the value of a configuration variable.
     */
    public String getValue() {
        return this.value;
    }
}
