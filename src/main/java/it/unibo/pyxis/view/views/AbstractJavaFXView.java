package it.unibo.pyxis.view.views;

import it.unibo.pyxis.controller.controllers.Controller;
import it.unibo.pyxis.controller.soundplayer.Sound;
import it.unibo.pyxis.controller.soundplayer.SoundPlayer;
import javafx.fxml.Initializable;

public abstract class AbstractJavaFXView<C extends Controller> implements View<C>, Initializable {

    private C controller;

    private void playButtonSoundEffect(final Sound buttonSoundEffect) {
        SoundPlayer.playSoundEffect(buttonSoundEffect);
    }

    private void playBackgroundMusic(final Sound backgroundMusic) {
        SoundPlayer.playBackgroundMusic(backgroundMusic);
    }

    public AbstractJavaFXView(final C inputController) {
        this.controller = inputController;
    }

    @Override
    public final C getController() {
        return this.controller;
    }

    @Override
    public final void setController(final C inputController) {
        this.controller = inputController;
    }

    @Override
    public final void playStartGameButtonPressSound() {
        this.playButtonSoundEffect(Sound.START_GAME_BUTTON);
    }

    @Override
    public final void playGenericButtonPressSound() {
        this.playButtonSoundEffect(Sound.GENERIC_BUTTON);
    }

    @Override
    public final void playMainMenuMusic() {
        this.playBackgroundMusic(Sound.MENU_MUSIC);
    }

    @Override
    public final void playInGameMusic() {
        this.playBackgroundMusic(Sound.IN_GAME_MUSIC);
    }
}
