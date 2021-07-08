package it.unibo.pyxis.controller.controllers;

import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.view.views.View;

public abstract class AbstractController implements Controller {

    private Level level;
    private View view;

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
}
