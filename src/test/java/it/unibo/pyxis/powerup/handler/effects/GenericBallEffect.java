package it.unibo.pyxis.powerup.handler.effects;

import it.unibo.pyxis.arena.Arena;
import it.unibo.pyxis.powerup.effect.PowerupEffect;
import it.unibo.pyxis.powerup.effect.PowerupEffectType;

/**
 * Represent a generic ball effect
 */
public class GenericBallEffect implements PowerupEffect {
    @Override
    public void applyEffect(Arena arena) {
        System.out.println("Apply effect on ball");
    }

    @Override
    public void removeEffect(Arena arena) {
        System.out.println("Remove effect on ball");
    }

    @Override
    public int getApplyTime() {
        return 2;
    }

    @Override
    public PowerupEffectType getType() {
        return PowerupEffectType.BALL_POWERUP;
    }
}
