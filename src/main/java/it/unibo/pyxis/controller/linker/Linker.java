package it.unibo.pyxis.controller.linker;

import it.unibo.pyxis.controller.command.Command;
import it.unibo.pyxis.model.state.GameState;

public interface Linker {

    void pause();

    void resume();

    void menu();

    void quit();

    void endLevel();

    void run();

    void settings();

    void selectLevel();

    void switchLevel();

    GameState getGameState();

    int getMaximumLevelReached();

    void render();

    void insertCommand(Command<GameState> levelCommand);
}
