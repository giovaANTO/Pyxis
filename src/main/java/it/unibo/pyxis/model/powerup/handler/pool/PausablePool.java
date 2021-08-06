package it.unibo.pyxis.model.powerup.handler.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public interface PausablePool extends ExecutorService {
    /**
     * Return the number of active threads that are executing a task running.
     *
     * @return
     *          The number of threads.
     */
    int getActiveCount();

    /**
     * Return the waiting condition of the lock.
     *
     * @return
     *          An instance of {@link Condition}.
     */
    Condition getWaitCondition();

    /**
     * Return a {@link ReentrantLock} of the pause condition flag.
     *
     * @return
     *          An instance of {@link ReentrantLock}.
     */
    ReentrantLock getLock();

    /**
     * Return the paused flag of the thread pool.
     *
     * @return
     *          true if the thread pool is paused.
     */
    boolean isPaused();

    /**
     * Pause the execution of the thread pool.
     */
    void pause();


    /**
     * Resume the execution of the Threads in the {@link PausablePool}.
     */
    void resume();
}
