package it.unibo.pyxis.view;

import java.net.URL;
import java.util.ResourceBundle;
import it.unibo.pyxis.controller.SettingsSceneController;
import it.unibo.pyxis.controller.soundplayer.SoundPlayer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.layout.StackPane;

public final class SettingsSceneView extends AbstractJavaFXView<SettingsSceneController> {

    @FXML
    private StackPane mainPane;
    @FXML
    private Slider backgroundSlider, soundEffectSlider;

    public SettingsSceneView(final SettingsSceneController inputController) {
        super(inputController);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        backgroundSlider.setValue(SoundPlayer.getBackgroundVolume());
        backgroundSlider.valueProperty().addListener(o -> SoundPlayer.setBackgroundVolume(backgroundSlider.getValue()));
        soundEffectSlider.setValue(SoundPlayer.getSoundEffectVolume());
        soundEffectSlider.valueProperty().addListener(o -> SoundPlayer.setSoundEffectVolume(soundEffectSlider.getValue()));
    }

    /**
     * Applies the {@link it.unibo.pyxis.controller.soundplayer.Sound} and calls the
     * {@link SettingsSceneController#back()}.
     */
    public void back() {
        this.playGenericButtonPressSound();
        this.getController().back();
    }

}
