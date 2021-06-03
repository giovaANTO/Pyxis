package it.unibo.pyxis.model.level.loader.skeleton;

import java.util.Set;

public final class ArenaSkeletonImpl implements ArenaSkeleton {

    private int lives;
    private double width;
    private double height;

    /**
     * Direct implementation of BrickSkeleton interface as type variable
     * required for working with SnakeYAML library.
     */
    private Set<BrickSkeletonImpl> brickSkeletonSet;

    @Override
    public int getLives() {
        return this.lives;
    }

    @Override
    public void setLives(final int inputLives) {
        this.lives = inputLives;
    }

    @Override
    public double getWidth() {
        return this.width;
    }

    @Override
    public double getHeight() {
        return this.height;
    }

    @Override
    public void setWidth(final double inputWidth) {
        this.width = inputWidth;
    }

    @Override
    public void setHeight(final double inputHeight) {
        this.height = inputHeight;
    }

    @Override
    public Set<BrickSkeletonImpl> getBrickSkeletonSet() {
        return this.brickSkeletonSet;
    }

    @Override
    public void setBrickSkeletonSet(final Set<BrickSkeletonImpl> inputBrickSkeletonSet) {
        this.brickSkeletonSet = inputBrickSkeletonSet;
    }
}
