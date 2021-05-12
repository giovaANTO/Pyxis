package it.unibo.pyxis.powerup.handler;

import it.unibo.pyxis.arena.Arena;
import it.unibo.pyxis.arena.ArenaImpl;
import it.unibo.pyxis.powerup.effect.PowerupEffect;
import it.unibo.pyxis.powerup.effect.PowerupEffectType;
import it.unibo.pyxis.powerup.handler.effects.GenericBallEffect;
import it.unibo.pyxis.powerup.handler.effects.GenericPadEffect;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerupHandlerImplTest {

    final Arena arena = new ArenaImpl();
    final PowerupEffect padEffect = new GenericPadEffect();
    final PowerupEffect ballEffect = new GenericBallEffect();

    PowerupHandler powerupHandler;

    /**
     * Test an handler that always allow any kind of
     * powerup effects.
     * @throws InterruptedException
     *                                Interrupted exception
     */
    @Test
    public void alwaysAllowHandlerTest() throws InterruptedException {
        this.powerupHandler = new PowerupHandlerImpl((type, map) -> System.out.println(type), this.arena);
        this.powerupHandler.addPowerup(this.padEffect);
        this.powerupHandler.addPowerup(this.padEffect);
        this.powerupHandler.addPowerup(this.ballEffect);
        this.powerupHandler.addPowerup(this.ballEffect);
        assertEquals(4, this.powerupHandler.activeCount());
        Thread.sleep(2500);
        assertEquals(0, this.powerupHandler.activeCount());
    }

    /**
     * Test an handler that allow only one ball
     * powerup effect at time.
     *
     * @throws InterruptedException
     *                                 Interrupted exception
     */
    @Test
    public void allowOnlyOneBallPowerupTest() throws InterruptedException {
        this.powerupHandler = new PowerupHandlerImpl(
                (type, map) -> {
                    if(type == PowerupEffectType.BALL_POWERUP && map.size() >= 1) {
                        map.values().forEach(Thread::interrupt);
                    }
                },
                this.arena
        );
        this.powerupHandler.addPowerup(this.ballEffect);
        this.powerupHandler.addPowerup(this.ballEffect);
        this.powerupHandler.addPowerup(this.ballEffect);
        this.powerupHandler.addPowerup(this.ballEffect);
        Thread.sleep(2500);
        assertEquals(1, this.powerupHandler.activeCount());
    }
}