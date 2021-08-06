package it.unibo.pyxis.view.views;

import it.unibo.pyxis.controller.controllers.SelectLevelSceneController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public final class SelectLevelSceneView  extends AbstractJavaFXView<SelectLevelSceneController> {

    @FXML
    private AnchorPane mainPane;
    @FXML
    private Button backButton;

    private int numLevel;
    private int levelsDone;

    public SelectLevelSceneView(final SelectLevelSceneController inputController) {
        super(inputController);
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {

        this.numLevel = this.getController().getTotalLevels();
        this.levelsDone = this.getController().getLevelsDone();

        GridPane gridPane = this.populateButton();

        this.mainPane.getChildren().add(gridPane);

        AnchorPane.setRightAnchor(gridPane, 0.0);
        AnchorPane.setLeftAnchor(gridPane, 0.0);
        AnchorPane.setBottomAnchor(gridPane, 0.0);
        AnchorPane.setTopAnchor(gridPane, this.backButton.getPrefHeight() + 10);

        gridPane.setHgap(10);
        gridPane.setVgap(10);
    }

    private GridPane populateButton() {

        GridPane gridPane = new GridPane();
        final int col = (int) Math.ceil(Math.sqrt(this.numLevel));
        int countX = 0;
        int countY = 0;
        for (int i = 1; i <= this.numLevel; i++) {
            final Button butt = new Button(String.valueOf(i));
            butt.setOnAction(event -> {
                this.playGenericButtonPressSound();
                this.getLevel(Integer.parseInt(butt.getText()));
            });
            butt.setPrefHeight(this.mainPane.getPrefHeight());
            butt.setPrefWidth(this.mainPane.getPrefWidth());
            if (i > this.levelsDone) {
                butt.setDisable(true);
            }
            gridPane.add(butt, countY, countX, 1, 1);
            countY = countY == col - 1 ? 0 : countY + 1;
            if (countY == 0) {
                countX++;
            }
        }
        return gridPane;
    }

    public void getLevel(final int inputLevel) {
        this.playInGameMusic();
        this.getController().runLevel(inputLevel);
    }

    public void back() {
        this.playGenericButtonPressSound();
        this.getController().back();
    }

}
