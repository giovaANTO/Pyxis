package it.unibo.pyxis.model.powerup.handler.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public interface PausablePool extends ExecutorService {
    /**
     * Pause the execution of the thread pool.
     */
    void pause();

    /**
     * Resume the execution of the thread pool.
     */
    void resume();

    /**
     * Return the paused flag of the thread pool.
     * @return
     *          true if the thread pool is paused.
     */
    boolean isPaused();

    /**
     * Return the number of active threads that are executing a task running.
     * @return
     *          the number of threads
     */
    int getActiveCount();

    /**
     * Return a {@link ReentrantLock} of the pause condition flag.
     * @return
     *          an instance of {@link ReentrantLock}
     */
    ReentrantLock getLock();

    /**
     * Return the waiting condition of the lock.
     * @return
     *          an instance of {@link Condition}
     */
    Condition getCondition();
}
