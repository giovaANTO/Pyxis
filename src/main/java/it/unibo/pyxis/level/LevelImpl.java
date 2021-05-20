package it.unibo.pyxis.level;

import it.unibo.pyxis.arena.Arena;

public class LevelImpl implements Level {

    private static final int DEFAULT_STARTING_LIVES = 3;

    private int lives;
    private int score;
    private final Arena arena;

    public LevelImpl(final Arena inputArena) {
        this.lives = DEFAULT_STARTING_LIVES;
        this.score = 0;
        this.arena = inputArena;
    }

    @Override
    public void decreaseLife() {
        this.lives--;
    }

    @Override
    public int getLives() {
        return this.lives;
    }

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public void increaseScore(final int score) {
        this.score += score;
    }

    @Override
    public Arena getArena() {
        return this.arena;
    }
}
