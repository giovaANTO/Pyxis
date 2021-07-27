package it.unibo.pyxis.view.views;

import it.unibo.pyxis.controller.controllers.SelectLevelSceneController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public final class SelectLevelSceneView  extends AbstractJavaFXView<SelectLevelSceneController> {

    @FXML
    private AnchorPane mainPane;

    public SelectLevelSceneView(final SelectLevelSceneController inputController) {
        super(inputController);
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        List<Button> levelButtons = new ArrayList<>();
        for (Node node: this.mainPane.getChildren()) {
            if (node instanceof Button) {
                levelButtons.add((Button) node);
            }
        }
        double propX = Math.ceil(Math.sqrt(levelButtons.size()));
        double propY = Math.floor(Math.sqrt(levelButtons.size()));
        int countX = 1;
        int countY = 1;
        for (int i = 0; i < levelButtons.size(); i++) {
            levelButtons.get(i).setLayoutX(this.mainPane.getPrefWidth() * (countX / propX));
            levelButtons.get(i).setLayoutY(this.mainPane.getPrefHeight() * (countY / propY));
            countX = countX + 1 == (int) propX + 1 ? 1 : countX + 1;
            if (countX == 1) {
                countY++;
            }
        }
    }

    public void back() {
        this.getController().back();
    }

    public void level1() { }
    public void level2() { }
    public void level3() { }
    public void level4() { }
    public void level5() { }
    public void level6() { }
    public void level7() { }
    public void level8() { }
    public void level9() { }
}
