package it.unibo.pyxis.element.powerup;

import it.unibo.pyxis.element.powerup.effect.PowerupEffect;
import it.unibo.pyxis.element.powerup.effect.PowerupEffectFactory;
import it.unibo.pyxis.element.powerup.effect.PowerupEffectFactoryImpl;

public enum PowerupType {
    /**
     * Powerup that increase the length of the pad .
     */
    INCREASE_PAD {
        @Override
        public PowerupEffect getEffect() {
            final PowerupEffectFactory factory = new PowerupEffectFactoryImpl();
            return factory.modifyPadWidth(10, 4);
        }
    },
    /**
     * Powerup that decrease the length of the pad .
     */
    DECREASE_PAD {
        @Override
        public PowerupEffect getEffect() {
            final PowerupEffectFactory factory = new PowerupEffectFactoryImpl();
            return factory.modifyPadWidth(10, -4);
        }
    };

    /**
     * Return the Powerup effect associated to a PowerupType.
     * @return effect
     *                  The powerup effect.
     */
    public abstract PowerupEffect getEffect();
}
