package it.unibo.pyxis.view.viewimpl;

import it.unibo.pyxis.view.Controller;

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
