package it.unibo.pyxis.view.views;


import it.unibo.pyxis.controller.controllers.Controller;
import it.unibo.pyxis.model.level.Level;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class AbstractView implements View {

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
    public void render(final Level inputLevel) { }

}
