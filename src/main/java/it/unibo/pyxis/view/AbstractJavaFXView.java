package it.unibo.pyxis.view;

import it.unibo.pyxis.controller.Controller;
import it.unibo.pyxis.controller.soundplayer.Sound;
import it.unibo.pyxis.controller.soundplayer.SoundPlayer;
import javafx.fxml.Initializable;

public abstract class AbstractJavaFXView<C extends Controller> implements View<C>, Initializable {

    private C controller;

    public AbstractJavaFXView(final C inputController) {
        this.controller = inputController;
    }

    /**
     * Starts the {@link Sound} background music.
     *
     * @param backgroundMusic The {@link Sound} to play.
     */
    private void playBackgroundMusic(final Sound backgroundMusic) {
        SoundPlayer.playBackgroundMusic(backgroundMusic);
    }

    /**
     * Starts the {@link Sound} button sound effect.
     *
     * @param buttonSoundEffect The {@link Sound} to play.
     */
    private void playButtonSoundEffect(final Sound buttonSoundEffect) {
        SoundPlayer.playSoundEffect(buttonSoundEffect);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final C getController() {
        return this.controller;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final void setController(final C inputController) {
        this.controller = inputController;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final void playGenericButtonPressSound() {
        this.playButtonSoundEffect(Sound.GENERIC_BUTTON);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final void playInGameMusic() {
        this.playBackgroundMusic(Sound.IN_GAME_MUSIC);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final void playMainMenuMusic() {
        this.playBackgroundMusic(Sound.MENU_MUSIC);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final void playStartGameButtonPressSound() {
        this.playButtonSoundEffect(Sound.START_GAME_BUTTON);
    }
}
