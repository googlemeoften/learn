package cn.edu.learn.interview.thread.communication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @USER:hey
 * @Date:2016/3/25
 */
public class Print2 {

    private ReentrantLock lock = new ReentrantLock();
    private Condition isMain = lock.newCondition();
    private volatile boolean flag = true;

    /**
     * 主线程打印
     */
    public void mainPrint() {
        lock.lock();
        try {
            while (!flag)
                try {
                    isMain.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            for (int i = 1; i <= 10; i++) {
                System.out.println("mian thread print " + i);
            }

            flag = false;
            isMain.signal();
        } finally {
            lock.unlock();
        }


    }

    /**
     * 子线程打印
     */
    public void subPrint() {
        lock.lock();
        try {
            while (flag)
                try {
                    isMain.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            for (int i = 1; i <= 5; i++) {
                System.out.println("sub thread print " + i);
            }
            flag = true;
            isMain.signal();
        } finally {
            lock.unlock();
        }
    }
}


