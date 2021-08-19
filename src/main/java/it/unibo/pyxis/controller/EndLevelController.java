package it.unibo.pyxis.controller;

import it.unibo.pyxis.model.level.status.LevelStatus;

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
        final boolean notSuccessfullyCompleted = this.getLinker().getGameState().
                getCurrentLevel().getLevelStatus() != LevelStatus.SUCCESSFULLY_COMPLETED;
        final boolean iteratorHasNext = this.getLinker().getGameState().getLevelIterator().
                hasNext();
        return notSuccessfullyCompleted || !iteratorHasNext;
    }

    /**
     * Returns the {@link it.unibo.pyxis.model.state.GameState} score.
     *
     * @return The score.
     */
    public final Integer getTotalScore() {
        return this.getLinker().getGameState().getScore();
    }

    /**
     * Returns the {@link it.unibo.pyxis.model.state.GameState} score.
     *
     * @return The score.
     */
    public final Integer getLevelScore() {
        return this.getLinker().getGameState().getCurrentLevel().getScore();
    }

    /**
     * Returns true if the actual {@link it.unibo.pyxis.model.level.Level}'s
     * {@link LevelStatus} is SUCCESSFULLY_COMPLETED.
     *
     * @return True if {@link LevelStatus} is SUCCESSFULLY_COMPLETED.
     *         False otherwise.
     */
    public final boolean haveWon() {
        return this.getLinker().getGameState().getCurrentLevel().getLevelStatus() == LevelStatus.SUCCESSFULLY_COMPLETED;
    }

    /**
     * Loads the {@link it.unibo.pyxis.view.MenuView}.
     */
    public final void menu() {
        this.getLinker().menu();
    }

    /**
     * Loads the next {@link it.unibo.pyxis.model.level.Level}.
     */
    public final void nextLevel() {
        this.getLinker().switchLevel();
    }
}
