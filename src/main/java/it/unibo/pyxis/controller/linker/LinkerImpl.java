package it.unibo.pyxis.controller.linker;

import it.unibo.pyxis.controller.command.Command;
import it.unibo.pyxis.controller.engine.GameLoop;
import it.unibo.pyxis.controller.engine.GameLoopImpl;
import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.model.level.status.LevelStatus;
import it.unibo.pyxis.model.state.GameState;
import it.unibo.pyxis.model.state.GameStateImpl;
import it.unibo.pyxis.model.state.StateEnum;
import it.unibo.pyxis.view.scene.SceneHandler;
import it.unibo.pyxis.view.scene.SceneType;
import it.unibo.pyxis.view.RenderableView;

public class LinkerImpl implements Linker {

    private GameState gameState;
    private SceneHandler sceneHandler;
    private GameLoop gameLoop;
    private int maximumLevelReached;

    public LinkerImpl() {
        this.createGameState();
        this.createGameLoop();
        this.maximumLevelReached = 1;
    }

    /**
     * Establishes if a command can be handled.
     *
     * @return True if the {@link GameState}'s {@link StateEnum} is RUN
     *         or WAITING_FOR_STARTING_COMMAND.
     *         False otherwise.
     */
    private boolean conditionInsertCommand() {
        boolean isRunning = this.getGameState().getState() == StateEnum.RUN;
        boolean isWaitingForStartingCommand = this.getGameState().getState()
                == StateEnum.WAITING_FOR_STARTING_COMMAND;
        return isRunning || isWaitingForStartingCommand;
    }

    /**
     * Creates and start a new {@link GameLoop} instance.
     */
    private void createGameLoop() {
        this.gameLoop = new GameLoopImpl(this);
        this.gameLoop.start();
    }

    /**
     * Creates a new {@link GameState} instance.
     */
    private void createGameState() {
        this.gameState = new GameStateImpl();
    }

    /**
     * Switches the actual {@link SceneType} to the input {@link SceneType}.
     *
     * @param inputSceneType The {@link SceneType} to load.
     */
    private void switchScene(final SceneType inputSceneType) {
        this.sceneHandler.switchScene(inputSceneType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void endLevel() {
        if (this.gameState.getState() != StateEnum.PAUSE) {
            this.gameState.setState(StateEnum.PAUSE);
        }
        this.gameState.updateTotalScore();
        this.switchScene(SceneType.END_LEVEL_SCENE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final GameState getGameState() {
        return this.gameState;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final int getMaximumLevelReached() {
        return this.maximumLevelReached;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void insertCommand(final Command<GameState> command) {
        if (this.conditionInsertCommand()) {
            command.execute(this.gameState);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insertGameCommand(final Command<Level> command) {
        this.gameLoop.addCommand(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void menu() {
        this.switchScene(SceneType.MENU_SCENE);
        if (this.gameState.getState() == StateEnum.PAUSE) {
            int actualLevelReached = this.gameState.getCurrentLevel().getLevelNumber();
            boolean levelCompleted = this.gameState.getCurrentLevel().getLevelStatus()
                    == LevelStatus.SUCCESSFULLY_COMPLETED;
            boolean isLastLevel = actualLevelReached == getGameState().
                    getLevelIterator().size();
            if (!isLastLevel && levelCompleted) {
                actualLevelReached++;
            }
            this.maximumLevelReached = Math.max(this.maximumLevelReached,
                    actualLevelReached);
            this.gameState.reset();
            this.gameState.setState(StateEnum.WAITING_FOR_NEW_GAME);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void pause() {
        if (this.gameState.getState() != StateEnum.PAUSE) {
            this.gameState.setState(StateEnum.PAUSE);
            this.gameState.getCurrentLevel().getArena().getPowerupHandler().pause();
        }
        this.switchScene(SceneType.PAUSE_SCENE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void quit() {
        System.exit(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void render() {
        if (this.sceneHandler.getCurrentController().getView() instanceof RenderableView) {
            ((RenderableView) this.sceneHandler.getCurrentController().getView()).render();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void resume() {
        this.switchScene(SceneType.GAME_SCENE);
        this.gameState.setState(StateEnum.WAITING_FOR_STARTING_COMMAND);
        this.gameState.getCurrentLevel().getArena().getPowerupHandler().resume();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void run() {
        this.switchScene(SceneType.GAME_SCENE);
        this.render();
        this.gameState.setState(StateEnum.WAITING_FOR_STARTING_COMMAND);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void selectLevel() {
        this.switchScene(SceneType.SELECT_LEVEL_SCENE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void setSceneHandler(final SceneHandler inputSceneHandler) {
        this.sceneHandler = inputSceneHandler;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void settings() {
        this.switchScene(SceneType.SETTINGS_SCENE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void switchLevel() {
        this.gameState.switchLevel();
        this.run();
    }
}
