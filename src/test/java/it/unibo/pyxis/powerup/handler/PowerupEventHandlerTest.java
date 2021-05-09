package it.unibo.pyxis.powerup.handler;

import it.unibo.pyxis.arena.Arena;
import it.unibo.pyxis.arena.ArenaImpl;
import it.unibo.pyxis.event.EventHandlerImpl;
import it.unibo.pyxis.event.notify.PowerupActivationEvent;
import it.unibo.pyxis.powerup.effect.PowerupEffect;
import it.unibo.pyxis.powerup.effect.PowerupEffectType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerupEventHandlerTest {

    // The arena where these powerups will apply
    private final Arena arena = new ArenaImpl();
    // The entity to test
    private PowerupHandler powerupHandler;

    // Type of effects (initialized on @BeforeAll)
    private PowerupEffect effect1;
    private PowerupEffect effect2;

    // Used for testing the effects of the powerups
    private int counter = 0;

    @BeforeEach
    public void setup() {
        this.effect1 = new PowerupEffect() {
            @Override
            public void applyEffect(Arena arena) {
                inc();
            }

            @Override
            public void removeEffect(Arena arena) {
                dec();
            }

            @Override
            public int getApplyTime() {
                return 2;
            }

            @Override
            public PowerupEffectType getType() {
                return PowerupEffectType.PAD_POWERUP;
            }
        };

        this.effect2 = new PowerupEffect() {
            @Override
            public void applyEffect(Arena arena) {
                inc();
                inc();
            }

            @Override
            public void removeEffect(Arena arena) {
                dec();
                dec();
            }

            @Override
            public int getApplyTime() {
                return 4;
            }

            @Override
            public PowerupEffectType getType() {
                return PowerupEffectType.BALL_POWERUP;
            }
        };
    }

    @Test
    public void testPowerupActivation() throws InterruptedException {
        this.powerupHandler = new PowerupHandlerImpl( (t,m) -> System.out.println(t), this.arena);
        final PowerupActivationEvent event = () -> this.effect1;
        EventHandlerImpl.getEventHandler().sendEvent(event);
        Thread.sleep(1000);
        assertEquals(1, this.counter);
        Thread.sleep(1500);
        assertEquals(0, this.counter);
    }

    @Test
    public void testMultiplePowerupActivation() throws InterruptedException {
        this.powerupHandler = new PowerupHandlerImpl( (t,m) -> System.out.println(t), this.arena);
        final PowerupActivationEvent event = () -> this.effect1;
        EventHandlerImpl.getEventHandler().sendEvent(event);
        EventHandlerImpl.getEventHandler().sendEvent(event);
        Thread.sleep(1000);
        assertEquals(2, this.counter);
        Thread.sleep(2000);
        assertEquals(0, this.counter);
    }

    /**
     * Note: Update this method when ball will be ready
     */
    @Test
    public void testCantExecuteMultipleBallPowerup() throws InterruptedException {
        this.powerupHandler = new PowerupHandlerImpl(
                (t,m) -> {
                    if (t == PowerupEffectType.BALL_POWERUP) {
                        m.values().stream().forEach(Thread::interrupt);
                    }
                },
                this.arena
        );

        final PowerupActivationEvent event = () -> this.effect2;
        EventHandlerImpl.getEventHandler().sendEvent(event);
        Thread.sleep(500);
        assertEquals(2, this.counter);
        EventHandlerImpl.getEventHandler().sendEvent(event);
        Thread.sleep(500);
        assertEquals(2, this.counter);
    }

    private synchronized void inc() {
        this.counter++;
    }
    private synchronized void dec() {
        this.counter--;
    }
}