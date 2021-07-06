package it.unibo.pyxis.view.viewimpl;

import it.unibo.pyxis.view.Controller;

public interface View {

    Controller getController();

    void setController(Controller controller);

    void init();
}
