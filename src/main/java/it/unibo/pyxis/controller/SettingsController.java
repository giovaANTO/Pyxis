package it.unibo.pyxis.controller;

import it.unibo.pyxis.model.state.StateEnum;

public class SettingsController extends AbstractController {
    /**
     * Loads the {@link it.unibo.pyxis.view.PauseView} if the
     * {@link it.unibo.pyxis.model.state.GameState}'s {@link StateEnum} is PAUSE,
     * otherwise load the {@link it.unibo.pyxis.view.MenuView}.
     */
    public final void back() {
        if (this.getLinker().getGameState().getState() == StateEnum.PAUSE) {
            this.getLinker().pause();
        } else {
            this.getLinker().menu();
        }
    }
}
