package it.unibo.pyxis.view.views;

import it.unibo.pyxis.controller.controllers.Controller;
import javafx.fxml.Initializable;

public abstract class AbstractJavaFXView implements View, Initializable {

    private Controller controller;

    @Override
    public final Controller getController() {
        return this.controller;
    }

    @Override
    public final void setController(final Controller inputController) {
        this.controller = inputController;
    }

    @Override
    public void render() { }
}
