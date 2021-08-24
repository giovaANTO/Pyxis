package it.unibo.pyxis.model.element.ball;

import it.unibo.pyxis.model.element.Element;
import it.unibo.pyxis.model.hitbox.HitEdge;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.Vector;

import java.util.Map;

public interface Ball extends Element {
    /**
     * Clears all the collision information of the {@link Ball}.
     */
    void clearCollisionInformation();

    /**
     * Returns the collision information {@link Map} of the {@link Ball}.
     *
     * @return The {@link Map} containing the collision information of the
     * {@link Ball}.
     */
    Map<HitEdge, Dimension> getCollisionInformation();

    /**
     * Allows to access to the {@link Ball} identifier.
     *
     * @return The identifier of the {@link Ball}.
     */
    int getId();

    /**
     * Returns the {@link Ball}'s {@link Vector} pace.
     *
     * @return The pace {@link Vector}.
     */
    Vector getPace();

    /**
     * Returns the {@link Ball}'s {@link BallType}.
     *
     * @return The {@link BallType}.
     */
    BallType getType();

    /**
     * Registers a new {@link Ball} collision.
     *
     * @param hitEdge The {@link HitEdge} representing the edge hit in the collision.
     * @param offset  The offset of the collision.
     */
    void registerCollision(HitEdge hitEdge, Dimension offset);

    /**
     * Sets the {@link Ball}'s {@link Vector} pace.
     *
     * @param pace The pace {@link Vector} to set.
     */
    void setPace(Vector pace);

    /**
     * Sets the {@link Ball}'s {@link BallType}.
     *
     * @param type The {@link BallType} to set.
     */
    void setType(BallType type);
}
