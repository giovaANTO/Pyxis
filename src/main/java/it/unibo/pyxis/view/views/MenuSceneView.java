package it.unibo.pyxis.view.views;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MenuSceneView extends ViewImpl {

    @FXML
    private AnchorPane menuPane;
    @FXML
    private Button newGameButton, settingsButton, levelsButton, quitButton;
    @FXML
    private ImageView menuImageView;

    @Override
    public void init() {
        
    }
}
