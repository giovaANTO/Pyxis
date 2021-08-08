package it.unibo.pyxis.model.level.loader.skeleton.pad;

public final class PadSkeletonImpl implements PadSkeleton {

    private double x;
    private double y;
    /**
     * {@inheritDoc}
     */
    @Override
    public double getX() {
        return this.x;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public double getY() {
        return this.y;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setX(final double inputX) {
        this.x = inputX;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setY(final double inputY) {
        this.y = inputY;
    }
}
