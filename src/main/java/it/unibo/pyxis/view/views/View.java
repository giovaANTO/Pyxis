package it.unibo.pyxis.view.views;

import it.unibo.pyxis.controller.controllers.Controller;

public interface View {

    Controller getController();

    void setController(Controller controller);

    void render();
}
