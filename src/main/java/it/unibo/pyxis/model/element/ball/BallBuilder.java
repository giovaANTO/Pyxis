package it.unibo.pyxis.model.element.ball;

import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Vector;

public interface BallBuilder {
    /**
     * Sets the {@link Ball}'s {@link BallType}.
     *
     * @param type The type of the {@link Ball}.
     * @return The {@link BallBuilder}.
     */
    BallBuilder ballType(BallType type);
    /**
     * Builds the {@link Ball} checking all fields are set.
     *
     * @return The {@link Ball}.
     */
    Ball build();
    /**
     * Sets the {@link Ball}'s id.
     *
     * @param id The id to set.
     * @return The {@link BallBuilder}.
     */
    BallBuilder id(int id);
    /**
     * Sets the {@link Ball}'s {@link Coord} position.
     *
     * @param position The position to set.
     * @return The {@link BallBuilder}.
     */
    BallBuilder initialPosition(Coord position);
    /**
     * Sets the {@link Ball}'s {@link Vector} pace.
     *
     * @param pace The {@link Vector} to set.
     * @return The {@link BallBuilder}.
     */
    BallBuilder pace(Vector pace);
}
