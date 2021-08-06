package it.unibo.pyxis.model.powerup.effect;

import it.unibo.pyxis.model.arena.Arena;
import it.unibo.pyxis.model.element.ball.Ball;
import it.unibo.pyxis.model.element.ball.BallType;
import it.unibo.pyxis.model.element.factory.ElementFactory;
import it.unibo.pyxis.model.element.factory.ElementFactoryImpl;
import it.unibo.pyxis.model.util.Vector;

import java.util.function.Consumer;

import static it.unibo.pyxis.model.powerup.effect.PowerupEffectType.ARENA_POWERUP;
import static it.unibo.pyxis.model.powerup.effect.PowerupEffectType.BALL_POWERUP;
import static it.unibo.pyxis.model.powerup.effect.PowerupEffectType.PAD_POWERUP;

public final class PowerupEffectFactoryImpl implements PowerupEffectFactory {

    /**
     *
     * @param type
     *
     * @param apply
     *
     * @param remove
     *
     * @param time
     *
     * @return
     *
     */
    private PowerupEffect createEffect(final PowerupEffectType type, final Consumer<Arena> apply,
                                       final Consumer<Arena> remove, final int time) {
        return new PowerupEffect() {
            @Override
            public void applyEffect(final Arena arena) {
                apply.accept(arena);
            }

            @Override
            public int getApplyTime() {
                return time;
            }

            @Override
            public PowerupEffectType getType() {
                return type;
            }

            @Override
            public void removeEffect(final Arena arena) {
                remove.accept(arena);
            }
        };
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public PowerupEffect atomicBallEffect(final int applicationTime) {
        return this.createEffect(
                BALL_POWERUP,
                arena -> arena.getBalls().forEach(b -> b.setType(BallType.ATOMIC_BALL)),
                arena -> arena.getBalls().forEach(b -> b.setType(BallType.NORMAL_BALL)),
                applicationTime
        );
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public PowerupEffect modifyPadWidthEffect(final int applicationTime, final double increaseVal) {
        return this.createEffect(
                PAD_POWERUP,
                arena -> arena.increasePadWidth(increaseVal),
                arena -> arena.decreasePadWidth(increaseVal),
                applicationTime
        );
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public PowerupEffect spawnBalls() {
        return this.createEffect(
                ARENA_POWERUP,
                arena -> {
                    final Ball arenaRandomBall = arena.getRandomBall();
                    final Vector pace = arenaRandomBall.getPace();
                    final ElementFactory factory = new ElementFactoryImpl();
                    arena.addBall(factory.copyBallWithAngle(arenaRandomBall, -90.0, arena.getLastBallId() + 1));
                    arena.addBall(factory.copyBallWithAngle(arenaRandomBall, 90.0, arena.getLastBallId() + 2));
                },
                arena -> {
                },
                0
        );
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public PowerupEffect steelBall(final int applicationTime) {
        return this.createEffect(
                BALL_POWERUP,
                arena -> arena.getBalls().forEach(b -> b.setType(BallType.STEEL_BALL)),
                arena -> arena.getBalls().forEach(b -> b.setType(BallType.NORMAL_BALL)),
                applicationTime
        );
    }
}
