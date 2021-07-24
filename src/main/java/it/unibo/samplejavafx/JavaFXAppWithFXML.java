package it.unibo.samplejavafx;

import it.unibo.pyxis.controller.linker.Linker;
import it.unibo.pyxis.controller.linker.LinkerImpl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXAppWithFXML extends Application {

    @Override
    public final void start(final Stage primaryStage) throws Exception {
        Linker linker = new LinkerImpl(primaryStage);
        linker.start();
    }

    public static void run(final String[] args) {
        launch(args);
    }

    public static final class Main {
        private Main() {
            // the constructor will never be called directly.
        }

        public static void main(final String... args) {
            JavaFXAppWithFXML.run(args);
        }
    }

    static class AnotherStage extends Stage {
        private static final int SCENE_WIDTH = 100;
        private static final int SCENE_HEIGHT = 500;

        AnotherStage() {
            super();
            setTitle("New stage created at " + System.currentTimeMillis());
            final VBox pane = new VBox();
            pane.getChildren().add(new Label("First label"));
            pane.getChildren().add(new Label("Second label"));
            setScene(new Scene(pane, SCENE_WIDTH, SCENE_HEIGHT));
        }
    }
}
