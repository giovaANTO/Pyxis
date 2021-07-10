package it.unibo.pyxis.view.linker;

import it.unibo.pyxis.controller.controllers.Controller;
import it.unibo.pyxis.controller.engine.GameLoop;
import it.unibo.pyxis.controller.engine.GameLoopImpl;
import it.unibo.pyxis.model.state.GameState;
import it.unibo.pyxis.model.state.GameStateImpl;
import it.unibo.pyxis.model.state.StateEnum;
import it.unibo.pyxis.view.scene.LoaderManager;
import it.unibo.pyxis.view.scene.LoaderManagerImpl;
import it.unibo.pyxis.view.scene.SceneLoader;
import it.unibo.pyxis.view.scene.SceneType;
import javafx.stage.Stage;

public class LinkerImpl implements Linker {

    private GameState gameState;
    private GameLoop gameLoop;
    private SceneLoader sceneLoader;
    private final LoaderManager loaderManager;
    private Controller currentController;
    private final Stage stage;

    public LinkerImpl(final Stage inputStage) {
        this.loaderManager = new LoaderManagerImpl();
        this.stage = inputStage;
    }

    @Override
    public final void start() {
        this.createGameState();
        this.createGameLoop();
        this.loaderManager.setInstance(this.stage, this.gameState.getCurrentLevel());
        this.createSceneLoader();
        this.switchScene(SceneType.MENU_SCENE);
    }

    @Override
    public final void stop() {
        this.gameState.setState(StateEnum.PAUSE);
        this.switchScene(SceneType.PAUSE_SCENE);
    }

    @Override
    public final void quit() {
        this.gameState.setState(StateEnum.STOP);
    }

    @Override
    public final void endGame() {
        this.gameState.setState(StateEnum.PAUSE);
        this.switchScene(SceneType.PAUSE_SCENE);
    }

    @Override
    public final void run() {
        this.switchScene(SceneType.GAME_SCENE);
        this.render();
        this.gameState.setState(StateEnum.RUN);
    }

    public final void switchScene(final SceneType inputSceneType) {
        this.sceneLoader.switchScene(inputSceneType);
        this.setCurrentController();
    }

    @Override
    public final void createGameState() {
        this.gameState = new GameStateImpl();
    }

    @Override
    public final GameState getGameState() {
        return this.gameState;
    }

    @Override
    public final void createGameLoop() {
        this.gameLoop = new GameLoopImpl();
        this.gameLoop.start();
    }

    @Override
    public final void createSceneLoader() {
        this.sceneLoader = this.loaderManager.getInstance();
    }

    @Override
    public final SceneLoader getSceneLoader() {
        return this.sceneLoader;
    }

    @Override
    public final void setCurrentController() {
        this.currentController = this.sceneLoader.getCurrentController();
        this.currentController.setLinker(this);
    }

    @Override
    public final Controller getCurrentController() {
        return this.currentController;
    }

    @Override
    public final void render() {
        this.currentController.getView().render();
    }

    @Override
    public void handleCommandControl() {

    }

    @Override
    public void handleFastCommand() {

    }
}
