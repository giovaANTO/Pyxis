package it.unibo.pyxis.view.views;

@FunctionalInterface
public interface RenderableView {
    /**
     * Update all the {@link View}'s components.
     */
    void render();
}
