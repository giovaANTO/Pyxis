package it.unibo.pyxis.model.level;

import it.unibo.pyxis.model.arena.Arena;
import it.unibo.pyxis.ecs.component.event.EventComponent;
import it.unibo.pyxis.ecs.component.physics.UpdateComponent;
import it.unibo.pyxis.ecs.EntityImpl;
import it.unibo.pyxis.model.level.component.LevelEventComponent;
import it.unibo.pyxis.model.level.component.LevelUpdateComponent;
import it.unibo.pyxis.model.level.status.LevelStatus;

public final class LevelImpl extends EntityImpl implements Level {

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
        this.registerComponent(new LevelUpdateComponent(this));
        this.registerComponent(new LevelEventComponent(this));
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void cleanUp() {
        this.getArena().cleanUp();
        this.removeComponent(EventComponent.class);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void decreaseLife() {
        this.lives--;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Arena getArena() {
        return this.arena;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getLevelNumber() {
        return this.levelNumber;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public LevelStatus getLevelStatus() {
        return this.levelStatus;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getLives() {
        return this.lives;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getScore() {
        return this.score;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void increaseScore(final int score) {
        this.score += score;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setLevelStatus(final LevelStatus levelStatus) {
        this.levelStatus = levelStatus;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double delta) {
        this.getComponent(UpdateComponent.class).update(delta);
    }
}
