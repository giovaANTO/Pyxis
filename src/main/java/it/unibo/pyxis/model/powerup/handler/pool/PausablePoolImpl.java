package it.unibo.pyxis.model.powerup.handler.pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A pausable {@link java.util.concurrent.ExecutorService} based on a ThreadPoolExecutor.
 * @see <a href="shorturl.at/opDNS">JavaDoc 11 ThreadPoolExecutor</a>
 */
public class PausablePoolImpl extends ThreadPoolExecutor implements PausablePool {
    private final ReentrantLock lock;
    private final Condition waitCond;

    private boolean isPaused = false;

    public PausablePoolImpl(final int corePoolSize, final int maximumPoolSize, final long keepAliveTime,
                            final TimeUnit unit, final BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        this.lock = new ReentrantLock();
        this.waitCond = lock.newCondition();
    }

    @Override
    protected void beforeExecute(final Thread t, final Runnable r) {
        super.beforeExecute(t, r);
        lock.lock();
        try {
            while (this.isPaused) {
                waitCond.await();
            }
        } catch (InterruptedException ie) {
            t.interrupt();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void pause() {
        lock.lock();
        try {
            this.isPaused = true;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void resume() {
        lock.lock();
        try {
            this.isPaused = false;
            waitCond.signalAll();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public ReentrantLock getLock() {
        return this.lock;
    }

    @Override
    public Condition getCondition() {
        return this.waitCond;
    }

    @Override
    public boolean isPaused() {
        return this.isPaused;
    }
}
