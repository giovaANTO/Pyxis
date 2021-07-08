package it.unibo.pyxis.model.level.loader.skeleton.level;

import it.unibo.pyxis.model.level.loader.skeleton.ball.BallSkeleton;
import it.unibo.pyxis.model.level.loader.skeleton.brick.BrickSkeleton;
import it.unibo.pyxis.model.level.loader.skeleton.pad.PadSkeletonImpl;
import java.util.Set;

public final class LevelSkeletonImpl implements LevelSkeleton {

    private int lives;
    private double width;
    private double height;
    private PadSkeletonImpl pad;
    private Set<BrickSkeleton> bricks;
    private Set<BallSkeleton> balls;

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
    public Set<BrickSkeleton> getBricks() {
        return this.bricks;
    }

    @Override
    public void setBricks(final Set<BrickSkeleton> inputBrickSkeletonSet) {
        this.bricks = inputBrickSkeletonSet;
    }

    @Override
    public Set<BallSkeleton> getBalls() {
        return this.balls;
    }

    @Override
    public void setBalls(final Set<BallSkeleton> ballSkeletonSet) {
        this.balls = ballSkeletonSet;
    }

    @Override
    public void setPad(final PadSkeletonImpl padSkeleton) {
        this.pad = padSkeleton;
    }

    @Override
    public PadSkeletonImpl getPad() {
        return this.pad;
    }
}
