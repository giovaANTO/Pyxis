package it.unibo.pyxis.view.views;

import java.net.URL;
import java.util.ResourceBundle;
import it.unibo.pyxis.controller.controllers.SettingsSceneController;
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

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        backgroundSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(final ObservableValue<? extends Number> observable, final Number oldValue, final Number newValue) {
                SoundPlayer.setBackgroundVolume(backgroundSlider.getValue());
            }
        });
        soundEffectSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(final ObservableValue<? extends Number> observable, final Number oldValue, final Number newValue) {
                SoundPlayer.setSoundEffectVolume(soundEffectSlider.getValue());
            }
        });
    }

    public void back() {
        this.playGenericButtonPressSound();
        this.getController().back();
    }

}
