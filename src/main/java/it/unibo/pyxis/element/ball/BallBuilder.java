package it.unibo.pyxis.element.ball;

import it.unibo.pyxis.util.Coord;
import it.unibo.pyxis.util.Dimension;
import it.unibo.pyxis.util.Vector;

public interface BallBuilder {
    
    /**
     * Sets the ball's pace.
     * @param pace
     *              The {@link Vector} to set
     * @return
     *              The {@link BallBuilder}
     */
    BallBuilder pace(Vector pace);

    /**
     * Sets the ball's id.
     * @param id
     *              The id to set
     * @return
     *              The {@link BallBuilder}
     */
    BallBuilder id(int id);

    /**
     * Builds the ball checking all fields are set.
     * @return
     *              The {@link Ball}
     */
    Ball build();
}
