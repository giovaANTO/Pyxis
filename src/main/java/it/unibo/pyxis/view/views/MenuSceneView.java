package it.unibo.pyxis.view.views;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuSceneView extends ViewImpl {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private AnchorPane menuPane;
    @FXML
    private Button newGameButton, settingsButton, levelsButton, quitButton;
    @FXML
    private ImageView menuImageView;

    @Override
    public void init() {
        this.stage = new Stage();
        try {
            this.root = FXMLLoader.load(ClassLoader.
                    getSystemResource("layouts/scenebuilder/MenuScene.fxml"));
            this.scene = new Scene(this.root);
            this.stage.setTitle("Pyxis");
            this.stage.setScene(this.scene);
            this.stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
