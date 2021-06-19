package it.unibo.pyxis.controller.engine;

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
}
