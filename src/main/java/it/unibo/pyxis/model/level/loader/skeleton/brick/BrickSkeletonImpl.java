package it.unibo.pyxis.model.level.loader.skeleton.brick;

public final class BrickSkeletonImpl implements BrickSkeleton {

    private double x;
    private double y;
    private String type;
    /**
     * {@inheritDoc}
     */
    @Override
    public String getType() {
        return this.type;
    }
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
    public void setType(final String inputType) {
        this.type = inputType;
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
