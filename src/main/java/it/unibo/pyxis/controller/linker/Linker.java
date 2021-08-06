package it.unibo.pyxis.controller.linker;

import it.unibo.pyxis.controller.command.Command;
import it.unibo.pyxis.model.state.GameState;

public interface Linker {
    /**
     * Set the {@link GameState}'s {@link it.unibo.pyxis.model.state.StateEnum} to
     * pause and load the {@link it.unibo.pyxis.view.views.EndLevelSceneView}.
     */
    void endLevel();

    /**
     * Return the instance of {@link GameState}.
     * @return
     *          The {@link GameState}.
     */
    GameState getGameState();

    /**
     * Return the maximum level reached by the player during the actual game session.
     * @return
     *          The index of the maximum level.
     */
    int getMaximumLevelReached();

    /**
     * Add a {@link Command} to the list of commands that a player can input.
     * @param levelCommand
     *          The {@link Command} to add.
     */
    void insertCommand(Command<GameState> levelCommand);

    /**
     * Load the {@link it.unibo.pyxis.view.views.MenuSceneView}.
     */
    void menu();

    /**
     * Load the {@link it.unibo.pyxis.view.views.PauseSceneView} and
     * set the {@link GameState}'s {@link it.unibo.pyxis.model.state.StateEnum}
     * to pause.
     */
    void pause();

    /**
     * Close the application.
     */
    void quit();

    /**
     * Render the current {@link it.unibo.pyxis.view.views.View} if
     * {@link it.unibo.pyxis.view.views.RenderableView}.
     */
    void render();

    /**
     * Resume a paused {@link GameState}.
     */
    void resume();

    /**
     * Load the {@link it.unibo.pyxis.view.views.GameSceneView}.
     */
    void run();

    /**
     * Load the {@link it.unibo.pyxis.view.views.SelectLevelSceneView}.
     */
    void selectLevel();

    /**
     * Load the {@link it.unibo.pyxis.view.views.SettingsSceneView}.
     */
    void settings();

    /**
     * Load, if present, the next {@link it.unibo.pyxis.model.level.Level}.
     */
    void switchLevel();
}
