package it.unibo.pyxis.powerup.handler.pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PausablePoolImpl extends ThreadPoolExecutor implements PausablePool {
    private final ReentrantLock lock;
    private final Condition waitCond;

    private boolean paused = false;

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
            while (this.paused) {
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
            this.paused = true;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void resume() {
        lock.lock();
        try {
            this.paused = false;
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
        return this.paused;
    }
}
