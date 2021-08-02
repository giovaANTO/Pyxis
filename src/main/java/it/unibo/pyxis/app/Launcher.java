package it.unibo.pyxis.app;

import it.unibo.pyxis.controller.linker.Linker;
import it.unibo.pyxis.controller.linker.LinkerImpl;
import javafx.application.Application;
import javafx.stage.Stage;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public final class Launcher extends Application {

    private static final double WINDOW_SCALE_FACTOR = 1.1;

    @Override
    public void start(final Stage primaryStage) throws Exception {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        float width = gd.getDisplayMode().getWidth();
        float height = gd.getDisplayMode().getHeight();
        primaryStage.setHeight(height / WINDOW_SCALE_FACTOR);
        primaryStage.setWidth(width / WINDOW_SCALE_FACTOR);
        Linker linker = new LinkerImpl(primaryStage);
    }

    public static void run(final String[] args) {
        launch(args);
    }
}
