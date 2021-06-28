package it.unibo.pyxis.model.state;

import it.unibo.pyxis.model.event.notify.LevelStoppedEvent;
import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.model.level.iterator.LevelIterator;

public final class GameStateImpl implements GameState {

    private final LevelIterator iterator;
    private Level currentLevel;
    private int score;
    private StateEnum gameStateEnum;

    public GameStateImpl() {
        this.iterator = new LevelIterator();
        this.currentLevel = this.iterator.next();
        this.score = 0;
        this.gameStateEnum = StateEnum.PAUSE;
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
    public void handleLevelStoppedEvent(final LevelStoppedEvent event) {
        this.setState(StateEnum.PAUSE);
        this.score += event.getLevelScore();
        if (this.iterator.hasNext()) {
            this.currentLevel = this.iterator.next();
            this.setState(StateEnum.RUN);
        } else {
            this.setState(StateEnum.STOP);
        }
    }
}
