package it.unibo.pyxis.model.element.ball;

import it.unibo.pyxis.model.util.Vector;

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
