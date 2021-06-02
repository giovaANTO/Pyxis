package it.unibo.pyxis.model.level.loader.skeleton;

import it.unibo.pyxis.model.util.Dimension;
import java.util.Set;

public final class ArenaSkeletonImpl implements ArenaSkeleton {

    private int lives;
    private Dimension dimension;
    private Set<BrickSkeleton> brickSkeletonSet;

    @Override
    public int getLives() {
        return this.lives;
    }

    @Override
    public void setLives(final int lives) {
        this.lives = lives;
    }

    @Override
    public Dimension getDimension() {
        return this.dimension;
    }

    @Override
    public void setDimension(final Dimension dimension) {
        this.dimension = dimension;
    }

    @Override
    public Set<BrickSkeleton> getBrickSkeletonSet() {
        return this.brickSkeletonSet;
    }

    @Override
    public void setBrickSkeletonSet(final Set<BrickSkeleton> brickSkeletonSet) {
        this.brickSkeletonSet = brickSkeletonSet;
    }
}
