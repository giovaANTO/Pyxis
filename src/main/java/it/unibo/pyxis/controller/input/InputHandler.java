package it.unibo.pyxis.controller.input;

import it.unibo.pyxis.controller.linker.Linker;
import javafx.stage.Stage;

public interface InputHandler {

    void bindCommands(Linker linker, Stage stage);
}
