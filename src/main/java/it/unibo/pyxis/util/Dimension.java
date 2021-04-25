package it.unibo.pyxis.util;

public interface Dimension {

    double getWidth();

    double getHeight();

    void setWidth(double width);

    void setHeight(double height);

    void increaseWidth(double increaseValue);

    void increaseHeight(double increaseValue);
}
