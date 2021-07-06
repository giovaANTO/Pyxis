package it.unibo.pyxis.view.views;

import it.unibo.pyxis.view.controllers.Controller;

public abstract class ViewImpl implements View {

    private Controller controller;

    @Override
    public Controller getController() {
        return this.controller;
    }

    @Override
    public void setController(final Controller inputController) {
        this.controller = inputController;
    }
}
