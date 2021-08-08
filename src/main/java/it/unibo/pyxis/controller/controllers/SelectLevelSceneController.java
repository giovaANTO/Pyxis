package it.unibo.pyxis.controller.controllers;

public class SelectLevelSceneController extends AbstractController {
    /**
     * Loads the {@link it.unibo.pyxis.view.views.MenuSceneView}.
     */
    public final void back() {
        this.getLinker().menu();
    }
    /**
     * Returns the current maximum {@link it.unibo.pyxis.model.level.Level} reached.
     *
     * @return The maximum {@link it.unibo.pyxis.model.level.Level} reached.
     */
    public final int getLevelsDone() {
        return this.getLinker().getMaximumLevelReached();
    }
    /**
     * Returns the {@link it.unibo.pyxis.model.level.Level}'s count.
     *
     * @return The count.
     */
    public final int getTotalLevels() {
        return this.getLinker().getGameState().getLevelIterator().size();
    }
    /**
     * Loads the {@link it.unibo.pyxis.view.views.GameSceneView} with the selected
     * {@link it.unibo.pyxis.model.level.Level}.
     *
     * @param inputLevel The index of the {@link it.unibo.pyxis.model.level.Level}
     *                   to load.
     */
    public final void runLevel(final int inputLevel) {
        this.getLinker().getGameState().selectStartingLevel(inputLevel);
        this.getLinker().run();
    }

}
