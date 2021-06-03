package it.unibo.pyxis.model.level.loader.skeleton;

import java.util.Set;

public interface ArenaSkeleton {
    /**
     * Return the number of lives of the {@link it.unibo.pyxis.model.arena.Arena}.
     * @return
     *              The number of lives.
     */
    int getLives();

    /**
     * Set the number of lives for the {@link it.unibo.pyxis.model.arena.Arena}.
     * @param lives
     *              The lives number
     */
    void setLives(int lives);

    /**
     * Return the width of the {@link it.unibo.pyxis.model.arena.Arena}.
     * @return
     *              The width of the {@link it.unibo.pyxis.model.arena.Arena}
     */
    double getWidth();

    /**
     * Set the width of the {@link it.unibo.pyxis.model.arena.Arena}.
     * @param width
     *              The width of the {@link it.unibo.pyxis.model.arena.Arena}
     */
    void setWidth(double width);

    /**
     * Return the height of the {@link it.unibo.pyxis.model.arena.Arena}.
     * @return
     *              The height of the {@link it.unibo.pyxis.model.arena.Arena}
     */
    double getHeight();

    /**
     * Set the height of the {@link it.unibo.pyxis.model.arena.Arena}.
     * @param height
     *              The height of the {@link it.unibo.pyxis.model.arena.Arena}
     */
    void setHeight(double height);

    /**
     * Return a {@link Set} of {@link BrickSkeletonImpl} linked to this {@link ArenaSkeleton}.
     * @return
     *          {@link Set} of {@link BrickSkeletonImpl}
     */
    Set<BrickSkeletonImpl> getBrickSkeletonSet();

    /**
     * Set a new {@link Set} of {@link BrickSkeletonImpl}.
     * @param brickSkeletonSet
     *           {@link Set} of {@link BrickSkeletonImpl}
     */
    void setBrickSkeletonSet(Set<BrickSkeletonImpl> brickSkeletonSet);
}
