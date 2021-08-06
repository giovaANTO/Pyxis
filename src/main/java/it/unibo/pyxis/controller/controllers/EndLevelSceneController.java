package it.unibo.pyxis.controller.controllers;

import it.unibo.pyxis.model.level.status.LevelStatus;

public class EndLevelSceneController extends AbstractController {

    public final boolean disableNextLevelButton() {
        return this.getLinker().getGameState().getCurrentLevel().getLevelStatus()
                != LevelStatus.SUCCESSFULLY_COMPLETED
                    || !this.getLinker().getGameState().getLevelIterator().hasNext();
    }

    public final void menu() {
        this.getLinker().menu();
    }

    public final void nextLevel() {
        this.getLinker().switchLevel();
    }

    public final Integer getScore() {
        return this.getLinker().getGameState().getScore();
    }
}
