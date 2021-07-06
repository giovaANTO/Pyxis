package it.unibo.pyxis.view;

import it.unibo.pyxis.view.viewimpl.View;

public interface Controller {

    Model getModel();

    void setModel(Model model);

    View getView();

    void setView(View view);
}
