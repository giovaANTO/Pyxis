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
        this.initialize();
    }

    /**
     * Change the current playing {@link Level}.
     * If no other levels are available set the {@link GameState} in a stopped mode.
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

    /**
     * Initialize the {@link GameState} setting the {@link LevelIterator}
     * and the first {@link Level} to play. The score is also cleared on the
     * call of this procedure.
     */
    private void initialize() {
        this.gameStateEnum = StateEnum.WAITING_FOR_NEW_GAME;
        this.iterator = new LevelIterator();
        this.currentLevel = this.iterator.next();
        this.score = 0;
    }

    @Override
    public void reset() {
        this.getCurrentLevel().cleanUp();
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
    public StateEnum getState() {
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
            System.out.println("You've won the current level.");
           this.switchLevel();
        } else if (levelStatus == LevelStatus.GAME_OVER) {
            System.out.println("You've lost the current level.");
            this.setState(StateEnum.STOP);
        }
    }
}
