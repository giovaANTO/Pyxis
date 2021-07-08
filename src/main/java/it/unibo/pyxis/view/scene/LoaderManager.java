package it.unibo.pyxis.view.scene;

import it.unibo.pyxis.model.level.Level;
import javafx.stage.Stage;

public interface LoaderManager {

    void setInstance(Stage stage, Level level);

    SceneLoader getInstance();
}
