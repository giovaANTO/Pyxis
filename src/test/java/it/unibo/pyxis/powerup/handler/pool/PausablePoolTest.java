package it.unibo.pyxis.powerup.handler.pool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class PausablePoolTest {

    private final static int MIN_POOL_SIZE = 6;
    private final static int MAX_POOL_SIZE = 9;
    private final static int KEEP_ALIVE_TIMEOUT = 10;

    private final static long AWAIT_TIME = 100;

    private final PausablePool pausablePool = new PausablePoolImpl(MIN_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIMEOUT, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    private int counter = 0;

    @BeforeEach
    public void setup() {
        this.counter = 0;
    }

    @Test
    public void testLaunchRunnableTask() throws InterruptedException {
        this.pausablePool.submit(this::inc);
        // Await 1s
        Thread.sleep(AWAIT_TIME);
        // Check if the thread has applied the effect
        assertEquals(1, this.counter);
    }

    @Test
    public void testLaunchRunnableTaskOnPause() throws InterruptedException {
        this.pausablePool.pause();
        this.pausablePool.submit(this::inc);

        // Thread shouldn't apply any increment
        assertEquals(0,this.counter);
        Thread.sleep(AWAIT_TIME);
        assertEquals(0, this.counter);
        this.pausablePool.resume();
        Thread.sleep(AWAIT_TIME);
        assertEquals(1, this.counter);
    }

    @Test
    public void testLaunchMultipleRunnableTasks() throws InterruptedException {
        this.pausablePool.submit(this::inc);
        this.pausablePool.submit(this::inc);
        Thread.sleep(AWAIT_TIME);
        this.pausablePool.pause();
        this.pausablePool.submit(this::inc);
        this.pausablePool.submit(this::inc);

        assertEquals(2,this.counter);
        this.pausablePool.resume();
        Thread.sleep(AWAIT_TIME);
        assertEquals(4, this.counter);
    }

    private synchronized void inc() {
        this.counter++;
    }
}