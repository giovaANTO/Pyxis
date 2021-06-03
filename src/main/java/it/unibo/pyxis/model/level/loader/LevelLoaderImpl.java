package it.unibo.pyxis.model.level.loader;

import it.unibo.pyxis.model.arena.Arena;
import it.unibo.pyxis.model.arena.ArenaImpl;
import it.unibo.pyxis.model.element.brick.Brick;
import it.unibo.pyxis.model.element.brick.BrickImpl;
import it.unibo.pyxis.model.element.brick.BrickType;
import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.model.level.LevelImpl;
import it.unibo.pyxis.model.level.loader.skeleton.ArenaSkeleton;
import it.unibo.pyxis.model.level.loader.skeleton.ArenaSkeletonImpl;
import it.unibo.pyxis.model.level.loader.skeleton.BrickSkeleton;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.CoordImpl;
import it.unibo.pyxis.model.util.DimensionImpl;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.Objects;

public final class LevelLoaderImpl implements LevelLoader {

    private final URL configurationDirectory;

    public LevelLoaderImpl(final URL configurationDirectory) {
        if (!Objects.isNull(configurationDirectory)) {
            final File file = new File(configurationDirectory.getPath());
            if (!(file.exists() || file.isDirectory())) {
                throw new IllegalArgumentException("Invalid Url to directory");
            }
        }
        this.configurationDirectory = configurationDirectory;
    }

    @Override
    public URL getConfigurationDir() {
        return this.configurationDirectory;
    }

    @Override
    public Level fromFile(final String filename) {
        final ArenaSkeleton arenaSkeleton = this.skeletonFromFile(filename);
        return new LevelImpl(arenaSkeleton.getLives(), this.arenaFromSkeleton(arenaSkeleton));
    }

    /**
     * Create a skeleton file from a yaml source.
     * @param filename
     *                  The yaml file name used for loading the level
     * @return
     *          A {@link ArenaSkeleton} object with the loaded data.
     */
    private ArenaSkeleton skeletonFromFile(final String filename) {
        try (InputStream stream = new BufferedInputStream(new FileInputStream(this.getFile(filename)))) {
            final Yaml yamlConfLoader = new Yaml(new Constructor(ArenaSkeletonImpl.class));
            return (ArenaSkeleton) yamlConfLoader.load(stream);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return new ArenaSkeletonImpl();
    }

    /**
     * Get a configuration file from the config directory.
     * @param filename
     *                  The name of the file that should be opened with the relative extension.
     * @return
     *                  A new {@link File} instance.
     * @throws IllegalArgumentException
     *                  If file doesn't exists or isn't readable
     */
    private File getFile(final String filename) throws IllegalArgumentException {
        final File filePath = new File(this.configurationDirectory.getPath(), filename);
        if (!(filePath.exists() || filePath.canRead())) {
            throw new IllegalArgumentException("File : " + filename + " doesn't exists or isn't readable");
        }
        return filePath;
    }

    /**
     * Create an {@link Arena} instance from a skeleton.
     * @param skeleton
     *                  An {@link ArenaSkeleton} object that contains the information about the {@link Arena}
     *                  that should be created.
     * @return
     *                  An instance of {@link Arena}
     */
    private Arena arenaFromSkeleton(final ArenaSkeleton skeleton) {
        final Arena outputArena = new ArenaImpl(new DimensionImpl(skeleton.getWidth(), skeleton.getHeight()));
        skeleton.getBrickSkeletonSet().forEach(bs -> outputArena.addBrick(this.brickFromSkeleton(bs)));
        return outputArena;
    }

    /**
     * Create a {@link Brick} instance from a skeleton.
     * @param skeleton
     *                A {@link BrickSkeleton} object that contains the information about the {@link Arena}
     *                that should be created.
     * @return
     *                An instance of {@link Arena}
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
