package it.unibo.pyxis.level;

import it.unibo.pyxis.arena.Arena;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LevelTest {

    public static int DEFAULT_STARTING_LIFE = 3;
    public static int SCORE_INCREMENT = 100;

    private Level level;
    private Arena arena;

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
        assertEquals(0, this.level.getScore());
        this.level.increaseScore(SCORE_INCREMENT);
        assertEquals(SCORE_INCREMENT, this.level.getScore());
        this.level.increaseScore(SCORE_INCREMENT);
        assertEquals(2 * SCORE_INCREMENT, this.level.getScore());
    }

    @Test
    void getArena() {
        assertEquals(this.arena, this.level.getArena());
    }
}