package it.unibo.pyxis.model.level.loader.skeleton;

import it.unibo.pyxis.model.util.Dimension;

import java.util.Set;

public interface ArenaSkeleton {
    /**
     * Return the number of lives of the {@link it.unibo.pyxis.model.arena.Arena}.
     * @return
     *          The number of lives.
     */
    int getLives();

    /**
     * Set the number of lives for the {@link it.unibo.pyxis.model.arena.Arena}.
     * @param lives
     *              The lives number
     */
    void setLives(int lives);

    /**
     * Return the {@link it.unibo.pyxis.model.arena.Arena} dimensions.
     * @return
     *          A {@link Dimension} instance
     */
    Dimension getDimension();

    /**
     * Set a {@link Dimension} for the {@link it.unibo.pyxis.model.arena.Arena}.
     * @param dimension
     *           The {@link Dimension} to set.
     */
    void setDimension(Dimension dimension);

    /**
     * Return a {@link Set} of {@link BrickSkeleton} linked to this {@link ArenaSkeleton}.
     * @return
     *          {@link Set} of {@link BrickSkeleton}
     */
    Set<BrickSkeleton> getBrickSkeletonSet();

    /**
     * Set a new {@link Set} of {@link BrickSkeleton}.
     * @param brickSkeletonSet
     *           {@link Set} of {@link BrickSkeleton}
     */
    void setBrickSkeletonSet(Set<BrickSkeleton> brickSkeletonSet);
}
