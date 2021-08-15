package it.unibo.pyxis.app;

import it.unibo.pyxis.view.input.InputHandler;
import it.unibo.pyxis.view.input.InputHandlerImpl;
import it.unibo.pyxis.controller.linker.Linker;
import it.unibo.pyxis.controller.linker.LinkerImpl;
import it.unibo.pyxis.view.scene.SceneHandler;
import it.unibo.pyxis.view.scene.SceneHandlerImpl;
import javafx.application.Application;
import javafx.stage.Stage;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public final class Launcher extends Application {

    private static final double WINDOW_SCALE_FACTOR = 2;

    @Override
    public void start(final Stage primaryStage) throws Exception {
        final GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        final float width = gd.getDisplayMode().getWidth();
        final float height = gd.getDisplayMode().getHeight();
        primaryStage.setHeight(height / WINDOW_SCALE_FACTOR);
        primaryStage.setWidth(width / WINDOW_SCALE_FACTOR);
        final Linker linker = new LinkerImpl();
        final InputHandler inputHandler = new InputHandlerImpl();
        inputHandler.bindCommands(linker, primaryStage);
        final SceneHandler sceneHandler = new SceneHandlerImpl(primaryStage, linker);
        linker.setSceneHandler(sceneHandler);
        linker.menu();
    }

    public static void run(final String[] args) {
        launch(args);
    }
}
