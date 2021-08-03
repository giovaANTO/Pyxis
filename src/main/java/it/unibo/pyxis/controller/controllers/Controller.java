package it.unibo.pyxis.controller.controllers;

import it.unibo.pyxis.controller.linker.Linker;
import it.unibo.pyxis.view.views.View;

public interface Controller {
    /**
     * Return the {@link View} binded to the {@link Controller}.
     * @return The {@link View}.
     */
    View<? extends Controller> getView();

    /**
     * Bind the {@link View} to the {@link Controller}.
     * @param view
     *          The {@link View} to bind.
     */
    void setView(View<? extends  Controller>  view);
    
    void setLinker(Linker linker);

    Linker getLinker();
}
