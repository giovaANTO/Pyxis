package it.unibo.pyxis.powerup.handler;

import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import it.unibo.pyxis.arena.Arena;
import it.unibo.pyxis.event.EventHandler;
import it.unibo.pyxis.event.notify.PowerupActivationEvent;
import it.unibo.pyxis.powerup.effect.PowerupEffect;
import it.unibo.pyxis.powerup.effect.PowerupEffectType;
import it.unibo.pyxis.powerup.handler.pool.PausablePoolImpl;
import it.unibo.pyxis.powerup.handler.pool.PowerupPool;
import com.google.common.eventbus.Subscribe;


public final class PowerupHandlerImpl implements PowerupHandler {

    private static final int MIN_POOL_SIZE = 6;
    private static final int MAX_POOL_SIZE = 9;
    private static final int KEEP_ALIVE_TIMEOUT = 10;

    private final InternalExecutor executor;
    private final PowerupHandlerPolicy insertionPolicy;
    private final Arena arena;

    public PowerupHandlerImpl(final PowerupHandlerPolicy policy, final Arena inputArena) {
        EventHandler.getEventHandler().register(this);
        this.executor = new InternalExecutor(MIN_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIMEOUT, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        this.insertionPolicy = policy;
        this.arena = inputArena;
    }

    @Override
    @Subscribe
    public void handlePowerupActivationEvent(final PowerupActivationEvent event) {
        final PowerupEffect effect = event.getPowerupEffect();
        this.insertionPolicy.execute(effect.getType(), this.executor.getTypeMap(effect.getType()));
        this.executor.submit(effect);
    }

    @Override
    public void pause() {
        this.executor.pause();
    }

    @Override
    public void resume() {
        this.executor.resume();
    }

    @Override
    public boolean isPaused() {
        return this.executor.isPaused();
    }

    @Override
    public void stop() {
        this.executor.stop();
    }

    @Override
    public void shutdown() {
        this.executor.shutdown();
    }

    /**
     * Return the arena where this handler is currently attached.
     * @return
     *              The instance of {@link Arena}
     */
    private Arena getArena() {
        return this.arena;
    }

    private class InternalExecutor extends PausablePoolImpl implements PowerupPool {

        private final ConcurrentMap<PowerupEffectType, ConcurrentMap<Long, Thread>> threadMap;

        InternalExecutor(final int corePoolSize, final int maximumPoolSize, final long keepAliveTime,
                         final TimeUnit unit, final BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
            this.threadMap = new ConcurrentHashMap<>();
            this.threadMap.put(PowerupEffectType.PAD_POWERUP, new ConcurrentHashMap<>());
            this.threadMap.put(PowerupEffectType.BALL_POWERUP, new ConcurrentHashMap<>());
        }

        @Override
        public Future<?> submit(final PowerupEffect effect) {
            return this.submit(this.buildRunnable(effect));
        }

        @Override
        public Map<Long, Thread> getTypeMap(final PowerupEffectType type) {
            return this.threadMap.get(type);
        }

        @Override
        public void stop() {
            this.threadMap.values().stream().flatMap(m -> m.values().stream()).forEach(Thread::interrupt);
        }

        /**
         * This method is used for building a new runnable used for creating a powerup thread.
         * The newly created {@link Runnable} will implement the logics for applying and remove a {@link PowerupEffect},
         * pausing the thread and safely handling any interruptions.
         * @param effect
         *                  The effect to apply
         * @return
         *                  A new {@link Runnable} to pass to the pool
         */
        private Runnable buildRunnable(final PowerupEffect effect) {
            return new Runnable() {
                @Override
                public void run() {
                    final ReentrantLock lock = InternalExecutor.this.getLock();
                    final Condition cond = InternalExecutor.this.getCondition();
                    InternalExecutor.this.trackThread(effect.getType(), Thread.currentThread().getId(),
                            Thread.currentThread());
                    try {
                        effect.applyEffect(PowerupHandlerImpl.this.getArena());
                        for (int i = 0; i < effect.getApplyTime(); i++) {
                            lock.lock();
                            while (PowerupHandlerImpl.this.isPaused()) {
                                cond.await();
                            }
                            lock.unlock();
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        effect.removeEffect(PowerupHandlerImpl.this.getArena());
                        InternalExecutor.this.untrackThread(effect.getType(), Thread.currentThread().getId());
                    }
                }
            };
        }

        /**
         * Start tracking a new powerup thread adding a new record
         * in the internal thread map.
         * @param type
         *              The {@link PowerupEffectType} of the powerup.
         * @param tid
         *              The thread identifier of the {@link Thread} instance.
         * @param thread
         *              The instance of the {@link Thread}.
         */
        private void trackThread(final PowerupEffectType type, final long tid, final Thread thread) {
            this.threadMap.get(type).put(tid, thread);
        }

        /**
         * Stop tracking a powerup thread.
         *
         * @param type
         *              The {@link PowerupEffectType} of the powerup that should be removed.
         * @param tid
         *              the thread identifier of the {@link Thread} instance.
         */
        private void untrackThread(final PowerupEffectType type, final long tid) {
            this.threadMap.get(type).remove(tid);
        }
    }
}
