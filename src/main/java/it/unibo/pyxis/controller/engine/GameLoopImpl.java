package it.unibo.pyxis.controller.engine;

import it.unibo.pyxis.controller.command.Command;
import it.unibo.pyxis.controller.linker.Linker;
import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.model.level.status.LevelStatus;
import it.unibo.pyxis.model.state.StateEnum;
import javafx.application.Platform;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public final class GameLoopImpl extends Thread implements GameLoop {

    private static final int COMMAND_QUEUE_DIMENSION = 100;
    private static final int PERIOD = 20;
    private final Linker linker;
    private final BlockingQueue<Command<Level>> commandQueue;

    public GameLoopImpl(final Linker linker) {
        this.linker = linker;
        this.commandQueue = new ArrayBlockingQueue<>(COMMAND_QUEUE_DIMENSION);
    }
    /**
     * Apply a sleep on the current thread based on the time used by the gameloop for
     * complete a cycle.
     *
     * @param current The start time of the cycle
     */
    private void waitForNextFrame(final long current) {
        final long dt = System.currentTimeMillis() - current;
        if (dt < PERIOD) {
            try {
                Thread.sleep(PERIOD - dt);
            } catch (final InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    /**
     * Establishes if the render can be processed.
     *
     * @return True if {@link it.unibo.pyxis.model.state.GameState}'s
     *         {@link StateEnum} is RUN or WAITING_FOR_STARTING_COMMAND.
     *         False otherwise.
     */
    private boolean conditionProcessRender() {
        return this.linker.getGameState().getState() == StateEnum.RUN
                || this.linker.getGameState().getState()
                == StateEnum.WAITING_FOR_STARTING_COMMAND;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void addCommand(final Command<Level> command) {
        if (this.linker.getGameState().getState() == StateEnum.RUN) {
            this.commandQueue.add(command);
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void processInput() {
        if (!this.commandQueue.isEmpty()) {
            final Command<Level> nextCommand = this.commandQueue.poll();
            nextCommand.execute(this.linker.getGameState().getCurrentLevel());
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void render() {
        Platform.runLater(this.linker::render);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        long lastTime = System.currentTimeMillis();
        while (this.linker.getGameState().getState() != StateEnum.STOP) {
            final long current = System.currentTimeMillis();
            final int elapsed = (int) (current - lastTime);
            if (this.linker.getGameState().getState() == StateEnum.RUN) {
                this.processInput();
                this.update(elapsed);
            }
            if (this.conditionProcessRender()) {
                this.render();
            }
            this.waitForNextFrame(current);
            lastTime = current;
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final double elapsed) {
        this.linker.getGameState().update(elapsed);
        if (this.linker.getGameState().getCurrentLevel().getLevelStatus() != LevelStatus.PLAYING) {
            Platform.runLater(this.linker::endLevel);
        }
    }
}
