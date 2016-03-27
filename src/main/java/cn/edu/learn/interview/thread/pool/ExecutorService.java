package cn.edu.learn.interview.thread.pool;

import java.util.concurrent.*;

/**
 * @description: 模仿线程池
 * @USER:hey
 * @Date:2016/3/25
 */
public class ExecutorService {

    private ArrayBlockingQueue<Runnable> queue;
    private WorkThred[] pool;

    public ExecutorService(int poolSize) {
        queue = new ArrayBlockingQueue<Runnable>();
        pool = new WorkThred[poolSize];
        init();
    }

    private void init() {
        for (int i = 0; i < pool.length; i++) {
            pool[i] = new WorkThred();
            pool[i].start();
        }

    }

    /**
     * 执行任务
     *
     * @param task
     */
    public void execute(Runnable task) {
        queue.insert(task);
    }

    /**
     * 关闭线程池
     */
    public void destory() {
        queue.setShutDown(true);
        while (!queue.isEmpty()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (WorkThred th : pool)
            th.stopWork();
    }

    /**
     * 工作线程
     */
    private class WorkThred extends Thread {
        private boolean isRunning = true;

        @Override
        public void run() {
            while (isRunning) {
                queue.remove().run();
            }
        }

        public void stopWork() {
            isRunning = false;
        }
    }

}

