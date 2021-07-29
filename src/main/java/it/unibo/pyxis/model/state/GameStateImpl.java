package it.unibo.pyxis.model.state;

import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.model.level.iterator.LevelIterator;
import it.unibo.pyxis.model.level.status.LevelStatus;

public final class GameStateImpl implements GameState {

    private LevelIterator iterator;
    private Level currentLevel;
    private int score;
    private StateEnum gameStateEnum;

    public GameStateImpl() {
        this.reset();
    }

    @Override
    public void reset() {
        this.gameStateEnum = StateEnum.PAUSE;
        this.iterator = new LevelIterator();
        this.currentLevel = this.iterator.next();
        this.score = 0;
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
    public StateEnum getGameState() {
        return this.gameStateEnum;
    }

    @Override
    public void setState(final StateEnum stateEnum) {
        this.gameStateEnum = stateEnum;
    }

    @Override
    public void update(final int delta) {
        this.getCurrentLevel().update(delta);
        final LevelStatus levelStatus = this.currentLevel.getLevelStatus();
        if (levelStatus == LevelStatus.SUCCESSFULLY_COMPLETED) {
           this.switchLevel();
        } else if (levelStatus == LevelStatus.GAME_OVER) {
            this.setState(StateEnum.STOP);
        }
    }

    /**
     * Change the current playing {@link Level}.
     * If no other levels are aviable set the {@link GameState} in a stopped mode.
     */
    private void switchLevel() {
        this.setState(StateEnum.PAUSE);
        this.score += this.currentLevel.getScore();
        if (this.iterator.hasNext()) {
            this.currentLevel = this.iterator.next();
            this.setState(StateEnum.RUN);
        } else {
            this.setState(StateEnum.STOP);
        }
    }
}
