package it.unibo.pyxis.model.level.loader.assistant;

import it.unibo.pyxis.model.arena.Arena;
import it.unibo.pyxis.model.arena.ArenaImpl;
import it.unibo.pyxis.model.element.ball.Ball;
import it.unibo.pyxis.model.element.ball.BallImpl;
import it.unibo.pyxis.model.element.ball.BallType;
import it.unibo.pyxis.model.element.brick.Brick;
import it.unibo.pyxis.model.element.brick.BrickType;
import it.unibo.pyxis.model.element.factory.ElementFactory;
import it.unibo.pyxis.model.element.factory.ElementFactoryImpl;
import it.unibo.pyxis.model.element.pad.Pad;
import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.model.level.LevelImpl;
import it.unibo.pyxis.model.level.loader.skeleton.ball.BallSkeleton;
import it.unibo.pyxis.model.level.loader.skeleton.level.LevelSkeleton;
import it.unibo.pyxis.model.level.loader.skeleton.brick.BrickSkeleton;
import it.unibo.pyxis.model.level.loader.skeleton.pad.PadSkeleton;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.CoordImpl;
import it.unibo.pyxis.model.util.DimensionImpl;
import it.unibo.pyxis.model.util.VectorImpl;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

public final class LoaderAssistantImpl implements LoaderAssistant {

    private final ElementFactory elementFactory = new ElementFactoryImpl();

    /**
     * Creates an {@link Arena} instance from a skeleton.
     *
     * @param skeleton An {@link LevelSkeleton} object that contains the information
     *                 about the {@link Arena} that should be created.
     * @return An instance of {@link Arena}
     */
    private Arena arenaFromSkeleton(final LevelSkeleton skeleton) {
        final Arena outputArena = new ArenaImpl(new DimensionImpl(skeleton.getWidth(), skeleton.getHeight()));
        final Set<BrickSkeleton> brickSkeletonSet = skeleton.getBricks();
        final Set<BallSkeleton> ballSkeletonSet = skeleton.getBalls();
        if (!Objects.isNull(brickSkeletonSet)) {
            brickSkeletonSet.forEach(bs -> outputArena.addBrick(this.brickFromSkeleton(bs)));
        }
        if (!Objects.isNull(ballSkeletonSet)) {
           ballSkeletonSet.forEach(bls -> outputArena.addBall(this.ballFromSkeleton(bls)));
        }
        if (!Objects.isNull(skeleton.getPad())) {
            outputArena.setPad(this.padFromSkeleton(skeleton.getPad()));
        }
        return outputArena;
    }
    /**
     * Creates a {@link Ball} instance from a skeleton.
     *
     * @param skeleton A {@link BallSkeleton} object that contains the information
     *                 about the {@link Ball} that should be created.
     * @return An instance of a {@link Ball}.
     */
    private Ball ballFromSkeleton(final BallSkeleton skeleton) {
        return new BallImpl.Builder()
                .pace(new VectorImpl(skeleton.getPaceX(), skeleton.getPaceY()))
                .initialPosition(new CoordImpl(skeleton.getX(), skeleton.getY()))
                .ballType(this.getBallType(skeleton.getBallType()))
                .id(skeleton.getId())
                .build();
    }
    /**
     * Creates a {@link Brick} instance from a skeleton.
     *
     * @param skeleton A {@link BrickSkeleton} object that contains the information
     *                about the {@link Brick} that should be created.
     * @return An instance of a {@link Brick}.
     */
    private Brick brickFromSkeleton(final BrickSkeleton skeleton) {
        final Coord brickCoord = new CoordImpl(skeleton.getX(), skeleton.getY());
        final BrickType brickType = this.getBrickType(skeleton.getType());
        return this.elementFactory.createBrickFromType(brickType, brickCoord);
    }
    /**
     * Get a {@link BallType} from a type string loaded in a skeleton.
     *
     * @param typeString A type string loaded from a skeleton.
     * @return A {@link BallType}.
     */
    private BallType getBallType(final String typeString) {
        return Arrays.stream(BallType.values())
                .filter(t -> t.getType().equals(typeString))
                .findFirst()
                .orElseThrow();
    }
    /**
     * Gets a {@link BrickType} from a type string loaded in a skeleton.
     *
     * @param typeString A type string loaded from a skeleton.
     * @return A {@link BrickType}.
     */
    private BrickType getBrickType(final String typeString) {
        return Arrays.stream(BrickType.values())
                .filter(t -> t.getTypeString().equals(typeString))
                .findFirst()
                .orElseThrow();
    }
    /**
     * Creates a {@link Pad} instance from a skeleton.
     *
     * @param skeleton A {@link BrickSkeleton} object that contains the information
     *                 about the {@link Pad} that should be created.
     * @return An instance of a {@link Pad}.
     */
    private Pad padFromSkeleton(final PadSkeleton skeleton) {
        return this.elementFactory.createDefaultPad(new CoordImpl(skeleton.getX(), skeleton.getY()));
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Level createLevel(final LevelSkeleton skeleton) {
        return new LevelImpl(skeleton.getLives(), this.arenaFromSkeleton(skeleton), skeleton.getLevelNumber());
    }
}
