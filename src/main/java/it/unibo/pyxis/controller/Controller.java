package it.unibo.pyxis.controller;

import it.unibo.pyxis.controller.linker.Linker;
import it.unibo.pyxis.view.View;

public interface Controller {
    /**
     * Returns the instance of {@link Linker}.
     *
     * @return The {@link Linker}
     */
    Linker getLinker();
    /**
     * Returns the {@link View} bound to the {@link Controller}.
     *
     * @return The {@link View}.
     */
    View<? extends Controller> getView();
    /**
     * Sets the instance of the {@link Linker}.
     *
     * @param linker The {@link Linker} to set.
     */
    void setLinker(Linker linker);
    /**
     * Binds the {@link View} to the {@link Controller}.
     *
     * @param view The {@link View} to bind.
     */
    void setView(View<? extends  Controller>  view);
}
