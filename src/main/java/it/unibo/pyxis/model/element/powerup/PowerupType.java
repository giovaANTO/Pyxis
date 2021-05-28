package it.unibo.pyxis.model.element.powerup;

import it.unibo.pyxis.model.powerup.effect.PowerupEffect;
import it.unibo.pyxis.model.powerup.effect.PowerupEffectFactory;
import it.unibo.pyxis.model.powerup.effect.PowerupEffectFactoryImpl;

public enum PowerupType {
    /**
     * Powerup that increase the length of the pad .
     */
    INCREASE_PAD {
        @Override
        public PowerupEffect getEffect() {
           final PowerupEffectFactory factory = new PowerupEffectFactoryImpl();
           return factory.modifyPadWidthEffect(STD_APP_TIME, PAD_MOD_FACTOR);
        }
    },
    /**
     * Powerup that decrease the length of the pad .
     */
    DECREASE_PAD {
        @Override
        public PowerupEffect getEffect() {
            final PowerupEffectFactory factory = new PowerupEffectFactoryImpl();
            return factory.modifyPadWidthEffect(STD_APP_TIME, -PAD_MOD_FACTOR);
        }
    },

    /**
     * Powerup that set the balls as atomic.
     */
    ATOMIC_BALL {
        @Override
        public PowerupEffect getEffect() {
            final PowerupEffectFactory factory = new PowerupEffectFactoryImpl();
            return factory.atomicBallEffect(STD_APP_TIME);
        }
    },

    /**
     * Powerup that set the balls as atomic.
     */
    STEEL_BALL {
        @Override
        public PowerupEffect getEffect() {
            final PowerupEffectFactory factory = new PowerupEffectFactoryImpl();
            return factory.steelBall(STD_APP_TIME);
        }
    };

    private static final int STD_APP_TIME = 10;
    private static final int PAD_MOD_FACTOR = 2;

    /**
     * Return the Powerup effect associated to a PowerupType.
     * @return effect
     *                  The powerup effect.
     */
    public abstract PowerupEffect getEffect();
}
