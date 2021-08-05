package it.unibo.pyxis.model.level;

import it.unibo.pyxis.model.arena.Arena;
import it.unibo.pyxis.model.event.notify.BrickDestructionEvent;
import it.unibo.pyxis.model.event.notify.DecreaseLifeEvent;
import it.unibo.pyxis.model.level.status.LevelStatus;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public final class LevelImpl implements Level {

    private final int levelNumber;
    private final Arena arena;
    private int lives;
    private int score;
    private LevelStatus levelStatus;

    public LevelImpl(final int inputLives, final Arena inputArena, final int levelNumber) {
        this.levelNumber = levelNumber;
        this.lives = inputLives;
        this.score = 0;
        this.levelStatus = LevelStatus.PLAYING;
        this.arena = inputArena;
        EventBus.getDefault().register(this);
    }

    /**
     * Increase the score of this level.
     *
     * @param score
     *          The score to increase.
     */
    private void increaseScore(final int score) {
        this.score += score;
    }
    @Override
    @Subscribe
    public void handleBrickDestruction(final BrickDestructionEvent event) {
        this.increaseScore(event.getPoints());
    }
    @Override
    @Subscribe
    public void handleDecreaseLife(final DecreaseLifeEvent event) {
        this.decreaseLife();
        if (this.lives <= 0) {
            this.levelStatus = LevelStatus.GAME_OVER;
        }
    }
    @Override
    public void cleanUp() {
        this.getArena().cleanUp();
        EventBus.getDefault().unregister(this);
    }
    @Override
    public void decreaseLife() {
        this.lives--;
    }
    @Override
    public Arena getArena() {
        return this.arena;
    }
    @Override
    public int getLevelNumber() {
        return this.levelNumber;
    }
    @Override
    public LevelStatus getLevelStatus() {
        return this.levelStatus;
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
    public void update(final double delta) {
        this.arena.update(delta);
        if (this.arena.isCleared()) {
            this.levelStatus = LevelStatus.SUCCESSFULLY_COMPLETED;
        }
    }
}
