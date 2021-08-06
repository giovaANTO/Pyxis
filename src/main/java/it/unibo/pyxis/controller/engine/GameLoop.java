package it.unibo.pyxis.controller.engine;

import it.unibo.pyxis.controller.command.Command;
import it.unibo.pyxis.model.level.Level;

public interface GameLoop {
    /**
     * Add a command in the queue.
     * @param command
     *                The command to add in the queue.
     */
    void addCommand(Command<Level> command);
    /**
     * Process the next command sent by the user to the application.
     */
    void processInput();
    /**
     * Refresh the current graphic view drawing the {@link it.unibo.pyxis.model.element.Element}
     * Objects of the model.
     */
    void render();
    /**
     * Start the game loop.
     */
    void start();
    /**
     * Update the game model passing the elapsed time between two game loop's cycles.
     * @param elapsed
     *                  Elapsed time.
     */
    void update(double elapsed);
}
