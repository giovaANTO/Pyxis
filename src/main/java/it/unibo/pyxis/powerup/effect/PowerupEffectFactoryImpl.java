package it.unibo.pyxis.powerup.effect;

import it.unibo.pyxis.arena.Arena;
import java.util.function.Consumer;

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
        };
    }

    @Override
    public PowerupEffect modifyPadWidth(final int applicationTime, final double increaseVal) {
        return this.createEffect(
                PAD_POWERUP,
                arena -> arena.getPad().getDimension().increaseWidth(increaseVal),
                arena -> arena.getPad().getDimension().increaseWidth(-increaseVal),
                applicationTime
        );
    }
}
