package it.unibo.pyxis.model.util;

public interface Coord {

    /**
     * Return a copy of the {@link Coord}.
     * @return The {@link Coord}
     */
    Coord copyOf();

    /**
     *
     * @param position
     * @return
     */
    double distance(Coord position);

    /**
     *
     * @param px
     * @param py
     * @return
     */
    double distance(double px, double py);

    /**
     * Return the x coordinate.
     *
     * @return The value of the x coordinate
     */
    double getX();

    /**
     * Return the y coordinate.
     *
     * @return The value of the y coordinate
     */
    double getY();

    /**
     * Set the x coordinate.
     *
     * @param xCoord The value of the x coordinate
     */
    void setX(double xCoord);

    /**
     * Set the y coordinate.
     *
     * @param yCoord The value of the y coordinate
     */
    void setY(double yCoord);

    /**
     * Set the x, y coordinates.
     *
     * @param xCoord The value of the x coordinate
     * @param yCoord The value of the y coordinate
     */
    default void setXY(double xCoord, double yCoord) {
        this.setX(xCoord);
        this.setY(yCoord);
    }

    /**
     * Sum the parameter values to the internal values of the {@link Coord}.
     *
     * @param coord
     */
    void sumCoord(Coord coord);

    /**
     * Sum the xValue and the yValue to the internal values of the {@link Coord}.
     *
     * @param xValue
     * @param yValue
     */
    void sumValues(double xValue, double yValue);

    /**
     * Sum the x, y coordinates to the x, y, components of a
     * {@link Vector}.
     *
     * @param vector The {@link Vector} to sum
     */
    void sumVector(Vector vector);

    /**
     * Sum the x, y coordinates to the x, y components of a
     * {@link Vector} multiplied by a certain value.
     *
     * @param vector     The {@link Vector} to sum
     * @param multiplier The multiplier value
     */
    void sumVector(Vector vector, double multiplier);

    /**
     * Sum the xValue to the internal X value of the {@link Coord}.
     *
     * @param xValue
     */
    void sumXValue(double xValue);

    /**
     * Sum the yValue to the internal Y value of the {@link Coord}.
     *
     * @param yValue
     */
    void sumYValue(double yValue);
}
