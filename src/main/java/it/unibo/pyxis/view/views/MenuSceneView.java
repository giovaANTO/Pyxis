package it.unibo.pyxis.view.views;

import it.unibo.pyxis.controller.controllers.MenuSceneController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuSceneView extends AbstractView {

    @FXML
    private AnchorPane menuPane;
    @FXML
    private Button newGameButton, settingsButton, levelsButton, quitButton;
    @FXML
    private ImageView menuImageView;

    @Override
    public final void init() {
    }

    public final void startNewGame() {
        System.out.println("Start new game");
        MenuSceneController controller = (MenuSceneController) this.getController();
        controller.startNewGame();
    }
    public final void showSettings() {
        System.out.println("See settings");
        MenuSceneController controller = (MenuSceneController) this.getController();
        controller.showSettings();
    }
    public final void selectLevels() {
        System.out.println("Choose levels");
        MenuSceneController controller = (MenuSceneController) this.getController();
        controller.selectLevel();
    }
    public final void quit() {
        System.out.println("Quitting");
        MenuSceneController controller = (MenuSceneController) this.getController();
        controller.quit();
    }


}
