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
        this.iterator = new LevelIterator();
        this.initialize();
    }

    /**
     * Change the current playing {@link Level}.
     * If no other levels are aviable set the {@link GameState} in a stopped mode.
     */
    private void switchLevel() {
        this.setState(StateEnum.PAUSE);
        this.score += this.currentLevel.getScore();
        this.currentLevel.cleanUp();
        if (this.iterator.hasNext()) {
            this.currentLevel = this.iterator.next();
            this.setState(StateEnum.RUN);
        } else {
            this.setState(StateEnum.STOP);
        }
    }

    /**
     * Initialize the {@link GameState} setting the first {@link Level} to play.
     * The score is also cleared on the call of this procedure.
     */
    private void initialize() {
        this.gameStateEnum = StateEnum.PAUSE;
        this.currentLevel = this.iterator.next();
        this.score = 0;
    }

    @Override
    public void reset() {
        this.getCurrentLevel().cleanUp();
        this.initialize();
    }

    @Override
    public void selectStartingLevel(final int levelNumber) {
        this.iterator = new LevelIterator(levelNumber);
        this.initialize();
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
    public void update(final double delta) {
        this.getCurrentLevel().update(delta);
        final LevelStatus levelStatus = this.currentLevel.getLevelStatus();
        if (levelStatus == LevelStatus.SUCCESSFULLY_COMPLETED) {
           this.switchLevel();
        } else if (levelStatus == LevelStatus.GAME_OVER) {
            this.setState(StateEnum.STOP);
        }
    }
}
