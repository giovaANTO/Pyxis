package it.unibo.pyxis.model.state;

public enum StateEnum {
    /**
     * The game is in the pause status.
     */
    PAUSE,
    /**
     * The game is currently running.
     */
    RUN,
    /**
     * The game is in the stop status.
     */
    STOP,
    /**
     * The game is waiting for a new game.
     */
    WAITING_FOR_NEW_GAME,
    /**
     * The game is currently in a new game, but it's waiting to receive the starting
     * command.
     */
    WAITING_FOR_STARTING_COMMAND;
}
