package it.unibo.pyxis.controller.controllers;

import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.view.linker.Linker;
import it.unibo.pyxis.view.views.View;

public abstract class AbstractController implements Controller {

    private Level level;
    private View view;
    private Linker linker;

    @Override
    public final Level getLevel() {
        return this.level;
    }

    @Override
    public final void setLevel(final Level inputLevel) {
        this.level = inputLevel;
    }

    @Override
    public final View getView() {
        return this.view;
    }

    @Override
    public final void setView(final View inputView) {
        this.view = inputView;
    }

    @Override
    public final void setLinker(final Linker inputLinker) {
        this.linker = inputLinker;
    }

    @Override
    public final Linker getLinker() {
        return linker;
    }
}
