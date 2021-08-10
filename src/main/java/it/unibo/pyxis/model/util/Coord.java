package it.unibo.pyxis.model.util;

public interface Coord {
    /**
     * Returns a copy of the {@link Coord}.
     *
     * @return The {@link Coord}.
     */
    Coord copyOf();
    /**
     * Returns the distance with the specified {@link Coord}.
     * @param coord The {@link Coord}.
     * 
     * @return The distance with the specified {@link Coord}.
     */
    double distance(Coord coord);
    /**
     * Returns the distance with the specified {@link Coord}
     * in its value form.
     * @param px The X value of the {@link Coord}.
     * @param py The Y value of the {@link Coord}.
     * @return The distance with the specified {@link Coord}.
     */
    double distance(double px, double py);
    /**
     * Returns the X value {@link Coord}.
     *
     * @return The X value of the {@link Coord}.
     */
    double getX();

    /**
     * Returns the Y value of the {@link Coord}.
     *
     * @return The Y value of the {@link Coord}.
     */
    double getY();

    /**
     * Sets the X value of the {@link Coord}.
     *
     * @param xValue The X value of the {@link Coord}.
     */
    void setX(double xValue);

    /**
     * Sets the Y value of the {@link Coord}.
     *
     * @param yValue The Y value of the {@link Coord}.
     */
    void setY(double yValue);
    /**
     * Sets the X and Y values of the {@link Coord}.
     *
     * @param xValue The X value of the {@link Coord}.
     * @param yValue The Y value of the {@link Coord}.
     */
    default void setXY(double xValue, double yValue) {
        this.setX(xValue);
        this.setY(yValue);
    }
    /**
     * Sums the parameter values to the internal values of the {@link Coord}.
     *
     * @param coord The {@link Coord} to sum.
     */
    void sumCoord(Coord coord);
    /**
     * Sums the xValue and the yValue to the internal values of the {@link Coord}.
     *
     * @param xValue The X value of the {@link Coord} to sum.
     * @param yValue The Y value of the {@link Coord} to sum.
     */
    void sumValues(double xValue, double yValue);
    /**
     * Sums the X and Y components of the {@link Vector}
     * to the X and Y values of a {@link Coord}.
     *
     * @param vector The {@link Vector} to sum.
     */
    void sumVector(Vector vector);
    /**
     * Sums the X and Y components of a {@link Vector},
     * multiplied by a certain value, to the
     * X and Y values of the {@link Coord}.
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
