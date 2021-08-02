package it.unibo.pyxis.controller.linker;

import it.unibo.pyxis.controller.command.Command;
import it.unibo.pyxis.model.state.GameState;
import it.unibo.pyxis.view.scene.SceneType;

public interface Linker {

    void pause();

    void resume();

    void menu();

    void quit();

    void endLevel();

    void run();

    void settings();

    void selectLevel();

    GameState getGameState();

    void render();

    void insertCommand(Command<GameState> levelCommand);
}
