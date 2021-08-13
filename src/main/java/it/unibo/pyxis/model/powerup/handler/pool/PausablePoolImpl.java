package it.unibo.pyxis.model.powerup.handler.pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A pausable {@link java.util.concurrent.ExecutorService} based on a ThreadPoolExecutor.
 */
public class PausablePoolImpl extends ThreadPoolExecutor implements PausablePool {
    private final ReentrantLock lock;
    private final Condition waitCond;

    private boolean isPaused;

    public PausablePoolImpl(final int corePoolSize, final int maximumPoolSize, final long keepAliveTime,
                            final TimeUnit unit, final BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        this.lock = new ReentrantLock();
        this.waitCond = lock.newCondition();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    protected void beforeExecute(final Thread t, final Runnable r) {
        super.beforeExecute(t, r);
        lock.lock();
        try {
            while (this.isPaused) {
                this.waitCond.await();
            }
        } catch (InterruptedException ie) {
            t.interrupt();
        } finally {
            lock.unlock();
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Condition getWaitCondition() {
        return this.waitCond;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public ReentrantLock getLock() {
        return this.lock;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isPaused() {
        return this.isPaused;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void pause() {
        lock.lock();
        try {
            this.isPaused = true;
        } finally {
            lock.unlock();
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void resume() {
        lock.lock();
        try {
            this.isPaused = false;
            this.waitCond.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
