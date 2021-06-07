package it.unibo.pyxis.model.level.loader.skeleton.arena;

import it.unibo.pyxis.model.level.loader.skeleton.brick.BrickSkeletonImpl;
import it.unibo.pyxis.model.level.loader.skeleton.pad.PadSkeletonImpl;

import java.util.Set;

public final class ArenaSkeletonImpl implements ArenaSkeleton {

    private int lives;
    private double width;
    private double height;

    /**
     * Direct implementation of interfaces is
     * required for working with SnakeYAML library.
     */
    private Set<BrickSkeletonImpl> bricks;
    private PadSkeletonImpl pad;

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
    public Set<BrickSkeletonImpl> getBricks() {
        return this.bricks;
    }

    @Override
    public void setBricks(final Set<BrickSkeletonImpl> inputBrickSkeletonSet) {
        this.bricks = inputBrickSkeletonSet;
    }

    @Override
    public PadSkeletonImpl getPad() {
        return this.pad;
    }

    @Override
    public void setPad(final PadSkeletonImpl inputPadSkeleton) {
        this.pad = inputPadSkeleton;
    }
}
