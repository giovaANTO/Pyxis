package it.unibo.pyxis.powerup.effect;

import it.unibo.pyxis.arena.Arena;
import it.unibo.pyxis.element.ball.BallType;
import java.util.function.Consumer;
import static it.unibo.pyxis.powerup.effect.PowerupEffectType.BALL_POWERUP;
import static it.unibo.pyxis.powerup.effect.PowerupEffectType.PAD_POWERUP;

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
                arena -> arena.getPad().getDimension().increaseWidth(increaseVal),
                arena -> arena.getPad().getDimension().increaseWidth(-increaseVal),
                applicationTime
        );
    }

    @Override
    public PowerupEffect atomicBallEffect(final int applicationTime) {
        return this.createEffect(
                BALL_POWERUP,
                arena -> arena.getBallStream().forEach(b -> b.setType(BallType.ATOMIC_BALL)),
                arena -> arena.getBallStream().forEach(b -> b.setType(BallType.NORMAL_BALL)),
                applicationTime
        );
    }

    @Override
    public PowerupEffect steelBall(final int applicationTime) {
        return this.createEffect(
                BALL_POWERUP,
                arena -> arena.getBallStream().forEach(b -> b.setType(BallType.ATOMIC_BALL)),
                arena -> arena.getBallStream().forEach(b -> b.setType(BallType.NORMAL_BALL)),
                applicationTime
        );
    }
}
