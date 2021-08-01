package it.unibo.pyxis.model.event.movement;

import it.unibo.pyxis.model.element.powerup.Powerup;

/**
 * Event fired when a {@link it.unibo.pyxis.model.element.powerup.Powerup} update its position.
 */
@FunctionalInterface
public interface PowerupMovementEvent extends MovementEvent<Powerup> {
}
