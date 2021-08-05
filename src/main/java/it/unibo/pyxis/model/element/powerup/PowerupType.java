package it.unibo.pyxis.model.element.powerup;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import it.unibo.pyxis.model.powerup.effect.PowerupEffect;
import it.unibo.pyxis.model.powerup.effect.PowerupEffectFactory;
import it.unibo.pyxis.model.powerup.effect.PowerupEffectFactoryImpl;

public enum PowerupType {

    /**
     * {@link Powerup} that increase the length of the {@link it.unibo.pyxis.model.element.pad.Pad}.
     */
    INCREASE_PAD {
        @Override
        public PowerupEffect getEffect() {
           final PowerupEffectFactory factory = new PowerupEffectFactoryImpl();
           return factory.modifyPadWidthEffect(STD_APP_TIME, PAD_MOD_FACTOR);
        }
    },

    /**
     * {@link Powerup} that decrease the length of the {@link it.unibo.pyxis.model.element.pad.Pad}.
     */
    DECREASE_PAD {
        @Override
        public PowerupEffect getEffect() {
            final PowerupEffectFactory factory = new PowerupEffectFactoryImpl();
            return factory.modifyPadWidthEffect(STD_APP_TIME, -PAD_MOD_FACTOR);
        }
    },

    /**
     * {@link Powerup} that set the {@link it.unibo.pyxis.model.element.ball.Ball}s as atomic.
     */
    ATOMIC_BALL {
        @Override
        public PowerupEffect getEffect() {
            final PowerupEffectFactory factory = new PowerupEffectFactoryImpl();
            return factory.atomicBallEffect(STD_APP_TIME);
        }
    },

    /**
     * {@link Powerup} that set the {@link it.unibo.pyxis.model.element.ball.Ball}s as atomic.
     */
    STEEL_BALL {
        @Override
        public PowerupEffect getEffect() {
            final PowerupEffectFactory factory = new PowerupEffectFactoryImpl();
            return factory.steelBall(STD_APP_TIME);
        }
    },

    /**
     * {@link Powerup} that spawns multiple {@link it.unibo.pyxis.model.element.ball.Ball}s
     * in the {@link it.unibo.pyxis.model.arena.Arena}.
     */
    MULTIPLE_BALLS {
        @Override
        public PowerupEffect getEffect() {
            final PowerupEffectFactory factory = new PowerupEffectFactoryImpl();
            return factory.spawnBalls();
        }
    };

    private static final int STD_APP_TIME = 20;
    private static final int PAD_MOD_FACTOR = 40;

    /**
     * Return the {@link Powerup} effect associated to a {@link PowerupType}.
     * @return effect
     *                  The powerup effect.
     */
    public abstract PowerupEffect getEffect();
}
