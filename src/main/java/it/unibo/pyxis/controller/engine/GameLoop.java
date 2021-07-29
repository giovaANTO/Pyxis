package it.unibo.pyxis.controller.engine;

import it.unibo.pyxis.controller.command.Command;
import it.unibo.pyxis.model.level.Level;

public interface GameLoop {
    /**
     * Process the next command sent by the user to the application.
     */
    void processInput();

    /**
     * Start the game loop.
     */
    void start();

    /**
     * Add a command in the queue.
     * @param command
     *                The command to add in the queue.
     */
    void addCommand(Command<Level> command);
}
