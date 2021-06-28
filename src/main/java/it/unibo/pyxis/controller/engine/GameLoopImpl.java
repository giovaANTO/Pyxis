package it.unibo.pyxis.controller.engine;

import it.unibo.pyxis.model.state.GameState;
import it.unibo.pyxis.model.state.GameStateImpl;
import it.unibo.pyxis.model.state.StateEnum;


public final class GameLoopImpl extends Thread implements GameLoop {

    private static final long UPDATING_FREQUENCY = 4;
    private final GameState gameState;
    private long showStatsTimer;
    private int fps = 0;
    private int ups = 0;

    public GameLoopImpl() {
        this.gameState = new GameStateImpl();
    }

    @Override
    public void run() {
        this.gameState.setState(StateEnum.RUN);
        long lastUpdate = System.currentTimeMillis();
        this.showStatsTimer = System.currentTimeMillis() + 1000;
        while (this.gameState.getGameState() == StateEnum.RUN) {
            long current = System.currentTimeMillis();
            long lastRenderingTime = (current - lastUpdate);
            this.processInput();
            this.update(lastRenderingTime);
            this.render();
            this.showStats();
            this.waitForNextFrame(current);
            lastUpdate = current;
        }
    }

    private void showStats() {
        if (System.currentTimeMillis() >= showStatsTimer) {
            System.out.print("\r FPS: " + this.fps + " UPS: " + this.ups);
            this.fps = 0;
            this.ups = 0;
            this.showStatsTimer = System.currentTimeMillis() + 1000;
        }
    }


    private void waitForNextFrame(final long current) {
        long delta = System.currentTimeMillis() - current;
        if (delta < UPDATING_FREQUENCY) {
            try {
                Thread.sleep(UPDATING_FREQUENCY - delta);
            } catch (Exception ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void render() {
        this.fps++;
    }

    @Override
    public void update(final double elapsed) {
        this.ups++;
    }

    @Override
    public void processInput() {
    }
}
