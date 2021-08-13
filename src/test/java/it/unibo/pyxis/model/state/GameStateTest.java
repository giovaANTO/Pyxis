package it.unibo.pyxis.model.state;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.nimbus.State;

import static org.junit.jupiter.api.Assertions.*;

class GameStateTest {

    private GameState testGameState;

    @BeforeEach
    public void init() {
        this.testGameState = new GameStateImpl();
    }

    @Test
    public void testCurrentLevel() {
        assertEquals(1, this.testGameState.getCurrentLevel().getLevelNumber());
        this.testGameState.switchLevel();
        assertEquals(2, this.testGameState.getCurrentLevel().getLevelNumber());
    }

    @Test
    public void testStateSwitch() {
        assertEquals(StateEnum.WAITING_FOR_NEW_GAME, this.testGameState.getState());
        this.testGameState.setState(StateEnum.WAITING_FOR_STARTING_COMMAND);
        assertEquals(StateEnum.WAITING_FOR_STARTING_COMMAND, this.testGameState.getState());
    }

    @Test
    public void testReset() {
        this.testGameState.setState(StateEnum.WAITING_FOR_STARTING_COMMAND);
        assertEquals(StateEnum.WAITING_FOR_STARTING_COMMAND, this.testGameState.getState());
        this.testGameState.reset();
        assertEquals(StateEnum.WAITING_FOR_NEW_GAME, this.testGameState.getState());

    }



}