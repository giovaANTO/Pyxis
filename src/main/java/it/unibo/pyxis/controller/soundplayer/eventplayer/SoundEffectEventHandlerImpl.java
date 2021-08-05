package it.unibo.pyxis.controller.soundplayer.eventplayer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import it.unibo.pyxis.controller.soundplayer.Sound;
import it.unibo.pyxis.controller.soundplayer.SoundPlayer;
import it.unibo.pyxis.model.event.collision.BallCollisionWithBorderEvent;
import it.unibo.pyxis.model.event.collision.BallCollisionWithBrickEvent;
import it.unibo.pyxis.model.event.collision.BallCollisionWithPadEvent;
import it.unibo.pyxis.model.event.notify.DecreaseLifeEvent;
import it.unibo.pyxis.model.event.notify.PowerupActivationEvent;

public class SoundEffectEventHandlerImpl implements SoundEffectEventHandler {

    public SoundEffectEventHandlerImpl() {
        EventBus.getDefault().register(this);
    }

    /**
     * Plays the given {@link it.unibo.pyxis.controller.soundplayer.Sound}
     * @param soundEffect
     *          the {@link it.unibo.pyxis.controller.soundplayer.Sound} to be played.
     */
    private void playSoundEffect(final Sound soundEffect) {
        SoundPlayer.playSoundEffect(soundEffect);
    }

    @Override
    @Subscribe
    public void handleBallBrickCollision(final BallCollisionWithBrickEvent collisionEvent) {
        final Sound soundEffect = collisionEvent.isBrickDestructible()
                                    ? Sound.BREAKABLE_BRICK_COLLISION
                                    : Sound.UNBREAKABLE_BRICK_COLLISION;
        this.playSoundEffect(soundEffect);
    }

    @Override
    @Subscribe
    public void handleBorderCollision(final BallCollisionWithBorderEvent collisionEvent) {
        this.playSoundEffect(Sound.BORDER_COLLISION);
    }

    @Override
    @Subscribe
    public void handlePadCollision(final BallCollisionWithPadEvent collisionEvent) {
        this.playSoundEffect(Sound.PAD_COLLISION);
    }

    @Override
    @Subscribe
    public void handlePowerupActivation(final PowerupActivationEvent event) {
        this.playSoundEffect(Sound.POWERUP_ACTIVATION);
    }

    @Override
    @Subscribe
    public void handleDecreaseLife(final DecreaseLifeEvent event) {
        this.playSoundEffect(Sound.LIFE_DECREASED);
    }
}
