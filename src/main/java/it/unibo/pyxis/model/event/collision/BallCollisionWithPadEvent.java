package it.unibo.pyxis.model.event.collision;

/**
 * Event fired when a {@link it.unibo.pyxis.model.element.ball.Ball} collide
 * with the {@link it.unibo.pyxis.model.element.pad.Pad}.
 */
public interface BallCollisionWithPadEvent extends BallCollisionWithBrickEvent {
    /**
     * Returns at what percentage of his width the pad was hit.
     * @return
     *          The width dimension of the pad.
     */
    double getPadHitPercentage();
}
