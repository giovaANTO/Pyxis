package it.unibo.pyxis.controller.controllers;

import it.unibo.pyxis.controller.linker.Linker;
import it.unibo.pyxis.view.views.View;

public interface Controller {
    /**
     * Return the instance of {@link Linker}.
     * @return The {@link Linker}
     */
    Linker getLinker();
    /**
     * Return the {@link View} binded to the {@link Controller}.
     * @return The {@link View}.
     */
    View<? extends Controller> getView();
    /**
     * Set the instance of the {@link Linker}.
     * @param linker
     *          The {@link Linker} to set.
     */
    void setLinker(Linker linker);
    /**
     * Bind the {@link View} to the {@link Controller}.
     * @param view
     *          The {@link View} to bind.
     */
    void setView(View<? extends  Controller>  view);
}
