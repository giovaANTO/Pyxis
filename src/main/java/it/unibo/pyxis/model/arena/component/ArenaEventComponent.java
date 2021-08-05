package it.unibo.pyxis.model.arena.component;

import it.unibo.pyxis.model.arena.Arena;
import it.unibo.pyxis.ecs.component.event.AbstractEventComponent;
import it.unibo.pyxis.model.element.powerup.Powerup;
import it.unibo.pyxis.model.element.powerup.PowerupImpl;
import it.unibo.pyxis.model.element.powerup.PowerupType;
import it.unibo.pyxis.model.event.notify.BrickDestructionEvent;
import it.unibo.pyxis.model.event.notify.PowerupActivationEvent;
import it.unibo.pyxis.model.util.Coord;
import org.greenrobot.eventbus.Subscribe;

import java.util.Random;

public final class ArenaEventComponent extends AbstractEventComponent<Arena> {

    private static final double POWERUP_SPAWN_PROBABILITY = 10.0 / 10;
    private final Random randomNumberGenerator;

    public ArenaEventComponent(final Arena entity) {
        super(entity);
        this.randomNumberGenerator = new Random();
    }

    /**
     * Returns a pseudorandom {@link Integer} value between 0 (inclusive) and the specified value (exclusive).
     * @return
     *          the pseudorandom {@link Integer} value between 0 (inclusive) and the specified value (exclusive)
     *          from the {@link Random} rng sequence.
     */
    private Integer rangeNextInt(final int upperBound) {
        return randomNumberGenerator.nextInt(upperBound);
    }

    /**
     * Determine if a {@link Powerup} should be created.
     * @return
     *          True if the {@link Powerup} can be created false otherwise.
     */
    private boolean calculateSpawnPowerup() {
        final int multiplier = 100;
        return rangeNextInt(multiplier) <= Math.floor(multiplier * POWERUP_SPAWN_PROBABILITY);
    }

    /**
     * Spawn a new {@link Powerup} in a specified position.
     * Add a new instance of {@link Powerup} inside the set of powerups.
     *
     * @param spawnCoord
     *                  The starting position of newly created {@link Powerup}.
     */
    private void spawnPowerup(final Coord spawnCoord) {
        final PowerupType selectedType = PowerupType.values()[rangeNextInt(PowerupType.values().length)];
        final Powerup powerup = new PowerupImpl(PowerupType.ATOMIC_BALL, spawnCoord);
        this.getEntity().addPowerup(powerup);
    }

    /**
     * Handle a {@link BrickDestructionEvent}.
     * @param event
     *              The instance of {@link BrickDestructionEvent}
     */
    @Subscribe
    public void handleBrickDestruction(final BrickDestructionEvent event) {
        this.getEntity().removeBrick(event.getBrickCoord());
        if (this.calculateSpawnPowerup()) {
            this.spawnPowerup(event.getBrickCoord());
        }
    }

    /**
     * Handle a {@link PowerupActivationEvent}.
     * @param event
     *              The instance of {@link PowerupActivationEvent}
     */
    @Subscribe
    public void handlePowerupActivation(final PowerupActivationEvent event) {
        this.getEntity().getPowerupHandler().addPowerup(event.getPowerup().getType().getEffect());
        this.getEntity().removePowerup(event.getPowerup());
    }
}
