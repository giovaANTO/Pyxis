package it.unibo.pyxis.model.state;

import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.model.level.iterator.LevelIterator;
import it.unibo.pyxis.model.level.status.LevelStatus;

public final class GameStateImpl implements GameState {

    private final LevelIterator iterator;
    private Level currentLevel;
    private int score;
    private State gameState;

    public GameStateImpl() {
        this.iterator = new LevelIterator();
        this.currentLevel = this.iterator.next();
        this.score = 0;
        this.gameState = State.PAUSE;
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
        final LevelStatus levelStatus = this.currentLevel.getLevelStatus();
        if (levelStatus == LevelStatus.SUCCESSFULLY_COMPLETED) {
           this.switchLevel();
        } else if (levelStatus == LevelStatus.GAME_OVER) {
            this.setState(State.STOP);
        }
    }

    /**
     * Change the current playing {@link Level}.
     * If no other levels are aviable set the {@link GameState} in a stopped mode.
     */
    private void switchLevel() {
        this.setState(State.PAUSE);
        this.score += this.currentLevel.getScore();
        if (this.iterator.hasNext()) {
            this.currentLevel = this.iterator.next();
            this.setState(State.RUN);
        } else {
            this.setState(State.STOP);
        }
    }
}
