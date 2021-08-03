package it.unibo.pyxis.controller.controllers;

import it.unibo.pyxis.model.state.StateEnum;

public class SettingsSceneController extends AbstractController {

    public final void back() {
        if (this.getLinker().getGameState().getState() == StateEnum.PAUSE) {
            this.getLinker().pause();
        } else {
            this.getLinker().menu();
        }
    }

}
