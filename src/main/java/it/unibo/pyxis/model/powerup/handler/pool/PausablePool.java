package it.unibo.pyxis.model.powerup.handler.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public interface PausablePool extends ExecutorService {
    /**
     * Returns the number of active threads that are executing a task running.
     *
     * @return The number of threads.
     */
    int getActiveCount();
    /**
     * Returns the waiting condition of the lock.
     *
     * @return An instance of {@link Condition}.
     */
    Condition getWaitCondition();

    /**
     * Returns a {@link ReentrantLock} of the pause condition flag.
     *
     * @return An instance of {@link ReentrantLock}.
     */
    ReentrantLock getLock();
    /**
     * Returns the paused flag of the thread pool.
     *
     * @return True if the thread pool is paused.
     *         False otherwise.
     */
    boolean isPaused();
    /**
     * Pauses the execution of the thread pool.
     */
    void pause();
    /**
     * Resumes the execution of the threads in the {@link PausablePool}.
     */
    void resume();
}
