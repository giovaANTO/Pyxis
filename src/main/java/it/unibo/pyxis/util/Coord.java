package it.unibo.pyxis.util;

public interface Coord {

    /**
     * Returns the x coordinate.
     * @return
     *          The value of the x coordinate
     */
    double getX();

    /**
     * Returns the y coordinate.
     * @return
     *          The value of the y coordinate
     */
    double getY();

    /**
     * Sets the x coordinate.
     * @param xCoord
     *          The value of the x coordinate
     */
    void setX(double xCoord);

    /**
     * Sets the y coordinate.
     * @param yCoord
     *          The value of the y coordinate
     */
    void setY(double yCoord);

    /**
     * Sets the x, y coordinates.
     * @param xCoord
     *          The value of the x coordinate
     * @param yCoord
     *          The value of the y coordinate
     */
    default void setXY(double xCoord, double yCoord) {
        this.setX(xCoord);
        this.setY(yCoord);
    }

    /**
     * Sums the x, y coordinates to the x, y components of a
     * {@link Vector} multiplied by a certain value.
     * @param vector
     *          The {@link Vector} to sum
     * @param multiplier
     *          The multiplier value
     */
    void sumVector(Vector vector, double multiplier);

    /**
     * Returns a copy of the {@link Coord}.
     * @return
     *          The {@link Coord}
     */
    Coord copyOf();
}
