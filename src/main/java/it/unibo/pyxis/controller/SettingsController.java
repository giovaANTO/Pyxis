package it.unibo.pyxis.controller;

import it.unibo.pyxis.model.state.StateEnum;
import it.unibo.pyxis.view.MenuView;
import it.unibo.pyxis.view.PauseView;

public class SettingsController extends AbstractController {
    /**
     * Loads the {@link PauseView} if the
     * {@link it.unibo.pyxis.model.state.GameState}'s {@link StateEnum} is PAUSE,
     * otherwise load the {@link MenuView}.
     */
    public final void back() {
        if (this.getLinker().getGameState().getState() == StateEnum.PAUSE) {
            this.getLinker().pause();
        } else {
            this.getLinker().menu();
        }
    }
}
