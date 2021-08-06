package it.unibo.pyxis.model.level.loader.skeleton.level;

import it.unibo.pyxis.model.level.loader.skeleton.ball.BallSkeleton;
import it.unibo.pyxis.model.level.loader.skeleton.brick.BrickSkeleton;
import it.unibo.pyxis.model.level.loader.skeleton.pad.PadSkeleton;
import it.unibo.pyxis.model.level.loader.skeleton.pad.PadSkeletonImpl;

import java.util.Set;

public interface LevelSkeleton {
    /**
     * Return the {@link it.unibo.pyxis.model.level.Level} number.
     * @return
     *          An integer representing the input {@link it.unibo.pyxis.model.level.Level} number.
     */
    int getLevelNumber();

    /**
     * Set the {@link it.unibo.pyxis.model.level.Level} number.
     * @param number
     *              The input {@link it.unibo.pyxis.model.level.Level} number
     */
    void setLevelNumber(int number);

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
     * Return a {@link Set} of {@link BrickSkeleton} linked to this {@link LevelSkeleton}.
     * @return
     *          {@link Set} of {@link BrickSkeleton}
     */
    Set<BrickSkeleton> getBricks();

    /**
     * Set a new {@link Set} of {@link BrickSkeleton}.
     * @param brickSkeletonSet
     *           {@link Set} of {@link BrickSkeleton}
     */
    void setBricks(Set<BrickSkeleton> brickSkeletonSet);

    /**
     * Return a {@link Set} of {@link BallSkeleton} linked to this {@link LevelSkeleton}.
     * @return
     *          {@link Set} of {@link BallSkeleton}
     */
    Set<BallSkeleton> getBalls();

    /**
     * Set a new {@link Set} of {@link BallSkeleton}.
     * @param ballSkeletonSet
     *           {@link Set} of {@link BallSkeleton}
     */
    void setBalls(Set<BallSkeleton> ballSkeletonSet);

    /**
     * Set a new {@link PadSkeletonImpl}.
     * @param padSkeleton
     *            The {@link PadSkeletonImpl} to set
     */
    void setPad(PadSkeletonImpl padSkeleton);

    /**
     * Return the {@link PadSkeleton} linked to this {@link LevelSkeleton}.
     * @return
     *          The {@link PadSkeletonImpl}
     */
    PadSkeleton getPad();
}
