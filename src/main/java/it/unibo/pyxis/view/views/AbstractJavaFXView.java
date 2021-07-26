package it.unibo.pyxis.view.views;

import it.unibo.pyxis.controller.controllers.Controller;
import javafx.fxml.Initializable;

public abstract class AbstractJavaFXView<C extends Controller> implements View<C>, Initializable {

    private C controller;

    public AbstractJavaFXView(final C inputController) {
        this.controller = inputController;
    }

    @Override
    public final C getController() {
        return this.controller;
    }

    @Override
    public final void setController(final C inputController) {
        this.controller = inputController;
    }

    @Override
    public void render() { }
}
