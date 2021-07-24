package it.unibo.pyxis.view.views;

import it.unibo.pyxis.controller.controllers.Controller;
import javafx.fxml.Initializable;

public interface View extends Initializable {

    Controller getController();

    void setController(Controller controller);

    void render();
}
