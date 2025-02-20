package it.unibo.pyxis.view.input;

import it.unibo.pyxis.controller.linker.Linker;
import javafx.stage.Stage;

public interface InputHandler {
    /**
     * Defines all the commands that the application can handle.
     *
     * @param linker The {@link Linker} to apply the effects.
     * @param stage The {@link Stage} to capture {@link javafx.scene.input.KeyEvent}.
     */
    void bindCommands(Linker linker, Stage stage);
}
