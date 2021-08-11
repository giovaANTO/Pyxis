package it.unibo.pyxis.controller.linker;

import it.unibo.pyxis.controller.command.Command;
import it.unibo.pyxis.model.state.GameState;
import it.unibo.pyxis.view.*;

public interface Linker {
    /**
     * Sets the {@link GameState}'s {@link it.unibo.pyxis.model.state.StateEnum} to
     * PAUSE and load the {@link EndLevelSceneView}.
     */
    void endLevel();
    /**
     * Returns the instance of {@link GameState}.
     *
     * @return The {@link GameState}.
     */
    GameState getGameState();
    /**
     * Returns the maximum level reached by the player during the actual game session.
     *
     * @return The index of the maximum {@link it.unibo.pyxis.model.level.Level}.
     */
    int getMaximumLevelReached();
    /**
     * Adds a {@link Command} to the list of commands that a player can input.
     *
     * @param levelCommand The {@link Command} to add.
     */
    void insertCommand(Command<GameState> levelCommand);
    /**
     * Loads the {@link MenuSceneView}.
     */
    void menu();
    /**
     * Loads the {@link PauseSceneView} and
     * set the {@link GameState}'s {@link it.unibo.pyxis.model.state.StateEnum}
     * to PAUSE.
     */
    void pause();
    /**
     * Closes the application.
     */
    void quit();
    /**
     * Renders the current {@link View} if
     * {@link RenderableView}.
     */
    void render();
    /**
     * Resumes a paused {@link GameState}.
     */
    void resume();
    /**
     * Loads the {@link GameSceneView}.
     */
    void run();
    /**
     * Loads the {@link SelectLevelSceneView}.
     */
    void selectLevel();
    /**
     * Loads the {@link SettingsSceneView}.
     */
    void settings();
    /**
     * Loads, if present, the next {@link it.unibo.pyxis.model.level.Level}.
     */
    void switchLevel();
}
