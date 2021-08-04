package it.unibo.pyxis.controller.soundplayer;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class SoundPlayer {

    private static final String SEPARATOR = File.separator;
    private static final String SOUNDS_PATH = "soundeffects" + SEPARATOR;
    private static final String SOUNDS_END_PATH = ".wav";

    private static double volume = 0.2;
    private static final Map<Sound, Media> allSounds;

    private static MediaPlayer backgroundMusicPlayer;
    private static MediaPlayer soundEffectPlayer;

    private SoundPlayer() { }

    static {
        allSounds = new HashMap<>(Map.of());

        Arrays.stream(Sound.values()).forEach(s -> {
                try {
                    Media sound = new Media(
                            ClassLoader.getSystemResource(SOUNDS_PATH + s.getSoundName() + SOUNDS_END_PATH).toURI().toString());
                    allSounds.put(s, sound);
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
        });
    }

    private static MediaPlayer loadMediaPlayer(final Sound sound) {
        return new MediaPlayer(allSounds.get(sound));
    }

    public static void setVolume(final double volume) {
        SoundPlayer.volume = volume;
    }

    public static void playBackgroundMusic(final Sound backgroundMusic) {
        backgroundMusicPlayer = loadMediaPlayer(backgroundMusic);
        backgroundMusicPlayer.setVolume(volume);
        backgroundMusicPlayer.play();
        backgroundMusicPlayer.setOnEndOfMedia(() -> {
            backgroundMusicPlayer.seek(Duration.ZERO);
            backgroundMusicPlayer.play();
        });
    }

    public static void playSoundEffect(final Sound soundEffect) {
        soundEffectPlayer = loadMediaPlayer(soundEffect);
        soundEffectPlayer.setVolume(volume);
        soundEffectPlayer.play();
    }
}
