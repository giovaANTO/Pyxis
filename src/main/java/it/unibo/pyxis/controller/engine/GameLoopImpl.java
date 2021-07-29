package it.unibo.pyxis.controller.engine;

import it.unibo.pyxis.controller.command.Command;
import it.unibo.pyxis.controller.linker.Linker;
import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.model.state.StateEnum;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public final class GameLoopImpl extends Thread implements GameLoop {

    private static final int COMMAND_QUEUE_DIMENSION = 100;
    private final long period = 1000;
    private final Linker linker;
    private final BlockingQueue<Command<Level>> commandQueue;


    public GameLoopImpl(final Linker linker) {
        this.linker = linker;
        this.commandQueue = new ArrayBlockingQueue<Command<Level>>(COMMAND_QUEUE_DIMENSION);
    }

    @Override
    public void run() {
        long lastTime = System.currentTimeMillis();
        while (this.linker.getGameState().getGameState() != StateEnum.STOP) {
            long current = System.currentTimeMillis();
            int elapsed = (int) (current - lastTime);
            this.processInput();
            this.update(elapsed);
            render();
            this.waitForNextFrame(current);
            lastTime = current;
        }
    }

    private void waitForNextFrame(final long current) {
        long dt = System.currentTimeMillis() - current;
        if (dt < period) {
            try {
                Thread.sleep(period - dt);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public void render() {
        System.out.println("Render");
    }

    @Override
    public void update(final double elapsed) {
        System.out.println("Update");
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
