package it.unibo.pyxis.controller.engine;

import it.unibo.pyxis.controller.command.Command;
import it.unibo.pyxis.model.level.Level;

public interface GameLoop {
    /**
     * Refresh the current graphic view drawing the {@link it.unibo.pyxis.model.element.Element}
     * Objects of the model.
     */
    void render();

    /**
     * Update the game model passing the elapsed time between two game loop's cycles.
     * @param elapsed
     *                  Elapsed time.
     */
    void update(double elapsed);

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
