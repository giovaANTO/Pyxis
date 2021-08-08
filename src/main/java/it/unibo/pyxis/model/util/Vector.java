package it.unibo.pyxis.model.util;

public interface Vector {
    /**
     * Returns a copy of the {@link Vector}.
     *
     * @return The {@link Vector} copy.
     */
    Vector copyOf();
    /**
     * Returns {@link Vector}'s X component.
     *
     * @return The X component.
     */
    double getX();
    /**
     * Returns {@link Vector}'s Y component.
     *
     * @return The Y component.
     */
    double getY();
    /**
     * Returns {@link Vector}'s module.
     *
     * @return The module's value.
     */
    double getModule();
    /**
     * Returns a new copy of the current {@link Vector} rotated by a
     * certain amount of degrees.
     *
     * @param  rotationAngle The rotation angle of the {@link Vector}.
     * @return A new rotated {@link Vector}.
     */
    Vector rotationBy(double rotationAngle);
    /**
     * Sets {@link Vector}'s X component.
     *
     * @param xCoord The X component.
     */
    void setX(double xCoord);
    /**
     * Sets {@link Vector}'s Y component.
     *
     * @param yCoord The Y component
     */
    void setY(double yCoord);
}
