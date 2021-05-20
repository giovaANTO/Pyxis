package it.unibo.pyxis.element.ball;

import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.Dimension;
import it.unibo.pyxis.util.Vector;

public interface BallBuilder {

    /**
     * Sets the ball's dimension.
     * @param dimension
     *              The {@link Dimension} to set
     * @return
     *              The {@link BallBuilder}
     */
    BallBuilder dimension(Dimension dimension);

    /**
     * Sets the ball's position.
     * @param position
     *              The {@link Coord} to set
     * @return
     *              The {@link BallBuilder}
     */
    BallBuilder position(Coord position);

    /**
     * Sets the ball's pace.
     * @param pace
     *              The {@link Vector} to set
     * @return
     *              The {@link BallBuilder}
     */
    BallBuilder pace(Vector pace);

    /**
     * Builds the ball checking all fields are set.
     * @return
     *              The {@link Ball}
     */
    Ball build();
}
