package it.unibo.pyxis.element.powerup.effect;

import it.unibo.pyxis.arena.Arena;
import java.util.function.Consumer;

public final class PowerupEffectFactoryImpl implements PowerupEffectFactory {

    private PowerupEffect createPowerup(final long applicationTime, final Consumer<Arena> apply, final Consumer<Arena> remove) {
        return arena ->
                new Thread(() -> {
                    try {
                        apply.accept(arena);
                        Thread.sleep(applicationTime);
                        remove.accept(arena);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
    }

    @Override
    public PowerupEffect modifyPadWidth(final long applicationTime, final double increaseVal) {
        return this.createPowerup(
                applicationTime,
                arena -> arena.getPad().getDimension().increaseWidth(increaseVal),
                arena -> arena.getPad().getDimension().increaseWidth(increaseVal)
        );
    }
}
