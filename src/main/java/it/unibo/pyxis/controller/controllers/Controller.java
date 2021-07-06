package it.unibo.pyxis.controller.controllers;

import it.unibo.pyxis.view.model.Model;
import it.unibo.pyxis.view.views.View;

public interface Controller {

    Model getModel();

    void setModel(Model model);

    View getView();

    void setView(View view);
}
