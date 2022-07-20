package com.lhd.springboot_blog.utils;





import java.util.concurrent.*;

/**
 * 线程池工具类
 * 
 * @author yinsusha
 *
 */
public class ThreadPoolUtils {
    /**
     * 线程池
     */
    public static ThreadPool instance;

    /**
     * 获取单例的线程池对象
     * 
     * @return ThreadPool
     */
    public static ThreadPool getInstance() {
        if (instance == null) {
            synchronized (ThreadPoolUtils.class) {
                if (instance == null) {
                    instance = new ThreadPool();
                }
            }
        }
        return instance;
    }
    
    public static class ThreadPool {
        /**
         * 线程池执行服务
         */
        private ThreadPoolExecutor threadPoolExecutor;
        /**
         * 保持在池中的线程数
         */
        private int corePoolSize;
        /**
         * 最大线程数
         */
        private int maximumPoolSize;
        /**
         * 闲置线程最大空闲时间
         */
        private long keepAliveTime;
        /**
         * 时间单位默认秒
         */
        private TimeUnit timeUnit = TimeUnit.SECONDS;

        private  int  blockingQueue ;

        private ThreadPool() {

            corePoolSize = 1;
            maximumPoolSize = 8;
            keepAliveTime = 10;
            blockingQueue = 2;
            threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, timeUnit,
                    new ArrayBlockingQueue<>(blockingQueue), Executors.defaultThreadFactory(),
                    new ThreadPoolExecutor.CallerRunsPolicy());
        }

        /**
         * Executes the given task.
         * 
         * @param callable
         *            the task to execute
         * @throws NullPointerException
         *             if {@code callable} is null
         * @return Future<T>
         */
        @SuppressWarnings("unchecked")
        public <T> Future<T> submit(Callable callable) {
            if (callable == null)
                throw new NullPointerException();
            return threadPoolExecutor.submit(callable);
        }

        /**
         * Executes the given task.
         *
         * @param runnable
         *            the task to execute
         * @throws NullPointerException
         *             if {@code runnable} is null
         */
        public void execute(Runnable runnable) {
            if (runnable == null)
                throw new NullPointerException();
            threadPoolExecutor.getActiveCount();

            threadPoolExecutor.execute(runnable);
        }

        /**
         * Returns the current number of threads in the pool.
         *
         * @return the number of threads
         */
        public int getPoolSize() {
            return threadPoolExecutor.getPoolSize();
        }

        /**
         * Returns the approximate total number of tasks that have completed
         * execution.
         *
         * @return the number of tasks
         */
        public long getCompletedTaskCount() {
            return threadPoolExecutor.getCompletedTaskCount();
        }

        /**
         * Returns the maximum allowed number of threads.
         *
         * @return the maximum allowed number of threads
         */
        public int getMaximumPoolSize() {
            return threadPoolExecutor.getMaximumPoolSize();
        }

        /**
         * Returns the approximate number of threads that are actively executing
         * tasks.
         *
         * @return the number of threads
         */
        public int getActiveCount() {
            threadPoolExecutor.getQueue();
            return threadPoolExecutor.getActiveCount();
        }

        /**
         * Returns the task queue used by this executor.
         *
         * @return the task queue
         */
        public BlockingQueue<Runnable> getQueue() {
            return threadPoolExecutor.getQueue();
        }

        /**
         * Returns the core number of threads.
         *
         * @return the core number of threads
         */
        public int getCorePoolSize() {
            return threadPoolExecutor.getCorePoolSize();
        }

        /**
         * Initiates an orderly shutdown in which previously submitted tasks are
         * executed, but no new tasks will be accepted.
         */
        public void shutdown() {
            threadPoolExecutor.shutdown();
        }

        /**
         * Returns the approximate total number of tasks that have ever been
         * scheduled for execution. Because the states of tasks and threads may
         * change dynamically during computation, the returned value is only an
         * approximation.
         *
         * @return the number of tasks
         */
        public long getTaskCount() {
            return threadPoolExecutor.getTaskCount();
        }
        
        /**
         * Returns the thread keep-alive time, which is the amount of time
         * that threads in excess of the core pool size may remain
         * idle before being terminated.
         *
         * @param unit the desired time unit of the result
         * @return the time limit
         */
        public long getKeepAliveTime(TimeUnit unit) {
            return threadPoolExecutor.getKeepAliveTime(unit);
        }
        
        /**
         * Sets the core number of threads.  This overrides any value set
         * in the constructor.  If the new value is smaller than the
         * current value, excess existing threads will be terminated when
         * they next become idle.  If larger, new threads will, if needed,
         * be started to execute any queued tasks.
         *
         * @param corePoolSize the new core size
         * @throws IllegalArgumentException if {@code corePoolSize < 0}
         */
        public void setCorePoolSize(int corePoolSize) {
            threadPoolExecutor.setCorePoolSize(corePoolSize);
        }
        
        /**
         * Sets the maximum allowed number of threads. This overrides any
         * value set in the constructor. If the new value is smaller than
         * the current value, excess existing threads will be
         * terminated when they next become idle.
         *
         * @param maximumPoolSize the new maximum
         * @throws IllegalArgumentException if the new maximum is
         *         less than or equal to zero, or
         *         less than the {@linkplain #getCorePoolSize core pool size}
         */
        public void setMaximumPoolSize(int maximumPoolSize) {
            threadPoolExecutor.setMaximumPoolSize(maximumPoolSize);
        }
        
        /**
         * Sets the time limit for which threads may remain idle before
         * being terminated.  If there are more than the core number of
         * threads currently in the pool, after waiting this amount of
         * time without processing a task, excess threads will be
         * terminated.  This overrides any value set in the constructor.
         *
         * @param time the time to wait.  A time value of zero will cause
         *        excess threads to terminate immediately after executing tasks.
         * @param unit the time unit of the {@code time} argument
         * @throws IllegalArgumentException if {@code time} less than zero or
         *         if {@code time} is zero and {@code allowsCoreThreadTimeOut}
         */
        public void setKeepAliveTime(long time, TimeUnit unit) {
            threadPoolExecutor.setKeepAliveTime(time, timeUnit);
        }
    }
}
