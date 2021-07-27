package it.unibo.pyxis.view.views;

import it.unibo.pyxis.controller.controllers.SelectLevelSceneController;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.io.File;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public final class SelectLevelSceneView  extends AbstractJavaFXView<SelectLevelSceneController> {

    @FXML
    private StackPane mainPane;
    @FXML
    private HBox hBox;

    private final int numLevel = 24;
    private final int levelsDone = 0;
    private static final String SEPARATOR = File.separator;
    private static final String STARTING_PATH = "images" + SEPARATOR;
    private static final String LOCKER_PATH = STARTING_PATH + "Lucchetto.png";

    public SelectLevelSceneView(final SelectLevelSceneController inputController) {
        super(inputController);
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {

        GridPane gridPane = new GridPane();

        this.hBox.prefWidthProperty().bind(this.mainPane.prefWidthProperty());
        this.hBox.prefHeightProperty().bind(this.mainPane.prefHeightProperty());

        int col = (int) Math.ceil(Math.sqrt(this.numLevel));

        int countX = 0;
        int countY = 0;

        for (int i = 0; i < this.numLevel; i++) {
            Button butt = new Button(String.valueOf(i + 1));
            butt.setOnAction(event -> {
                this.getLevel(Integer.parseInt(butt.getText()));
            });
            butt.setPrefHeight(this.mainPane.getPrefHeight());
            butt.setPrefWidth(this.mainPane.getPrefWidth());
            if (i > this.levelsDone) {
                butt.setDisable(true);
                Image img = new Image(Objects.requireNonNull(
                        ClassLoader.getSystemResourceAsStream(LOCKER_PATH)));
                ImageView imgvw = new ImageView(img);
                butt.setGraphic(imgvw);
            }
            gridPane.add(butt, countY, countX, 1, 1);
            countY = countY == col - 1 ? 0 : countY + 1;
            if (countY == 0) {
                countX++;
            }
        }

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        this.hBox.getChildren().add(gridPane);
        StackPane.setAlignment(this.hBox, Pos.CENTER);

    }

    public void getLevel(final int level) {

    }

    public void back() {
        this.getController().back();
    }

}
