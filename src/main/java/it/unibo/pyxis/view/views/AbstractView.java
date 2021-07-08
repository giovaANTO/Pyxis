package it.unibo.pyxis.view.views;


import it.unibo.pyxis.controller.controllers.Controller;

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
}
