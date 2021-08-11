package it.unibo.pyxis.controller.linker;

import it.unibo.pyxis.controller.command.Command;
import it.unibo.pyxis.controller.engine.GameLoop;
import it.unibo.pyxis.controller.engine.GameLoopImpl;
import it.unibo.pyxis.controller.input.InputHandler;
import it.unibo.pyxis.controller.input.InputHandlerImpl;
import it.unibo.pyxis.controller.soundplayer.Sound;
import it.unibo.pyxis.controller.soundplayer.SoundPlayer;
import it.unibo.pyxis.model.level.status.LevelStatus;
import it.unibo.pyxis.model.state.GameState;
import it.unibo.pyxis.model.state.GameStateImpl;
import it.unibo.pyxis.model.state.StateEnum;
import it.unibo.pyxis.view.scene.SceneHandler;
import it.unibo.pyxis.view.scene.SceneHandlerImpl;
import it.unibo.pyxis.view.scene.SceneType;
import it.unibo.pyxis.view.RenderableView;
import javafx.stage.Stage;

public class LinkerImpl implements Linker {

    private GameState gameState;
    private GameLoop gameLoop;
    private SceneHandler sceneHandler;
    private InputHandler inputHandler;
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
        return this.getGameState().getState() == StateEnum.RUN
                || this.getGameState().getState()
                == StateEnum.WAITING_FOR_STARTING_COMMAND;
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
     * Creates a new {@link InputHandler} instance and bind it with the
     * current {@link Stage}.
     *
     * @param inputStage The {@link Stage} to bind.
     */
    private void createInputHandler(final Stage inputStage) {
        this.inputHandler = new InputHandlerImpl();
        this.inputHandler.bindCommands(this, inputStage);
    }
    /**
     * Creates a new {@link SceneHandler} instance and bind it with the
     * current {@link Stage}.
     *
     * @param inputStage The {@link Stage} to bind.
     */
    private void createSceneHandler(final Stage inputStage) {
        this.sceneHandler = new SceneHandlerImpl(inputStage, this);
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
    public final void insertCommand(final Command<GameState> gameCommand) {
        if (this.conditionInsertCommand()) {
            gameCommand.execute(this.gameState);
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final void load() {
        this.switchScene(SceneType.MENU_SCENE);
        SoundPlayer.playBackgroundMusic(Sound.MENU_MUSIC);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public final void menu() {
        this.switchScene(SceneType.MENU_SCENE);
        if (this.gameState.getState() == StateEnum.PAUSE) {
            this.maximumLevelReached = Math.max(this.maximumLevelReached,
                    this.gameState.getCurrentLevel().getLevelNumber()
                            + (this.gameState.getCurrentLevel().getLevelStatus()
                            == LevelStatus.SUCCESSFULLY_COMPLETED ? 1 : 0));
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
        this.gameState.setState(StateEnum.STOP);
        this.gameState.getCurrentLevel().getArena().cleanUp();
        SoundPlayer.shutdown();
        this.sceneHandler.close();
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
    public final void setInputHandler(final InputHandler inputInputHandler) {
        this.inputHandler = inputInputHandler;
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
