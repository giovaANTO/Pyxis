package it.unibo.pyxis.view;

import java.net.URL;
import java.util.ResourceBundle;
import it.unibo.pyxis.controller.SettingsController;
import it.unibo.pyxis.view.soundplayer.SoundPlayer;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.layout.StackPane;

public final class SettingsView extends AbstractJavaFXView<SettingsController> {

    @FXML
    private StackPane mainPane;
    @FXML
    private Slider backgroundSlider, soundEffectSlider;

    public SettingsView(final SettingsController inputController) {
        super(inputController);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        this.backgroundSlider.setValue(SoundPlayer.getBackgroundVolume());
        this.backgroundSlider.valueProperty().addListener(o -> SoundPlayer.setBackgroundVolume(this.backgroundSlider.getValue()));
        this.soundEffectSlider.setValue(SoundPlayer.getSoundEffectVolume());
        this.soundEffectSlider.valueProperty().addListener(o -> SoundPlayer.setSoundEffectVolume(this.soundEffectSlider.getValue()));
    }

    /**
     * Applies the {@link it.unibo.pyxis.view.soundplayer.Sound} and calls the
     * {@link SettingsController#back()}.
     */
    public void back() {
        this.playGenericButtonPressSound();
        this.getController().back();
    }

}
