package it.unibo.pyxis.controller;

import it.unibo.pyxis.model.state.StateEnum;
import it.unibo.pyxis.view.MenuSceneView;
import it.unibo.pyxis.view.PauseSceneView;

public class SettingsSceneController extends AbstractController {
    /**
     * Loads the {@link PauseSceneView} if the
     * {@link it.unibo.pyxis.model.state.GameState}'s {@link StateEnum} is PAUSE,
     * otherwise load the {@link MenuSceneView}.
     */
    public final void back() {
        if (this.getLinker().getGameState().getState() == StateEnum.PAUSE) {
            this.getLinker().pause();
        } else {
            this.getLinker().menu();
        }
    }
}
