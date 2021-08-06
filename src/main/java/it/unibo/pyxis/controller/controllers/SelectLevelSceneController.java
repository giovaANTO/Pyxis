package it.unibo.pyxis.controller.controllers;

public class SelectLevelSceneController extends AbstractController {

    public final void back() {
        this.getLinker().menu();
    }
    public final int getLevelsDone() {
        return this.getLinker().getMaximumLevelReached();
    }
    public final int getTotalLevels() {
        return this.getLinker().getGameState().getLevelIterator().size();
    }
    public final void runLevel(final int inputLevel) {
        this.getLinker().getGameState().selectStartingLevel(inputLevel);
        this.getLinker().run();
    }

}
