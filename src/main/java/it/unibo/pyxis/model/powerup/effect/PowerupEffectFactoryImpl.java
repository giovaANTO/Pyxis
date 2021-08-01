package it.unibo.pyxis.model.powerup.effect;

import it.unibo.pyxis.model.arena.Arena;
import it.unibo.pyxis.model.element.ball.Ball;
import it.unibo.pyxis.model.element.ball.BallImpl;
import it.unibo.pyxis.model.element.ball.BallType;
import it.unibo.pyxis.model.util.Vector;

import java.util.function.Consumer;

import static it.unibo.pyxis.model.powerup.effect.PowerupEffectType.*;

public final class PowerupEffectFactoryImpl implements PowerupEffectFactory {

    private PowerupEffect createEffect(final PowerupEffectType type, final Consumer<Arena> apply,
                                       final Consumer<Arena> remove, final int time) {
        return new PowerupEffect() {
            @Override
            public void applyEffect(final Arena arena) {
                apply.accept(arena);
            }

            @Override
            public void removeEffect(final Arena arena) {
                remove.accept(arena);
            }

            @Override
            public int getApplyTime() {
                return time;
            }

            @Override
            public PowerupEffectType getType() {
                return type;
            }
        };
    }

    @Override
    public PowerupEffect modifyPadWidthEffect(final int applicationTime, final double increaseVal) {
        return this.createEffect(
                PAD_POWERUP,
                arena -> arena.getPad().setWidth(arena.getPad().getDimension().getWidth() + increaseVal),
                arena -> arena.getPad().setWidth(arena.getPad().getDimension().getWidth() - increaseVal),
                applicationTime
        );
    }

    @Override
    public PowerupEffect atomicBallEffect(final int applicationTime) {
        return this.createEffect(
                BALL_POWERUP,
                arena -> arena.getBalls().forEach(b -> b.setType(BallType.ATOMIC_BALL)),
                arena -> arena.getBalls().forEach(b -> b.setType(BallType.NORMAL_BALL)),
                applicationTime
        );
    }

    @Override
    public PowerupEffect steelBall(final int applicationTime) {
        return this.createEffect(
                BALL_POWERUP,
                arena -> arena.getBalls().forEach(b -> b.setType(BallType.ATOMIC_BALL)),
                arena -> arena.getBalls().forEach(b -> b.setType(BallType.NORMAL_BALL)),
                applicationTime
        );
    }

    @Override
    public PowerupEffect spawnBalls() {
        return this.createEffect(
                ARENA_POWERUP,
                arena -> {
                    final Ball arenaRandomBall = arena.getRandomBall();
                    final Vector pace = arenaRandomBall.getPace();

                    final Ball randomBall1 = new BallImpl.Builder()
                            .pace(pace.rotationBy(-90.0))
                            .initialPosition(arenaRandomBall.getPosition())
                            .ballType(BallType.NORMAL_BALL)
                            .id(arena.getLastBallId() + 1)
                            .build();
                    final Ball randomBall2 = new BallImpl.Builder()
                            .pace(pace.rotationBy(90.0))
                            .initialPosition(arenaRandomBall.getPosition())
                            .ballType(BallType.NORMAL_BALL)
                            .id(arena.getLastBallId() + 2)
                            .build();
                    arena.addBall(randomBall1);
                    arena.addBall(randomBall2);
                },
                arena -> { },
                0
        );
    }
}
