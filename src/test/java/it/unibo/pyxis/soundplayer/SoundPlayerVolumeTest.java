package it.unibo.pyxis.soundplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import it.unibo.pyxis.view.soundplayer.SoundPlayer;

class SoundPlayerVolumeTest {

    @Test
    void testVolumeChange() {
        final double startingVolume = 0.2;
        final double volume1 = 1.0;
        final double volume2 = 0.6;

        assertEquals(startingVolume, SoundPlayer.getBackgroundVolume());
        assertEquals(startingVolume, SoundPlayer.getSoundEffectVolume());

        SoundPlayer.setBackgroundVolume(volume1);
        SoundPlayer.setSoundEffectVolume(volume1);
        assertEquals(volume1, SoundPlayer.getBackgroundVolume());
        assertEquals(volume1, SoundPlayer.getSoundEffectVolume());

        SoundPlayer.setBackgroundVolume(volume2);
        SoundPlayer.setSoundEffectVolume(volume2);
        assertEquals(volume2, SoundPlayer.getBackgroundVolume());
        assertEquals(volume2, SoundPlayer.getSoundEffectVolume());
    }

}
