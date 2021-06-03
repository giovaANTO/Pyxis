package it.unibo.pyxis.model.level.loader.skeleton;

public final class BrickSkeletonImpl implements BrickSkeleton {

    private double x;
    private double y;
    private String type;

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void setType(final String inputType) {
        this.type = inputType;
    }

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
