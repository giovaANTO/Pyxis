package it.unibo.pyxis.view.views;

import it.unibo.pyxis.controller.controllers.Controller;

public interface View<C extends Controller> extends ViewSoundEffects {

    C getController();

    void setController(C controller);

}
