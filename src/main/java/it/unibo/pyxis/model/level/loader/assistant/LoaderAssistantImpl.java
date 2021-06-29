package it.unibo.pyxis.model.level.loader.assistant;

import it.unibo.pyxis.model.arena.Arena;
import it.unibo.pyxis.model.arena.ArenaImpl;
import it.unibo.pyxis.model.element.brick.Brick;
import it.unibo.pyxis.model.element.brick.BrickImpl;
import it.unibo.pyxis.model.element.brick.BrickType;
import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.model.level.LevelImpl;
import it.unibo.pyxis.model.level.loader.skeleton.level.LevelSkeleton;
import it.unibo.pyxis.model.level.loader.skeleton.brick.BrickSkeleton;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.CoordImpl;
import it.unibo.pyxis.model.util.DimensionImpl;

import java.util.Arrays;

public final class LoaderAssistantImpl implements LoaderAssistant {

    @Override
    public Level createLevel(final LevelSkeleton skeleton) {
        return new LevelImpl(skeleton.getLives(), this.arenaFromSkeleton(skeleton));
    }

    /**
     * Create an {@link Arena} instance from a skeleton.
     * @param skeleton
     *                  An {@link LevelSkeleton} object that contains the information about the {@link Arena}
     *                  that should be created.
     * @return
     *                  An instance of {@link Arena}
     */
    private Arena arenaFromSkeleton(final LevelSkeleton skeleton) {
        final Arena outputArena = new ArenaImpl(new DimensionImpl(skeleton.getWidth(), skeleton.getHeight()));
        skeleton.getBricks().forEach(bs -> outputArena.addBrick(this.brickFromSkeleton(bs)));
        return outputArena;
    }

    /**
     * Create a {@link Brick} instance from a skeleton.
     * @param skeleton
     *                A {@link BrickSkeleton} object that contains the information about the {@link Brick}
     *                that should be created.
     * @return
     *                An instance of {@link Brick}
     */
    private Brick brickFromSkeleton(final BrickSkeleton skeleton) {
        final Coord brickCoord = new CoordImpl(skeleton.getX(), skeleton.getY());
        final BrickType brickType = this.getBrickType(skeleton.getType());
        return new BrickImpl(brickType, brickCoord);
    }

    /**
     * Get a {@link BrickType} from a type string loaded in a skeleton.
     * @param typeString
     *                 A type string loaded from a skeleton
     * @return
     *                  A {@link BrickType}
     */
    private BrickType getBrickType(final String typeString) {
        return Arrays.stream(BrickType.values())
                .filter(t -> t.getTypeString().equals(typeString))
                .findFirst()
                .orElseThrow();
    }
}
