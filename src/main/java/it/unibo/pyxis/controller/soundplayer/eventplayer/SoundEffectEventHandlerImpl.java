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
     * Plays the given {@link it.unibo.pyxis.controller.soundplayer.Sound}.
     *
     * @param soundEffect The {@link it.unibo.pyxis.controller.soundplayer.Sound}
     *                    to be played.
     */
    private void playSoundEffect(final Sound soundEffect) {
        SoundPlayer.playSoundEffect(soundEffect);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    @Subscribe
    public final void handleBallBrickCollision(final BallCollisionWithBrickEvent collisionEvent) {
        final Sound soundEffect = collisionEvent.isBrickIndestructible()
                ? Sound.UNBREAKABLE_BRICK_COLLISION
                : Sound.BREAKABLE_BRICK_COLLISION;
        this.playSoundEffect(soundEffect);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    @Subscribe
    public final void handleBorderCollision(final BallCollisionWithBorderEvent collisionEvent) {
        this.playSoundEffect(Sound.BORDER_COLLISION);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    @Subscribe
    public final void handleDecreaseLife(final DecreaseLifeEvent event) {
        this.playSoundEffect(Sound.LIFE_DECREASED);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    @Subscribe
    public final void handlePadCollision(final BallCollisionWithPadEvent collisionEvent) {
        this.playSoundEffect(Sound.PAD_COLLISION);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    @Subscribe
    public final void handlePowerupActivation(final PowerupActivationEvent event) {
        this.playSoundEffect(Sound.POWERUP_ACTIVATION);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void shutdown() {
        EventBus.getDefault().unregister(this);
    }
}
