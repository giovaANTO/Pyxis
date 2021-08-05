package it.unibo.pyxis.model.level;

import it.unibo.pyxis.model.arena.Arena;
import it.unibo.pyxis.ecs.component.event.EventComponent;
import it.unibo.pyxis.ecs.component.physics.PhysicsComponent;
import it.unibo.pyxis.ecs.EntityImpl;
import it.unibo.pyxis.model.level.component.LevelEventComponent;
import it.unibo.pyxis.model.level.component.LevelPhysicsComponent;
import it.unibo.pyxis.model.level.status.LevelStatus;

public final class LevelImpl extends EntityImpl implements Level {

    private final int levelNumber;
    private int lives;
    private int score;
    private LevelStatus levelStatus;
    private final Arena arena;

    public LevelImpl(final int inputLives, final Arena inputArena, final int levelNumber) {
        this.levelNumber = levelNumber;
        this.lives = inputLives;
        this.score = 0;
        this.levelStatus = LevelStatus.PLAYING;
        this.arena = inputArena;
        this.registerComponent(new LevelPhysicsComponent(this));
        this.registerComponent(new LevelEventComponent(this));
    }

    @Override
    public int getLevelNumber() {
        return this.levelNumber;
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
    public Arena getArena() {
        return this.arena;
    }

    @Override
    public void update(final double delta) {
        this.getComponent(PhysicsComponent.class).update(delta);
    }

    @Override
    public void increaseScore(final int score) {
        this.score += score;
    }

    @Override
    public void setLevelStatus(final LevelStatus levelStatus) {
        this.levelStatus = levelStatus;
    }

    @Override
    public LevelStatus getLevelStatus() {
        return this.levelStatus;
    }

    @Override
    public void cleanUp() {
        this.getArena().cleanUp();
        this.removeComponent(EventComponent.class);
    }
}
