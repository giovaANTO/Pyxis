package it.unibo.pyxis.controller.state;

import it.unibo.pyxis.model.level.Level;

public final class GameStateImpl implements GameState {

    private Level currentLevel;
    private int score;
    private State gameState;

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
}
