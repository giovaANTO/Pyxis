package it.unibo.pyxis.model.level.loader.skeleton.pad;

public final class PadSkeletonImpl implements PadSkeleton {

    private double x;
    private double y;
    private double height;
    private double width;

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public void setX(final double inputX) {
        this.x = inputX;
    }

    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public void setY(final double inputY) {
        this.y = inputY;
    }
}
