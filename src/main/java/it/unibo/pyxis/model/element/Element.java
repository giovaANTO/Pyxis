package it.unibo.pyxis.model.element;

import it.unibo.pyxis.ecs.Entity;
import it.unibo.pyxis.model.hitbox.Hitbox;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.Vector;


public interface Element extends Entity {
    /**
     * Returns the {@link Element}'s {@link Dimension}.
     *
     * @return The {@link Dimension}.
     */
    Dimension getDimension();

    /**
     * Returns the {@link Element}'s {@link Hitbox}.
     *
     * @return The {@link Hitbox}.
     */
    Hitbox getHitbox();

    /**
     * Returns the {@link Element}'s pace {@link Vector}.
     *
     * @return The pace's {@link Vector}
     */
    Vector getPace();

    /**
     * Returns the {@link Element}'s position {@link Coord}.
     *
     * @return The {@link Coord}.
     */
    Coord getPosition();

    /**
     * Returns the {@link Element}'s update time multiplier.
     *
     * @return The update time multiplier.
     */
    double getUpdateTimeMultiplier();

    /**
     * Increases the {@link Element}'s height value.
     *
     * @param increaseValue The value to increase.
     */
    void increaseHeight(double increaseValue);

    /**
     * Increases the {@link Element}'s width value.
     *
     * @param increaseValue The value to increase.
     */
    void increaseWidth(double increaseValue);

    /**
     * Sets the {@link Element}'s height value.
     *
     * @param height The height value.
     */
    void setHeight(double height);

    /**
     * Sets the {@link Hitbox} of the {@link Element} as the parameter {@link Hitbox}.
     *
     * @param hitbox The {@link Hitbox} to set.
     */
    void setHitbox(Hitbox hitbox);

    /**
     * Sets the {@link Element}'s pace {@link Vector}.
     *
     * @param inputPace The input pace {@link Vector}.
     */
    void setPace(Vector inputPace);

    /**
     * Sets the {@link Element}'s position.
     *
     * @param position The {@link Coord}.
     */
    void setPosition(Coord position);

    /**
     * Sets the {@link Element}'s width value.
     *
     * @param width The width value.
     */
    void setWidth(double width);

    /**
     * Executes an update on the {@link Element}.
     *
     * @param dt The elapsed time between two updates.
     */
    void update(double dt);
}
