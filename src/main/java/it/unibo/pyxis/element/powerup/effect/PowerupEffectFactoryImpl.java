package it.unibo.pyxis.element.powerup.effect;

import it.unibo.pyxis.arena.Arena;

import java.util.function.Consumer;

public final class PowerupEffectFactoryImpl implements PowerupEffectFactory {
    
    private PowerupEffect createPowerup(final long time, final Consumer<Arena> apply, final Consumer<Arena> remove) {
        return arena ->
                new Thread(() -> {
                    try {
                        apply.accept(arena);
                        Thread.sleep(time);
                        remove.accept(arena);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
    }

    @Override
    public PowerupEffect enlargePad() { return null; }

    @Override
    public PowerupEffect reducePad() {
        return null;
    }

    @Override
    public PowerupEffect atomicBall() {
        return null;
    }

    @Override
    public PowerupEffect ironBall() {
        return null;
    }
}
