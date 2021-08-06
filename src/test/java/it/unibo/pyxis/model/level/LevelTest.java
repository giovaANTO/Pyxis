package it.unibo.pyxis.model.level;

import it.unibo.pyxis.model.arena.Arena;
import it.unibo.pyxis.model.arena.ArenaImpl;
import it.unibo.pyxis.model.event.Events;
import it.unibo.pyxis.model.event.notify.DecreaseLifeEvent;
import it.unibo.pyxis.model.util.DimensionImpl;
import org.greenrobot.eventbus.EventBus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LevelTest {

    public static int DEFAULT_STARTING_LIVES = 3;
    public static int SCORE_INCREMENT = 100;

    private Level level;
    private Arena arena;

    @BeforeEach
    public void init() {
        this.arena = new ArenaImpl(new DimensionImpl(1,1));
        this.level = new LevelImpl(DEFAULT_STARTING_LIVES, arena,1);
    }

    @Test
    void decreaseLife() {
        assertEquals(DEFAULT_STARTING_LIVES, this.level.getLives());
        this.level.decreaseLife();
        assertEquals(DEFAULT_STARTING_LIVES - 1, this.level.getLives());
    }

    @Test
    void getLives() {
        assertEquals(DEFAULT_STARTING_LIVES, this.level.getLives());
    }

    @Test
    void getScore() {
        assertEquals(0, this.level.getScore());
    }

    @Test
    void getArena() {
        assertEquals(this.arena, this.level.getArena());
    }

    @Test
    void getLevelNumber() {
        assertEquals(1, this.level.getLevelNumber());
    }
}