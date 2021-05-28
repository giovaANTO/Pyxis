package it.unibo.pyxis.model.element;

import it.unibo.pyxis.model.hitbox.Hitbox;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;

public interface Element {

    /**
     * Returns the element's position.
     * @return
     *          The element's {@link Coord}
     */
    Coord getPosition();

    /**
     * Returns the element's dimension.
     * @return
     *         The element's {@link Dimension}
     */
    Dimension getDimension();

    /**
     * Returns the element's update time multiplier.
     * @return
     *          The dt multiplier
     */
    double getUpdateTimeMultiplier();

    /**
     * Returns the element's {@link Hitbox}.
     * @return
     *          The element's {@link Hitbox}
     */
    Hitbox getHitbox();

    /**
     * Sets the element's position.
     * @param position
     *          The {@link Coord}
     */
    void setPosition(Coord position);

    /**
     * Sets the element's width value.
     * @param width
     *          The width value
     */
    void setWidth(double width);

    /**
     * Sets the element's height value.
     * @param height
     *          The height value
     */
    void setHeight(double height);

    /**
     * Increases the element's width value.
     * @param increaseValue
     *          The increment value
     */
    void increaseWidth(double increaseValue);

    /**
     * Increases the element's height value.
     * @param increaseValue
     *          The increment value
     */
    void increaseHeight(double increaseValue);

    /**
     * Execute an update on the element.
     * @param dt The time gap intercurred between an update
     */
    void update(int dt);
}
