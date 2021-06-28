package it.unibo.pyxis.model.level.status;

public enum LevelStatus {
    /**
     * The current {@link it.unibo.pyxis.model.level.Level} isn't completed yet.
     */
    PLAYING,
    /**
     * The current {@link it.unibo.pyxis.model.level.Level} is successfully completed.
     */
    SUCCESSFULLY_COMPLETED,
    /**
     * The player lost all of its lives while playing this {@link it.unibo.pyxis.model.level.Level}.
     */
    GAME_OVER
}
