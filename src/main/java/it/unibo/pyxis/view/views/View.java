package it.unibo.pyxis.view.views;

import it.unibo.pyxis.controller.controllers.Controller;
import it.unibo.pyxis.model.level.Level;

public interface View {

    Controller getController();

    void setController(Controller controller);

    void init();

    void render(Level level);
}
