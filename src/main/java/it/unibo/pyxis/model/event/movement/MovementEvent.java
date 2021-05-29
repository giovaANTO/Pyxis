package it.unibo.pyxis.model.event.movement;

import it.unibo.pyxis.model.event.Event;
import it.unibo.pyxis.model.hitbox.Hitbox;

/**
 * Represent a generic movement event.
 */
@FunctionalInterface
public interface MovementEvent extends Event {
    Hitbox getHitbox();
}
