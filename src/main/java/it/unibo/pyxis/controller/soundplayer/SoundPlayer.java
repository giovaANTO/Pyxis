package it.unibo.pyxis.controller.soundplayer;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import it.unibo.pyxis.controller.soundplayer.eventplayer.SoundEffectEventHandler;
import it.unibo.pyxis.controller.soundplayer.eventplayer.SoundEffectEventHandlerImpl;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public final class SoundPlayer {

    private static final String SOUNDS_PATH = "soundeffects/";
    private static final String SOUNDS_END_PATH = ".wav";

    private static double backgroundVolume = 0.2;
    private static double soundEffectVolume = 0.2;
    private static final Map<Sound, Media> allSounds;

    private static MediaPlayer backgroundMusicPlayer;
    private static MediaPlayer soundEffectPlayer;

    private static final SoundEffectEventHandler modelSoundEffectHandler = new SoundEffectEventHandlerImpl();

    private SoundPlayer() { }

    static {
        allSounds = new HashMap<>(Map.of());
        Set.of(Sound.values()).forEach(s -> {
                try {
                    final Media sound = new Media(
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

    /**
     * Return the background music volume.
     * @return
     *          The background music volume.
     */
    public static double getBackgroundVolume() {
        return backgroundVolume;
    }

    /**
     * Return the sound effect volume.
     * @return
     *          The sound effect volume.
     */
    public static double getSoundEffectVolume() {
        return soundEffectVolume;
    }

    /**
     * Play a {@link Sound} on a loop.
     * @param backgroundMusic
     */
    public static void playBackgroundMusic(final Sound backgroundMusic) {
        if (!Objects.isNull(backgroundMusicPlayer)) {
            backgroundMusicPlayer.stop();
            backgroundMusicPlayer.dispose();
        }
        backgroundMusicPlayer = loadMediaPlayer(backgroundMusic);
        backgroundMusicPlayer.setVolume(backgroundVolume);
        backgroundMusicPlayer.play();
        backgroundMusicPlayer.setOnEndOfMedia(() -> {
            backgroundMusicPlayer.seek(Duration.ZERO);
            backgroundMusicPlayer.play();
        });
    }

    /**
     * Play a {@link Sound} for its duration.
     * @param soundEffect
     */
    public static void playSoundEffect(final Sound soundEffect) {
        soundEffectPlayer = loadMediaPlayer(soundEffect);
        soundEffectPlayer.setVolume(soundEffectVolume);
        soundEffectPlayer.play();
        soundEffectPlayer.setOnEndOfMedia(soundEffectPlayer::dispose);
    }

    /**
     * Set the volume of the background music.
     * @param volume
     */
    public static void setBackgroundVolume(final double volume) {
        backgroundVolume = volume;
        if (!Objects.isNull(backgroundMusicPlayer)) {
            backgroundMusicPlayer.setVolume(backgroundVolume);
        }
    }

    /**
     * Set the volume of the sound effects.
     * @param volume
     */
    public static void setSoundEffectVolume(final double volume) {
        soundEffectVolume = volume;
        if (!Objects.isNull(soundEffectPlayer)) {
            soundEffectPlayer.setVolume(soundEffectVolume);
        }
    }

    /**
     * Shuts down the {@link SoundPlayer}.
     */
    public static void shutdown() {
        if (!Objects.isNull(backgroundMusicPlayer)) {
            backgroundMusicPlayer.stop();
        }
        if (!Objects.isNull(soundEffectPlayer)) {
            soundEffectPlayer.stop();
        }
        modelSoundEffectHandler.shutdown();
    }
}
