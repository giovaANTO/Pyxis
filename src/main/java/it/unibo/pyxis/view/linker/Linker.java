package it.unibo.pyxis.view.linker;

import it.unibo.pyxis.controller.controllers.Controller;
import it.unibo.pyxis.model.state.GameState;
import it.unibo.pyxis.view.scene.SceneLoader;

public interface Linker {

    void start();

    void stop();

    void quit();

    void endGame();

    void run();

    void createGameState();

    GameState getGameState();

    void createGameLoop();

    void createSceneLoader();

    SceneLoader getSceneLoader();

    void setCurrentController();

    Controller getCurrentController();

    void render();

    void handleCommandControl();

    void handleFastCommand();
}
