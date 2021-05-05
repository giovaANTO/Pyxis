package it.unibo.pyxis.element.powerup;

import it.unibo.pyxis.powerup.effect.PowerupEffect;

public enum PowerupType {
    /**
     * Powerup that increase the length of the pad .
     */
    INCREASE_PAD {
        @Override
        public PowerupEffect getEffect() {
           return null;
        }
    },
    /**
     * Powerup that decrease the length of the pad .
     */
    DECREASE_PAD {
        @Override
        public PowerupEffect getEffect() {
            return null;
        }
    };

    /**
     * Return the Powerup effect associated to a PowerupType.
     * @return effect
     *                  The powerup effect.
     */
    public abstract PowerupEffect getEffect();
}
