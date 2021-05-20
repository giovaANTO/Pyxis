package it.unibo.pyxis.level;

import it.unibo.pyxis.arena.Arena;
import it.unibo.pyxis.event.Events;
import it.unibo.pyxis.event.notify.DecreaseLifeEvent;
import org.greenrobot.eventbus.EventBus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LevelTest {

    public static int DEFAULT_STARTING_LIFE = 3;
    public static int SCORE_INCREMENT = 100;

    private Level level;
    private Arena arena;

    @BeforeEach
    public void init() {
        this.level = new LevelImpl(arena);
    }

    @Test
    void decreaseLife() {
        assertEquals(DEFAULT_STARTING_LIFE, this.level.getLives());
        this.level.decreaseLife();
        assertEquals(DEFAULT_STARTING_LIFE - 1, this.level.getLives());
    }

    @Test
    void getLives() {
        assertEquals(DEFAULT_STARTING_LIFE, this.level.getLives());
    }

    @Test
    void getScore() {
        assertEquals(0, this.level.getScore());
    }

    @Test
    void increaseScore() {

        DecreaseLifeEvent lifeEvent = Events.newDecreaseLifeEvent(Optional.of(SCORE_INCREMENT));
        assertEquals(0, this.level.getScore());
        EventBus.getDefault().post(lifeEvent);
        assertEquals(SCORE_INCREMENT, this.level.getScore());
        EventBus.getDefault().post(lifeEvent);
        assertEquals(2 * SCORE_INCREMENT, this.level.getScore());
    }

    @Test
    void getArena() {
        assertEquals(this.arena, this.level.getArena());
    }
}