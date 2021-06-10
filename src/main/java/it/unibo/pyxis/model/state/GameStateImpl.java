package it.unibo.pyxis.model.state;

import it.unibo.pyxis.model.event.notify.LevelStoppedEvent;
import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.model.level.iterator.LevelIterator;

public final class GameStateImpl implements GameState {

    private final LevelIterator iterator;
    private Level currentLevel;
    private int score;
    private State gameState;

    public GameStateImpl() {
        this.iterator = new LevelIterator();
        this.currentLevel = this.iterator.next();
        this.score = 0;
        this.gameState = State.RUN;
    }

    @Override
    public Level getCurrentLevel() {
        return this.currentLevel;
    }

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public State getGameState() {
        return this.gameState;
    }

    @Override
    public void setState(final State state) {
        this.gameState = state;
    }

    @Override
    public void update(final int delta) {
        this.getCurrentLevel().update(delta);
    }

    @Override
    public void handleLevelStoppedEvent(final LevelStoppedEvent event) {
        this.setState(State.PAUSE);
        this.score += event.getLevelScore();
        if (this.iterator.hasNext()) {
            this.currentLevel = this.iterator.next();
            this.setState(State.RUN);
        } else {
            this.setState(State.STOP);
        }
    }
}
