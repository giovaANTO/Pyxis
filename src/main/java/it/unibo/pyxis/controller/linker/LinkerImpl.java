package it.unibo.pyxis.controller.linker;

import it.unibo.pyxis.controller.command.Command;
import it.unibo.pyxis.controller.engine.GameLoop;
import it.unibo.pyxis.controller.engine.GameLoopImpl;
import it.unibo.pyxis.controller.input.InputHandler;
import it.unibo.pyxis.controller.input.InputHandlerImpl;
import it.unibo.pyxis.model.state.GameState;
import it.unibo.pyxis.model.state.GameStateImpl;
import it.unibo.pyxis.model.state.StateEnum;
import it.unibo.pyxis.view.scene.SceneHandler;
import it.unibo.pyxis.view.scene.SceneHandlerImpl;
import it.unibo.pyxis.view.scene.SceneType;
import it.unibo.pyxis.view.views.RenderableView;
import javafx.stage.Stage;

public class LinkerImpl implements Linker {

    private GameState gameState;
    private GameLoop gameLoop;
    private SceneHandler sceneHandler;
    private InputHandler inputHandler;

    public LinkerImpl(final Stage inputStage) {
        this.createGameState();
        this.createGameLoop();
        this.createInputHandler(inputStage);
        this.createSceneLoader(inputStage);
        this.switchScene(SceneType.MENU_SCENE);
    }

    @Override
    public final void pause() {
        if (this.gameState.getState() != StateEnum.PAUSE) {
            this.gameState.setState(StateEnum.PAUSE);
            this.gameState.getCurrentLevel().getArena().getPowerupHandler().pause();
        }
        this.switchScene(SceneType.PAUSE_SCENE);
    }

    @Override
    public final void resume() {
        this.switchScene(SceneType.GAME_SCENE);
        this.gameState.setState(StateEnum.RUN);
        this.gameState.getCurrentLevel().getArena().getPowerupHandler().resume();
    }

    @Override
    public final void menu() {
        this.switchScene(SceneType.MENU_SCENE);
        if (this.gameState.getState() == StateEnum.PAUSE) {
            //System.out.println(this.gameState.getCurrentLevel());
            this.gameState.reset();
            this.gameState.setState(StateEnum.WAITING_FOR_NEW_GAME);
        }
    }

    @Override
    public final void run() {
        this.switchScene(SceneType.GAME_SCENE);
        this.render();
        this.gameState.setState(StateEnum.WAITING_FOR_STARTING_COMMAND);
    }

    @Override
    public final void quit() {
        this.gameState.setState(StateEnum.STOP);
        this.gameState.getCurrentLevel().getArena().cleanUp();
        this.sceneHandler.close();
    }

    @Override
    public final void endLevel() {
        this.gameState.setState(StateEnum.PAUSE);
        this.switchScene(SceneType.END_LEVEL_SCENE);
    }

    @Override
    public final void settings() {
        this.switchScene(SceneType.SETTINGS_SCENE);
    }

    @Override
    public final void selectLevel() {
        this.switchScene(SceneType.SELECT_LEVEL_SCENE);
    }

    private void switchScene(final SceneType inputSceneType) {
        this.sceneHandler.switchScene(inputSceneType);
    }

    private void createGameState() {
        this.gameState = new GameStateImpl();
    }

    @Override
    public final GameState getGameState() {
        return this.gameState;
    }

    private void createGameLoop() {
        this.gameLoop = new GameLoopImpl(this);
        this.gameLoop.start();
    }

    private void createInputHandler(final Stage inputStage) {
        this.inputHandler = new InputHandlerImpl();
        this.inputHandler.bindCommands(this, inputStage);
    }

    private void createSceneLoader(final Stage inputStage) {
        this.sceneHandler = new SceneHandlerImpl(inputStage, this);
    }

    @Override
    public final void render() {
        if (this.sceneHandler.getCurrentController().getView() instanceof RenderableView) {
            ((RenderableView) this.sceneHandler.getCurrentController().getView()).render();
        }
    }

    @Override
    public final void insertCommand(final Command<GameState> gameCommand) {
        if (this.conditionInsertCommand()) {
            gameCommand.execute(this.gameState);
        }
    }

    private boolean conditionInsertCommand() {
        return this.getGameState().getState() == StateEnum.RUN
                || this.getGameState().getState() == StateEnum.WAITING_FOR_STARTING_COMMAND;
    }
}
