package it.unibo.pyxis.view.soundplayer;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import it.unibo.pyxis.view.soundplayer.eventplayer.SoundEffectEventHandlerImpl;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public final class SoundPlayer {

    private static final String SOUNDS_PATH = "soundeffects/";
    private static final String SOUNDS_END_PATH = ".wav";
    private static final double STARTING_BACKGROUND_VOLUME = 0.2;
    private static final double STARTING_SOUND_EFFECT_VOLUME = 0.2;

    private static double backgroundVolume = STARTING_BACKGROUND_VOLUME;
    private static double soundEffectVolume = STARTING_SOUND_EFFECT_VOLUME;
    private static final Map<Sound, Media> ALL_SOUNDS;

    private static Sound currentBackgroundMusic;
    private static MediaPlayer backgroundMusicPlayer;
    private static MediaPlayer soundEffectPlayer;


    private static final SoundEffectEventHandlerImpl MODEL_SOUND_EFFECT_HANDLER = new SoundEffectEventHandlerImpl();

    private SoundPlayer() { }

    static {
        ALL_SOUNDS = new HashMap<>(Map.of());
        Set.of(Sound.values()).forEach(s -> {
                try {
                    final Media sound = new Media(
                            ClassLoader.getSystemResource(SOUNDS_PATH + s.getSoundName() + SOUNDS_END_PATH).toURI().toString());
                    ALL_SOUNDS.put(s, sound);
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
        });
    }
    /**
     * Returns the {@link javafx.scene.media.MediaPlayer} with the
     * {@link javafx.scene.media.Media} relative to the given parameter {@link Sound}.
     * @param sound The {@link Sound} relative to the
     *                  {@link javafx.scene.media.Media} to play
     *                  with the {@link javafx.scene.media.MediaPlayer}.
     *
     * @return The {@link javafx.scene.media.MediaPlayer} with the
     *                  {@link javafx.scene.media.Media} relative
     *                  to the given parameter {@link Sound}.
     */
    private static MediaPlayer loadMediaPlayer(final Sound sound) {
        return new MediaPlayer(ALL_SOUNDS.get(sound));
    }
    /**
     * Returns the background music volume.
     *
     * @return The background music volume.
     */
    public static double getBackgroundVolume() {
        return backgroundVolume;
    }
    /**
     * Returns the sound effect volume.
     *
     * @return The sound effect volume.
     */
    public static double getSoundEffectVolume() {
        return soundEffectVolume;
    }
    /**
     * Plays a {@link Sound} on a loop.
     * @param backgroundMusic The {@link Sound} to loop.
     */
    public static void playBackgroundMusic(final Sound backgroundMusic) {
        if (backgroundMusic == currentBackgroundMusic) {
            return;
        }
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
        currentBackgroundMusic = backgroundMusic;
    }
    /**
     * Plays a {@link Sound} for its duration.
     * @param soundEffect The {@link Sound} to play.
     */
    public static void playSoundEffect(final Sound soundEffect) {
        soundEffectPlayer = loadMediaPlayer(soundEffect);
        soundEffectPlayer.setVolume(soundEffectVolume);
        soundEffectPlayer.play();
        soundEffectPlayer.setOnEndOfMedia(soundEffectPlayer::dispose);
    }
    /**
     * Sets the volume of the background music.
     * @param volume The volume of the background music.
     */
    public static void setBackgroundVolume(final double volume) {
        backgroundVolume = volume;
        if (!Objects.isNull(backgroundMusicPlayer)) {
            backgroundMusicPlayer.setVolume(backgroundVolume);
        }
    }
    /**
     * Sets the volume of the sound effects.
     * @param volume The volume of the sound effects.
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
        MODEL_SOUND_EFFECT_HANDLER.shutdown();
    }
}
