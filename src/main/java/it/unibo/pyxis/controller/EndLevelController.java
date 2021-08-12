package it.unibo.pyxis.controller;

import it.unibo.pyxis.model.level.status.LevelStatus;
import it.unibo.pyxis.view.MenuSceneView;

public class EndLevelController extends AbstractController {

    /**
     * Establishes if the next level button has to be disabled.
     *
     * @return True if {@link LevelStatus} is not SUCCESSFULLY_COMPLETED or
     *         {@link it.unibo.pyxis.model.level.iterator.LevelIterator} hasn't next
     *         {@link it.unibo.pyxis.model.level.Level}.
     *         False otherwise.
     */
    public final boolean disableNextLevelButton() {
        return this.getLinker().getGameState().getCurrentLevel().getLevelStatus()
                != LevelStatus.SUCCESSFULLY_COMPLETED
                    || !this.getLinker().getGameState().getLevelIterator().hasNext();
    }
    /**
     * Returns the {@link it.unibo.pyxis.model.state.GameState} score.
     *
     * @return The score.
     */
    public final Integer getScore() {
        return this.getLinker().getGameState().getScore();
    }
    /**
     * Loads the {@link MenuSceneView}.
     */
    public final void menu() {
        this.getLinker().menu();
    }
    /**
     * Loads the next level.
     */
    public final void nextLevel() {
        this.getLinker().switchLevel();
    }
}
