package it.unibo.pyxis.model.util;

public interface Vector {

    /**
     * Returns vector's x component.
     * @return
     *          The x component
     */
    double getX();

    /**
     * Returns vector's y component.
     * @return
     *          The y component
     */
    double getY();

    /**
     * Returns vector's module.
     * @return
     *          The module's value
     */
    double getModule();

    /**
     * Sets vector's x component.
     * @param xCoord
     *          The x component
     */
    void setX(double xCoord);

    /**
     * Sets vector's y component.
     * @param yCoord
     *          The y component
     */
    void setY(double yCoord);

    /**
     * Return a new copy of the current {@link Vector} rotated by a
     * certain amount of degrees.
     * @param  rotationAngle
     *                          The rotation angle of the {@link Vector}
     * @return
     *          A new rotated {@link Vector}
     */
    Vector rotationBy(double rotationAngle);

    /**
     * Return a copy of the vector.
     * @return
     *          The {@link Vector} copy
     */
    Vector copyOf();
}
