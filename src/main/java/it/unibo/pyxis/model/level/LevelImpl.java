package it.unibo.pyxis.model.level;

import it.unibo.pyxis.model.arena.Arena;
import it.unibo.pyxis.model.event.notify.DecreaseLifeEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class LevelImpl implements Level {

    private static final int DEFAULT_STARTING_LIVES = 3;

    private int lives;
    private int score;
    private final Arena arena;

    public LevelImpl(final Arena inputArena) {
        this.lives = DEFAULT_STARTING_LIVES;
        this.score = 0;
        this.arena = inputArena;
        EventBus.getDefault().register(this);
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

    /**
     * Increase the score of this level.
     * @param score
     *               The score to increase
     */
    private void increaseScore(final int score) {
        this.score += score;
    }

    @Override
    public Arena getArena() {
        return this.arena;
    }

    @Override
    @Subscribe
    public void handleDecreaseLife(final DecreaseLifeEvent event) {
        event.getScore().ifPresent(this::increaseScore);
    }
}
