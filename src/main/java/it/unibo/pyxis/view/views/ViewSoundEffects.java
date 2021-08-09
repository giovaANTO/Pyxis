package it.unibo.pyxis.view.views;

public interface ViewSoundEffects {
    /**
     * Play the {@link it.unibo.pyxis.controller.soundplayer.Sound} of a pushed
     * {@link javafx.scene.control.Button}.
     */
    void playGenericButtonPressSound();
    /**
     * Play the {@link it.unibo.pyxis.controller.soundplayer.Sound} of the
     * {@link GameSceneView}.
     */
    void playInGameMusic();
    /**
     * Play the {@link it.unibo.pyxis.controller.soundplayer.Sound} of the
     * {@link MenuSceneView}.
     */
    void playMainMenuMusic();
    /**
     * Play the {@link it.unibo.pyxis.controller.soundplayer.Sound} of a pushed
     * start game {@link javafx.scene.control.Button}.
     */
    void playStartGameButtonPressSound();
}
