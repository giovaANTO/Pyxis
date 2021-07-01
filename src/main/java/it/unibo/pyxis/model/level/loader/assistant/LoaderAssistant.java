package it.unibo.pyxis.model.level.loader.assistant;

import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.model.level.loader.skeleton.level.LevelSkeleton;

public interface LoaderAssistant {
    /**
     * Create a new {@link Level} instance from an {@link LevelSkeleton}.
     * @param skeleton
     *                  The input {@link LevelSkeleton}
     * @return
     *                  An instance of the {@link Level}
     */
    Level createLevel(LevelSkeleton skeleton);
}

