package it.unibo.pyxis.model.state;

import it.unibo.pyxis.model.level.Level;

public class GameStateImpl implements GameState {
    
    @Override
    public Level getCurrentLevel() {
        return null;
    }

    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public State getGameStatus() {
        return null;
    }

    @Override
    public void setState(State state) {

    }
}
