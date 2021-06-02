package it.unibo.pyxis.model.level.loader.skeleton;

import it.unibo.pyxis.model.util.Coord;

public interface BrickSkeleton {
    /**
     * Return the brick coord for the skeleton.
     * @return
     *          {@link Coord} instance
     */
    Coord getCoord();

    /**
     * Set the {@link Coord} for a {@link it.unibo.pyxis.model.element.brick.Brick}.
     * @param coord
     *              The input {@link Coord}.
     */
    void setCoord(Coord coord);

    /**
     * Return the string representing the type of the {@link it.unibo.pyxis.model.element.brick.Brick}.
     * @return
     *          A {@link String} representing the {@link it.unibo.pyxis.model.element.brick.Brick} type.
     */
    String getType();

    /**
     * Set the type of the {@link it.unibo.pyxis.model.element.brick.Brick}.
     * @param type
     *          A {@link String} containing the type of a {@link it.unibo.pyxis.model.element.brick.Brick}
     */
    void setType(String type);
}
