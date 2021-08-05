package it.unibo.pyxis.model.event;

import it.unibo.pyxis.model.element.ball.Ball;
import it.unibo.pyxis.model.element.powerup.Powerup;
import it.unibo.pyxis.model.event.collision.BallCollisionWithBorderEvent;
import it.unibo.pyxis.model.event.collision.BallCollisionWithBrickEvent;
import it.unibo.pyxis.model.event.collision.BallCollisionWithPadEvent;
import it.unibo.pyxis.model.event.movement.BallMovementEvent;
import it.unibo.pyxis.model.event.movement.PowerupMovementEvent;
import it.unibo.pyxis.model.event.notify.DecreaseLifeEvent;
import it.unibo.pyxis.model.event.notify.BrickDestructionEvent;
import it.unibo.pyxis.model.event.notify.PowerupActivationEvent;
import it.unibo.pyxis.model.hitbox.CollisionInformation;
import it.unibo.pyxis.model.util.Coord;

public final class Events {

    private Events() {
        throw new AssertionError("This class can't be instantiated");
    }

    /**
     * Create a new {@link BallCollisionWithBorderEvent} instance.
     *
     * @param id
     *          The {@link Ball} id
     * @param collisionInformation
     *          The {@link CollisionInformation} instance.
     * @return
     *          The {@link BallCollisionWithBorderEvent} instance.
     */
    public static BallCollisionWithBorderEvent newBallCollisionWithBorderEvent(final int id, final CollisionInformation collisionInformation) {
        return new BallCollisionWithBorderEvent() {
            @Override
            public int getBallId() {
                return id;
            }

            @Override
            public CollisionInformation getCollisionInformation() {
                return collisionInformation;
            }
        };
    }

    /**
     * Create a new {@link BallCollisionWithBrickEvent} instance.
     *
     * @param id
     *          The {@link Ball} id
     * @param collisionInformation
     *          The {@link CollisionInformation} instance.
     * @return
     *          The {@link BallCollisionWithBrickEvent} instance.
     */
    public static BallCollisionWithBrickEvent newBallCollisionWithBrickEvent(final int id, final CollisionInformation collisionInformation) {
        return new BallCollisionWithBrickEvent() {
            @Override
            public int getBallId() {
                return id;
            }

            @Override
            public CollisionInformation getCollisionInformation() {
                return collisionInformation;
            }
        };
    }

    /**
     * Create a new {@link BallCollisionWithPadEvent} instance.
     *
     * @param id
     *          The {@link Ball} id
     * @param collisionInformation
     *          The {@link CollisionInformation} instance.
     * @param padWidth
     *          The width property of the
     *          {@link it.unibo.pyxis.model.element.pad.Pad}.
     * @return
     *          The {@link BallCollisionWithPadEvent} instance.
     */
    public static BallCollisionWithPadEvent newBallCollisionWithPadEvent(final int id, final CollisionInformation collisionInformation,
                                                                         final double padWidth) {
        return new BallCollisionWithPadEvent() {
            @Override
            public int getBallId() {
                return id;
            }

            @Override
            public CollisionInformation getCollisionInformation() {
                return collisionInformation;
            }

            @Override
            public double getPadHitPercentage() {
                return padWidth;
            }
        };
    }

    /**
     * Create a new {@link BallMovementEvent} instance passing a {@link Coord}
     * representing the current {@link Coord} of the
     * {@link it.unibo.pyxis.model.element.ball.Ball} inside the
     * {@link it.unibo.pyxis.model.arena.Arena}.
     *
     * @param ball
     *          The {@link Ball} moving
     * @return
     *          The {@link BallMovementEvent} instance.
     */
    public static BallMovementEvent newBallMovementEvent(final Ball ball) {
        return () -> ball;
    }

    /**
     * Create a new {@link BrickDestructionEvent} instance passing the {@link Coord}
     * of the destroyed {@link it.unibo.pyxis.model.element.brick.Brick}.
     *
     * @param coords The coords of destroyed brick.
     * @param points The amount of points to be registered.
     * @return The {@link BrickDestructionEvent} instance.
     */
    public static BrickDestructionEvent newBrickDestructionEvent(final Coord coords, final int points) {
        return new BrickDestructionEvent() {
            @Override
            public Coord getBrickCoord() {
                return coords;
            }

            @Override
            public int getPoints() {
                return points;
            }
        };
    }

    /**
     * Create a new {@link DecreaseLifeEvent} instance.
     *
     * @return
     *          The {@link DecreaseLifeEvent} instance.
     */
    public static DecreaseLifeEvent newDecreaseLifeEvent() {
        return new DecreaseLifeEvent() {
            @Override
            public String toString() {
                return super.toString();
            }
        };
    }

    /**
     * Create a new {@link PowerupActivationEvent} instance passing a {@link Powerup}.
     *
     * @param powerup
     *          The {@link Powerup} that called the event.
     * @return
     *          The {@link PowerupActivationEvent} instance.
     */
    public static PowerupActivationEvent newPowerupActivationEvent(final Powerup powerup) {
        return () -> powerup;
    }

    /**
     * Create a new {@link PowerupMovementEvent} instance passing a {@link Coord}
     * representing the current position of the
     * {@link it.unibo.pyxis.model.element.powerup.Powerup} inside the
     * {@link it.unibo.pyxis.model.arena.Arena}.
     *
     * @param powerup
     *          The {@link it.unibo.pyxis.model.element.powerup.Powerup}'s
     *          {@link Coord}.
     * @return
     *          The {@link PowerupMovementEvent} instance.
     */
    public static PowerupMovementEvent newPowerupMovementEvent(final Powerup powerup) {
        return () -> powerup;
    }
}
