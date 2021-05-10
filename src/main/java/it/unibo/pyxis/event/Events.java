package it.unibo.pyxis.event;

import it.unibo.pyxis.event.movement.BallMovementEvent;
import it.unibo.pyxis.event.movement.PowerupMovementEvent;
import it.unibo.pyxis.event.notify.BrickDestructionEvent;
import it.unibo.pyxis.event.notify.CollisionEvent;
import it.unibo.pyxis.event.notify.PowerupActivationEvent;
import it.unibo.pyxis.powerup.effect.PowerupEffect;
import it.unibo.pyxis.util.Coord;


public final class Events {

    private Events() {
        throw new AssertionError("This class can't be instantiated , why are you here?");
    };

    /**
     * Create a new {@link BrickDestructionEvent} instance passing the coords of the destroyed brick.
     * @param coords
     *                  The coords of destroyed brick.
     * @return
     *                  The {@link BrickDestructionEvent} instance.
     */
    public static BrickDestructionEvent newBrickDestructionEvent(final Coord coords) {
        return () -> coords;
    }

    /**
     * Create a new {@link CollisionEvent} instance passing an entity that has received a collision.
     * @param collidedEntity
     *                          The entity that has been hit.
     * @param <T>
     *                          Type of collided entity.
     * @return
     *                          The {@link CollisionEvent} instance.
     */
    public static <T> CollisionEvent<T> newCollisionEvent(final T collidedEntity) {
        return () -> collidedEntity;
    }

    /**
     * Create a new {@link PowerupActivationEvent} instance passing a {@link PowerupEffect}.
     * @param effect
     *                  Effect that should be applied.
     * @return
     *                  The {@link PowerupActivationEvent} instance.
     */
    public static PowerupActivationEvent newPowerupActivationEvent(final PowerupEffect effect) {
        return () -> effect;
    }

    /**
     *  Create a new {@link BallMovementEvent} instance passing a {@link Coord} representing the current position
     *  of the {@link it.unibo.pyxis.element.ball.Ball} inside the {@link it.unibo.pyxis.arena.Arena}.
     *
     * @param coord
     *                  The {@link it.unibo.pyxis.element.ball.Ball}'s {@link Coord} position.
     * @return
     *                  The {@link BallMovementEvent} instance.
     */
    public static BallMovementEvent newBallMovementEvent(final Coord coord) {
        return () -> coord;
    }

    /**
     * Create a new {@link PowerupMovementEvent} instance passing a {@link Coord} representing the current position
     * of the {@link it.unibo.pyxis.element.powerup.Powerup} inside the {@link it.unibo.pyxis.arena.Arena}.
     *
     * @param coord
     *               The {@link it.unibo.pyxis.element.powerup.Powerup}'s {@link Coord} position.
     * @return
     *               The {@link PowerupMovementEvent} instance.
     */
    public static PowerupMovementEvent newPowerupMovementEvent(final Coord coord) {
        return () -> coord;
    }
}
