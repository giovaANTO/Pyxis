package it.unibo.pyxis.element.powerup.effect;

import it.unibo.pyxis.arena.Arena;

public abstract class AbstractPowerupEffect implements PowerupEffect {

    private final Arena arena;

    public AbstractPowerupEffect(final Arena inputArena) {
        this.arena = inputArena;
    }

    @Override
    public abstract void applyEffects(Arena arena);
    @Override
    public abstract void removeEffects(Arena arena);

    @Override
    public void apply() {
        new Thread(this.getRunnable()).start();
    }

    /**
     * Return the body of the powerup thread.
     * @return the Runnable function rappresenting the powerup thread
     */
    private Runnable getRunnable() {
        return () -> {
            try {
                this.applyEffects(this.arena);
                Thread.sleep(this.getTime());
                this.removeEffects(this.arena);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    };

}
