package it.unibo.pyxis.controller.controllers;

import it.unibo.pyxis.model.state.StateEnum;

public class SettingsSceneController extends AbstractController {
    /**
     * Loads the {@link it.unibo.pyxis.view.views.PauseSceneView} if the
     * {@link it.unibo.pyxis.model.state.GameState}'s {@link StateEnum} is PAUSE,
     * otherwise load the {@link it.unibo.pyxis.view.views.MenuSceneView}.
     */
    public final void back() {
        if (this.getLinker().getGameState().getState() == StateEnum.PAUSE) {
            this.getLinker().pause();
        } else {
            this.getLinker().menu();
        }
    }
}
