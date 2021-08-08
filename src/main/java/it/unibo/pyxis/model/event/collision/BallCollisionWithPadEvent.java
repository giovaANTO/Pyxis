package it.unibo.pyxis.model.event.collision;

/**
 * Event fired when a {@link it.unibo.pyxis.model.element.ball.Ball} collide
 * with the {@link it.unibo.pyxis.model.element.pad.Pad}.
 */
public interface BallCollisionWithPadEvent extends CollisionEvent {
    /**
     * Returns the percentage of the {@link it.unibo.pyxis.model.element.pad.Pad}
     * width calculated on the X {@link it.unibo.pyxis.model.util.Coord} of the point
     * of collision and the {@link it.unibo.pyxis.model.element.pad.Pad} width.
     *
     * @return The width percentage of the pad.
     */
    double getPadHitPercentage();
}
