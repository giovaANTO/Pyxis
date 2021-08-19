package it.unibo.pyxis.view;

import it.unibo.pyxis.controller.Controller;

public interface View<C extends Controller> {
    /**
     * Return the {@link Controller} bound to the {@link View}.
     *
     * @return The {@link Controller}.
     */
    C getController();

    /**
     * Bound the {@link Controller} to the {@link View}.
     *
     * @param controller The {@link Controller} to bind.
     */
    void setController(C controller);

    /**
     * Play the {@link it.unibo.pyxis.view.soundplayer.Sound} of a pushed
     * {@link javafx.scene.control.Button}.
     */
    void playGenericButtonPressSound();

    /**
     * Play the {@link it.unibo.pyxis.view.soundplayer.Sound} of the
     * {@link GameView}.
     */
    void playInGameMusic();

    /**
     * Play the {@link it.unibo.pyxis.view.soundplayer.Sound} of the
     * {@link MenuView}.
     */
    void playMainMenuMusic();

    /**
     * Play the {@link it.unibo.pyxis.view.soundplayer.Sound} of a pushed
     * start game {@link javafx.scene.control.Button}.
     */
    void playStartGameButtonPressSound();
}
