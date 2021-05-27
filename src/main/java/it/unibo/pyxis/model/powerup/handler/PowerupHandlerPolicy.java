package it.unibo.pyxis.model.powerup.handler;

import it.unibo.pyxis.model.powerup.effect.PowerupEffectType;
import java.util.Map;

@FunctionalInterface
public interface PowerupHandlerPolicy {
    /**
     * Express the policy that should be applied before register any other
     * powerup thread in the application.
     * @param type
     *              The type of powerup that is going to be applied
     * @param map
     *              A map where keys are thread ids and values are the threads
     */
    void execute(PowerupEffectType type, Map<Long, Thread> map);
}
