package it.unibo.pyxis.model.element.powerup;

import it.unibo.pyxis.model.powerup.effect.PowerupEffect;
import it.unibo.pyxis.model.powerup.effect.PowerupEffectFactory;
import it.unibo.pyxis.model.powerup.effect.PowerupEffectFactoryImpl;

public enum PowerupType {
    /**
     * The {@link Powerup} that set the {@link it.unibo.pyxis.model.element.ball.Ball}s'
     * {@link it.unibo.pyxis.model.element.ball.BallType} as ATOMIC.
     */
    ATOMIC_BALL {
        @Override
        public PowerupEffect getEffect() {
            final PowerupEffectFactory factory = new PowerupEffectFactoryImpl();
            return factory.atomicBallEffect(STD_APP_TIME);
        }
    },

    /**
     * The {@link Powerup} that decrease the length of the
     * {@link it.unibo.pyxis.model.element.pad.Pad}.
     */
    DECREASE_PAD {
        @Override
        public PowerupEffect getEffect() {
            final PowerupEffectFactory factory = new PowerupEffectFactoryImpl();
            return factory.modifyPadWidthEffect(STD_APP_TIME, -PAD_MOD_FACTOR);
        }
    },

    /**
     * The {@link Powerup} that increase the length of the
     * {@link it.unibo.pyxis.model.element.pad.Pad}.
     */
    INCREASE_PAD {
        @Override
        public PowerupEffect getEffect() {
           final PowerupEffectFactory factory = new PowerupEffectFactoryImpl();
           return factory.modifyPadWidthEffect(STD_APP_TIME, PAD_MOD_FACTOR);
        }
    },

    /**
     * The {@link Powerup} that spawns multiple
     * {@link it.unibo.pyxis.model.element.ball.Ball}s in the
     * {@link it.unibo.pyxis.model.arena.Arena}.
     */
    MULTIPLE_BALLS {
        @Override
        public PowerupEffect getEffect() {
            final PowerupEffectFactory factory = new PowerupEffectFactoryImpl();
            return factory.spawnBalls();
        }
    },

    /**
     * The {@link Powerup} that set the {@link it.unibo.pyxis.model.element.ball.Ball}s'
     * {@link it.unibo.pyxis.model.element.ball.BallType} as STEEL.
     */
    STEEL_BALL {
        @Override
        public PowerupEffect getEffect() {
            final PowerupEffectFactory factory = new PowerupEffectFactoryImpl();
            return factory.steelBall(STD_APP_TIME);
        }
    };

    private static final int STD_APP_TIME = 10;
    private static final int PAD_MOD_FACTOR = 40;

    /**
     * Returns the {@link Powerup} effect associated to a {@link PowerupType}.
     *
     * @return effect The {@link Powerup} effect.
     */
    public abstract PowerupEffect getEffect();
}
