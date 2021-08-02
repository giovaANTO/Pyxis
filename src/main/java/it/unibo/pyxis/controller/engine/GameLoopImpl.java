package it.unibo.pyxis.controller.engine;

import it.unibo.pyxis.controller.command.Command;
import it.unibo.pyxis.controller.linker.Linker;
import it.unibo.pyxis.model.level.Level;
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
        this.commandQueue = new ArrayBlockingQueue<Command<Level>>(COMMAND_QUEUE_DIMENSION);
    }

    @Override
    public void run() {
        long lastTime = System.currentTimeMillis();
        while (this.linker.getGameState().getState() != StateEnum.STOP) {
            long current = System.currentTimeMillis();
            int elapsed = (int) (current - lastTime);
            if (this.conditionProcessInput()) {
                this.processInput();
            }
            if (this.conditionProcessUpdate()) {
                this.linker.getGameState().update(elapsed);
            }
            if (this.conditionProcessRender()) {
                Platform.runLater(this.linker::render);
            }
            this.waitForNextFrame(current);
            lastTime = current;
        }
    }

    private boolean conditionProcessInput() {
        return this.linker.getGameState().getState() == StateEnum.RUN
                || this.linker.getGameState().getState()
                    == StateEnum.WAITING_FOR_STARTING_COMMAND;
    }

    private boolean conditionProcessUpdate() {
        return this.linker.getGameState().getState() == StateEnum.RUN;
    }

    private boolean conditionProcessRender() {
        return this.linker.getGameState().getState() == StateEnum.RUN
                || this.linker.getGameState().getState()
                    == StateEnum.WAITING_FOR_STARTING_COMMAND;
    }

    private void waitForNextFrame(final long current) {
        long dt = System.currentTimeMillis() - current;
        if (dt < PERIOD) {
            try {
                Thread.sleep(PERIOD - dt);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public void render() {
        Platform.runLater(this.linker::render);
    }

    @Override
    public void update(final double elapsed) {
        this.linker.getGameState().update(elapsed);
    }

    @Override
    public void processInput() {
        if (!this.commandQueue.isEmpty()) {
            final Command<Level> nextCommand = this.commandQueue.poll();
            nextCommand.execute(this.linker.getGameState().getCurrentLevel());
        }
    }

    @Override
    public void addCommand(final Command<Level> command) {
        this.commandQueue.add(command);
    }
}
