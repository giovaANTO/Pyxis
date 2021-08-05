package it.unibo.pyxis.model.element;

import it.unibo.pyxis.model.hitbox.Hitbox;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;

public interface Element {
    /**
     * Return the element's dimension.
     * @return
     *         The element's {@link Dimension}
     */
    Dimension getDimension();
    /**
     * Return the element's {@link Hitbox}.
     * @return
     *          The element's {@link Hitbox}
     */
    Hitbox getHitbox();
    /**
     * Return the element's position.
     * @return
     *          The element's {@link Coord}
     */
    Coord getPosition();
    /**
     * Return the element's update time multiplier.
     * @return
     *          The dt multiplier
     */
    double getUpdateTimeMultiplier();
    /**
     * Increase the element's height value.
     * @param increaseValue
     *          The increment value
     */
    void increaseHeight(double increaseValue);
    /**
     * Increase the element's width value.
     * @param increaseValue
     *          The increment value
     */
    void increaseWidth(double increaseValue);
    /**
     * Set the element's height value.
     * @param height
     *          The height value
     */
    void setHeight(double height);
    /**
     * Set the element's position.
     * @param position
     *          The {@link Coord}
     */
    void setPosition(Coord position);
    /**
     * Set the element's width value.
     * @param width
     *          The width value
     */
    void setWidth(double width);
    /**
     * Execute an update on the element.
     * @param dt The time gap intercurred between an update
     */
    void update(double dt);
}
