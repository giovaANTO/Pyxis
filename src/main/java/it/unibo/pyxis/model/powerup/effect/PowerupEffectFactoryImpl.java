package it.unibo.pyxis.model.powerup.effect;

import it.unibo.pyxis.model.arena.Arena;
import it.unibo.pyxis.model.element.ball.Ball;
import it.unibo.pyxis.model.element.ball.BallType;
import it.unibo.pyxis.model.element.factory.ElementFactory;
import it.unibo.pyxis.model.element.factory.ElementFactoryImpl;
import it.unibo.pyxis.model.util.Vector;

import java.util.Random;
import java.util.function.Consumer;

import static it.unibo.pyxis.model.powerup.effect.PowerupEffectType.ARENA_POWERUP;
import static it.unibo.pyxis.model.powerup.effect.PowerupEffectType.BALL_POWERUP;
import static it.unibo.pyxis.model.powerup.effect.PowerupEffectType.PAD_POWERUP;

public final class PowerupEffectFactoryImpl implements PowerupEffectFactory {

    private static final int MAX_APPLICABLE_ANGLE = 350;
    private static final int MIN_APPLICABLE_ANGLE = 190;

    /**
     * Creates a new generic {@link PowerupEffect}.
     *
     * @param type The {@link PowerupEffectType} of effect to create.
     * @param apply A {@link Consumer<Arena>} used for apply the effect.
     * @param remove A {@link Consumer<Arena>} used for remove the previously
     *               applied effect.
     * @param time The effect application time in seconds.
     * @return A new instance of {@link PowerupEffect}.
     */
    private PowerupEffect createEffect(final PowerupEffectType type, final Consumer<Arena> apply,
                                       final Consumer<Arena> remove, final int time) {
        return new PowerupEffect() {
            /**
             * {@inheritDoc}
             */
            @Override
            public void applyEffect(final Arena arena) {
                apply.accept(arena);
            }
            /**
             * {@inheritDoc}
             */
            @Override
            public int getApplyTime() {
                return time;
            }
            /**
             * {@inheritDoc}
             */
            @Override
            public PowerupEffectType getType() {
                return type;
            }
            /**
             * {@inheritDoc}
             */
            @Override
            public void removeEffect(final Arena arena) {
                remove.accept(arena);
            }
        };
    }
    /**
     *
     * @return
     */
    private double randomAngle() {
        Random r = new Random();
        return r.nextInt((MAX_APPLICABLE_ANGLE - MIN_APPLICABLE_ANGLE) + 1) + MIN_APPLICABLE_ANGLE;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public PowerupEffect atomicBallEffect(final int applicationTime) {
        final Consumer<Arena> applier = arena -> arena.getBalls().forEach(b -> b.setType(BallType.ATOMIC_BALL));
        final Consumer<Arena> remover = arena -> arena.getBalls().forEach(b -> b.setType(BallType.NORMAL_BALL));
        return this.createEffect(BALL_POWERUP, applier, remover, applicationTime);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public PowerupEffect modifyPadWidthEffect(final int applicationTime, final double increaseVal) {
        final Consumer<Arena> applier = arena -> arena.increasePadWidth(increaseVal);
        final Consumer<Arena> remover = arena -> arena.decreasePadWidth(increaseVal);
        return this.createEffect(PAD_POWERUP, applier, remover, applicationTime);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public PowerupEffect spawnBalls() {

        final Consumer<Arena> applier = arena -> {
            final Ball arenaRandomBall = arena.getRandomBall();
            final Vector pace = arenaRandomBall.getPace();
            final ElementFactory factory = new ElementFactoryImpl();
            arena.addBall(factory.copyBallWithAngle(arenaRandomBall, this.randomAngle(), arena.getLastBallId() + 1));
            arena.addBall(factory.copyBallWithAngle(arenaRandomBall, this.randomAngle(), arena.getLastBallId() + 2));
        };
        final Consumer<Arena> remover = arena -> { };
        return this.createEffect(ARENA_POWERUP, applier, remover, 0);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public PowerupEffect steelBall(final int applicationTime) {
        final Consumer<Arena> applier = arena -> arena.getBalls().forEach(b -> b.setType(BallType.STEEL_BALL));
        final Consumer<Arena> remover = arena -> arena.getBalls().forEach(b -> b.setType(BallType.NORMAL_BALL));
        return this.createEffect(BALL_POWERUP, applier, remover, applicationTime);
    }
}
