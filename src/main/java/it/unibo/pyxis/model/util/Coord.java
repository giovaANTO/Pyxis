package it.unibo.pyxis.model.util;

public interface Coord {
    /**
     * Returns a copy of the {@link Coord}.
     *
     * @return The {@link Coord}
     */
    Coord copyOf();
    /**
     *
     *
     * @param position
     * @return
     */
    double distance(Coord position);
    /**
     *
     *
     * @param px
     * @param py
     * @return
     */
    double distance(double px, double py);
    /**
     * Returns the X {@link Coord}.
     *
     * @return The value of the X {@link Coord}.
     */
    double getX();

    /**
     * Returns the Y {@link Coord}.
     *
     * @return The value of the Y {@link Coord}.
     */
    double getY();

    /**
     * Sets the X {@link Coord}.
     *
     * @param xCoord The value of the X {@link Coord}.
     */
    void setX(double xCoord);

    /**
     * Sets the Y {@link Coord}.
     *
     * @param yCoord The value of the Y {@link Coord}.
     */
    void setY(double yCoord);
    /**
     * Sets the X, Y {@link Coord}s.
     *
     * @param xCoord The value of the X {@link Coord}.
     * @param yCoord The value of the Y {@link Coord}.
     */
    default void setXY(double xCoord, double yCoord) {
        this.setX(xCoord);
        this.setY(yCoord);
    }
    /**
     * Sums the parameter values to the internal values of the {@link Coord}.
     *
     * @param coord The {@link Coord} values to sum.
     */
    void sumCoord(Coord coord);
    /**
     * Sums the xValue and the yValue to the internal values of the {@link Coord}.
     *
     * @param xValue The X {@link Coord} value to sum.
     * @param yValue The Y {@link Coord} value to sum.
     */
    void sumValues(double xValue, double yValue);
    /**
     * Sums the X, Y {@link Coord}s to the X, Y components of a
     * {@link Vector}.
     *
     * @param vector The {@link Vector} to sum.
     */
    void sumVector(Vector vector);
    /**
     * Sums the X, Y {@link Coord} to the X, Y components of a
     * {@link Vector} multiplied by a certain value.
     *
     * @param vector     The {@link Vector} to sum.
     * @param multiplier The multiplier value.
     */
    void sumVector(Vector vector, double multiplier);
    /**
     * Sums the xValue to the internal X value of the {@link Coord}.
     *
     * @param xValue The value to sum.
     */
    void sumXValue(double xValue);

    /**
     * Sum the yValue to the internal Y value of the {@link Coord}.
     *
     * @param yValue The value to sum.
     */
    void sumYValue(double yValue);
}
