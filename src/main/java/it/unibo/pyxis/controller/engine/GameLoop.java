package it.unibo.pyxis.controller.engine;

import it.unibo.pyxis.controller.command.Command;
import it.unibo.pyxis.model.level.Level;

public interface GameLoop {
    /**
     * Adds a command in the queue.
     *
     * @param command The command to add in the queue.
     */
    void addCommand(Command<Level> command);

    /**
     * Processes the next command sent by the user to the application.
     */
    void processInput();

    /**
     * Refreshes the current graphic view drawing the {@link it.unibo.pyxis.model.element.Element}
     * Objects of the model.
     */
    void render();

    /**
     * Starts the game loop.
     */
    void start();

    /**
     * Updates the game model passing the elapsed time between two game loop's cycles.
     *
     * @param elapsed The elapsed time.
     */
    void update(double elapsed);
}
