package it.unibo.pyxis.view.views;

import it.unibo.pyxis.controller.controllers.MenuSceneController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

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
        MenuSceneController controller = (MenuSceneController) this.getController();
        controller.startNewGame();
    }
    public final void showSettings() {
        MenuSceneController controller = (MenuSceneController) this.getController();
        controller.showSettings();
    }
    public final void selectLevels() {
        MenuSceneController controller = (MenuSceneController) this.getController();
        controller.selectLevel();
    }
    public final void quit() {
        MenuSceneController controller = (MenuSceneController) this.getController();
        controller.quit();
    }
}
