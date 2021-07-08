package it.unibo.pyxis.view.views;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuSceneView extends AbstractView {

    @FXML
    private AnchorPane menuPane;
    @FXML
    private Button newGameButton, settingsButton, levelsButton, quitButton;
    @FXML
    private ImageView menuImageView;

    @Override
    public void init() {

    }
    public final void startNewGame() {
        System.out.println("Start new game");
    }
    public final void showSettings() {
        System.out.println("See settings");
    }
    public final void selectLevels() {
        System.out.println("Choose levels");
    }
    public final void quit() {
        System.out.println("Quitting");
    }
}
