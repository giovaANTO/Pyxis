package it.unibo.pyxis.view.views;

import it.unibo.pyxis.controller.controllers.SelectLevelSceneController;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public final class SelectLevelSceneView  extends AbstractJavaFXView<SelectLevelSceneController> {

    @FXML
    private StackPane stackPane;
    @FXML
    private HBox hBox;
    private int numLevel = 7;

    public SelectLevelSceneView(final SelectLevelSceneController inputController) {
        super(inputController);
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {

        final GridPane gridPane = new GridPane();
        this.hBox.prefWidthProperty().bind(stackPane.prefWidthProperty());
        this.hBox.prefHeightProperty().bind(stackPane.prefHeightProperty());

        final int col = (int) Math.ceil(Math.sqrt(this.numLevel));

        int countX = 0;
        int countY = 0;

        for (int i = 0; i < this.numLevel; i++) {
            final Button butt = new Button(String.valueOf(i + 1));
            butt.setOnAction(event -> {
                this.getLevel(Integer.parseInt(butt.getText()));
            });
            gridPane.add(butt, countY, countX, 1, 1);
            countY = countY == col - 1 ? 0 : countY + 1;
            countX = countY == 0 ? countX + 1 : countX;
        }

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        this.hBox.getChildren().add(gridPane);
        this.hBox.fillHeightProperty();
        StackPane.setAlignment(this.hBox, Pos.CENTER);
    }

    public void getLevel(final int level) { }
}
