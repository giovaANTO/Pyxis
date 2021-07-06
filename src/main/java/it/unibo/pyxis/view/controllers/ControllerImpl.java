package it.unibo.pyxis.view.controllers;

import it.unibo.pyxis.view.model.Model;
import it.unibo.pyxis.view.views.View;

public class ControllerImpl implements Controller {

    private Model model;
    private View view;

    ControllerImpl(final Model inputModel, final View inputView) {
        this.model = inputModel;
        this.view = inputView;
    }

    @Override
    public final Model getModel() {
        return this.model;
    }

    @Override
    public final void setModel(final Model inputModel) {
        this.model = inputModel;
    }

    @Override
    public final View getView() {
        return this.view;
    }

    @Override
    public final void setView(final View inputView) {
        this.view = inputView;
    }
}
