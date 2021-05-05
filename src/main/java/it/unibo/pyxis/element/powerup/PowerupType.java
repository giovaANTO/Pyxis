package it.unibo.pyxis.element.powerup;

import it.unibo.pyxis.powerup.effect.PowerupEffect;
import it.unibo.pyxis.powerup.effect.PowerupEffectFactory;
import it.unibo.pyxis.powerup.effect.PowerupEffectFactoryImpl;

public enum PowerupType {
    /**
     * Powerup that increase the length of the pad .
     */
    INCREASE_PAD {
        @Override
        public PowerupEffect getEffect() {
           final PowerupEffectFactory factory = new PowerupEffectFactoryImpl();
           return factory.modifyPadWidth(PAD_MOD_TIME, PAD_MOD_FACTOR);
        }
    },
    /**
     * Powerup that decrease the length of the pad .
     */
    DECREASE_PAD {
        @Override
        public PowerupEffect getEffect() {
            final PowerupEffectFactory factory = new PowerupEffectFactoryImpl();
            return factory.modifyPadWidth(PAD_MOD_TIME, -PAD_MOD_FACTOR);
        }
    };

    /**
     * Return the Powerup effect associated to a PowerupType.
     * @return effect
     *                  The powerup effect.
     */
    public abstract PowerupEffect getEffect();
    private static final int PAD_MOD_TIME = 10;
    private static final int PAD_MOD_FACTOR = 2;
}
