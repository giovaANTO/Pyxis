package it.unibo.pyxis.model.level.loader.assistant;

import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.model.level.loader.skeleton.ArenaSkeleton;

public interface LoaderAssistant {
    /**
     * Create a new {@link Level} instance from an {@link ArenaSkeleton}.
     * @param skeleton
     *                  The input {@link ArenaSkeleton}
     * @return
     *                  An instance of the {@link Level}
     */
    Level createLevel(ArenaSkeleton skeleton);
}

