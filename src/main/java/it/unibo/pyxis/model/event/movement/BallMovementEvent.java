package it.unibo.pyxis.model.event.movement;

import java.util.Optional;

/**
 * Event fired when the {@link it.unibo.pyxis.model.element.ball.Ball}
 * update its position.
 */
public interface BallMovementEvent extends MovementEvent {
    /**
     * Return the {@link it.unibo.pyxis.model.element.ball.Ball} identifier.
     * @return
     *          The id of the moving {@link it.unibo.pyxis.model.element.ball.Ball}
     */
    int getBallId();

    /**
     *  An {@link Optional} indicating the damage caused by the moving {@link it.unibo.pyxis.model.element.ball.Ball}
     *  to a {@link it.unibo.pyxis.model.element.brick.Brick}.
     *  If the returned optional is empty the brick should be immediatly destroyed.
     *
     * @return
     *          The {@link Optional} that contains the damage.
     */
    Optional<Integer> getDamage();
}
