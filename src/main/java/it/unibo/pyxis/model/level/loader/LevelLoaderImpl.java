package it.unibo.pyxis.model.level.loader;

import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.model.level.loader.assistant.LoaderAssistant;
import it.unibo.pyxis.model.level.loader.assistant.LoaderAssistantImpl;
import it.unibo.pyxis.model.level.loader.skeleton.ball.BallSkeletonImpl;
import it.unibo.pyxis.model.level.loader.skeleton.brick.BrickSkeletonImpl;
import it.unibo.pyxis.model.level.loader.skeleton.level.LevelSkeleton;
import it.unibo.pyxis.model.level.loader.skeleton.level.LevelSkeletonImpl;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.util.Formatter;

public final class LevelLoaderImpl implements LevelLoader {

    private final String configurationDirectory;
    private final LoaderAssistant loaderAssistant;

    public LevelLoaderImpl(final String configurationDirectory) {
        this.configurationDirectory = configurationDirectory;
        this.loaderAssistant = new LoaderAssistantImpl();
    }
    /**
     *
     * @param filename
     * @return
     */
    private String getFilePath(final String filename) {
        final Formatter formatter = new Formatter();
        return formatter.format("/%s/%s", this.configurationDirectory, filename).toString();
    }
    /**
     * Create a skeleton file from a yaml source.
     *
     * @param filename
     *          The yaml file name used for loading the level.
     * @return
     *          A {@link LevelSkeleton} object with the loaded data.
     */
    private LevelSkeleton skeletonFromFile(final String filename) {
        try (InputStream stream = this.getClass().getResourceAsStream(this.getFilePath(filename))) {
            final Constructor yamlConstructor = new Constructor(LevelSkeletonImpl.class);
            final TypeDescription constructorDescriptor = new TypeDescription(LevelSkeletonImpl.class);
            constructorDescriptor.putListPropertyType("balls", BallSkeletonImpl.class);
            constructorDescriptor.putListPropertyType("bricks", BrickSkeletonImpl.class);
            yamlConstructor.addTypeDescription(constructorDescriptor);
            final Yaml yamlConfLoader = new Yaml(yamlConstructor);
            return (LevelSkeleton) yamlConfLoader.load(stream);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return new LevelSkeletonImpl();
    }
    @Override
    public Level fromFile(final String filename) {
        return loaderAssistant.createLevel(this.skeletonFromFile(filename));
    }
}
