package it.unibo.pyxis.controller.controllers;

import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.controller.linker.Linker;
import it.unibo.pyxis.view.views.View;

public interface Controller {

    Level getLevel();

    void setLevel(Level level);

    View<? extends Controller> getView();

    void setView(View<? extends  Controller>  view);

    void setLinker(Linker linker);

    Linker getLinker();
}
