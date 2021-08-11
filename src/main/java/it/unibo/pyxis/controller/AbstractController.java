package it.unibo.pyxis.controller;

import it.unibo.pyxis.controller.linker.Linker;
import it.unibo.pyxis.view.View;

public abstract class AbstractController implements Controller {

    private View<?> view;
    private Linker linker;

    /**
     * {@inheritDoc}
     */
    @Override
    public final Linker getLinker() {
        return this.linker;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final View<? extends Controller> getView() {
        return this.view;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final void setLinker(final Linker inputLinker) {
        this.linker = inputLinker;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final void setView(final View<? extends Controller> inputView) {
        this.view = inputView;
    }
}
