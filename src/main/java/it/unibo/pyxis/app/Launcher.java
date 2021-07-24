package it.unibo.pyxis.app;

import it.unibo.pyxis.controller.linker.Linker;
import it.unibo.pyxis.controller.linker.LinkerImpl;
import javafx.application.Application;
import javafx.stage.Stage;

public final class Launcher extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {
        Linker linker = new LinkerImpl(primaryStage);
        linker.start();
    }

    public static void run(final String[] args) {
        launch(args);
    }
}
