package it.unibo.pyxis.util;

public interface Coord {
    
    double getX();

    double getY();

    void setX(double xCoord);

    void setY(double yCoord);

    default void setXY(double xCoord, double yCoord) {
        this.setX(xCoord);
        this.setY(yCoord);
    }

    void sumVector(Vector vector, double multiplier);
    
    double distance(Coord position);
    
    double distance(double px, double py);
    
}
