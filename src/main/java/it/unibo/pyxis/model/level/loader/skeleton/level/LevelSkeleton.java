package it.unibo.pyxis.model.level.loader.skeleton.level;

import it.unibo.pyxis.model.level.loader.skeleton.ball.BallSkeleton;
import it.unibo.pyxis.model.level.loader.skeleton.brick.BrickSkeleton;
import it.unibo.pyxis.model.level.loader.skeleton.pad.PadSkeleton;
import it.unibo.pyxis.model.level.loader.skeleton.pad.PadSkeletonImpl;

import java.util.Set;

public interface LevelSkeleton {
    /**
     * Returns a {@link Set} of {@link BallSkeleton} linked to this
     * {@link LevelSkeleton}.
     *
     * @return {@link Set} of {@link BallSkeleton}.
     */
    Set<BallSkeleton> getBalls();
    /**
     * Returns a {@link Set} of {@link BrickSkeleton} linked to this
     * {@link LevelSkeleton}.
     *
     * @return {@link Set} of {@link BrickSkeleton}.
     */
    Set<BrickSkeleton> getBricks();
    /**
     * Returns the height of the {@link it.unibo.pyxis.model.arena.Arena}.
     *
     * @return The height of the {@link it.unibo.pyxis.model.arena.Arena}.
     */
    double getHeight();
    /**
     * Returns the {@link it.unibo.pyxis.model.level.Level} number.
     *
     * @return An integer representing the input
     * {@link it.unibo.pyxis.model.level.Level} number.
     */
    int getLevelNumber();
    /**
     * Returns the number of lives of the {@link it.unibo.pyxis.model.arena.Arena}.
     *
     * @return The number of lives.
     */
    int getLives();
    /**
     * Returns the {@link PadSkeleton} linked to this {@link LevelSkeleton}.
     *
     * @return The {@link PadSkeletonImpl}.
     */
    PadSkeleton getPad();
    /**
     * Returns the width of the {@link it.unibo.pyxis.model.arena.Arena}.
     *
     * @return The width of the {@link it.unibo.pyxis.model.arena.Arena}.
     */
    double getWidth();
    /**
     * Sets a new {@link Set} of {@link BallSkeleton}.
     *
     * @param ballSkeletonSet {@link Set} of {@link BallSkeleton}.
     */
    void setBalls(Set<BallSkeleton> ballSkeletonSet);
    /**
     * Sets a new {@link Set} of {@link BrickSkeleton}.
     *
     * @param brickSkeletonSet {@link Set} of {@link BrickSkeleton}.
     */
    void setBricks(Set<BrickSkeleton> brickSkeletonSet);
    /**
     * Sets the height of the {@link it.unibo.pyxis.model.arena.Arena}.
     *
     * @param height The height of the {@link it.unibo.pyxis.model.arena.Arena}.
     */
    void setHeight(double height);
    /**
     * Sets the {@link it.unibo.pyxis.model.level.Level} number.
     *
     * @param number The input {@link it.unibo.pyxis.model.level.Level} number.
     */
    void setLevelNumber(int number);
    /**
     * Sets the number of lives for the {@link it.unibo.pyxis.model.arena.Arena}.
     *
     * @param lives The lives number.
     */
    void setLives(int lives);
    /**
     * Sets a new {@link PadSkeletonImpl}.
     *
     * @param padSkeleton The {@link PadSkeletonImpl} to set.
     */
    void setPad(PadSkeletonImpl padSkeleton);
    /**
     * Sets the width of the {@link it.unibo.pyxis.model.arena.Arena}.
     *
     * @param width The width of the {@link it.unibo.pyxis.model.arena.Arena}.
     */
    void setWidth(double width);
}
