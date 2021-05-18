package it.unibo.pyxis.event.collision;

/**
 * Event fired when a {@link it.unibo.pyxis.element.pad.Pad} collide with a generic
 * element of the domain.
 */
public interface PadCollisionEvent extends CollisionEvent {
    /**
     * Return the current pad width.
     * @return
     *          The width dimension of the pad.
     */
    double getPadWidth();
}
