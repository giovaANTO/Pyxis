package it.unibo.pyxis.controller.controllers;

import it.unibo.pyxis.controller.linker.Linker;
import it.unibo.pyxis.view.views.View;

public abstract class AbstractController implements Controller {

    private View<?> view;
    private Linker linker;

    @Override
    public final Linker getLinker() {
        return this.linker;
    }
    @Override
    public final View<? extends Controller> getView() {
        return this.view;
    }
    @Override
    public final void setLinker(final Linker inputLinker) {
        this.linker = inputLinker;
    }
    @Override
    public final void setView(final View<? extends  Controller> inputView) {
        this.view = inputView;
    }
}
