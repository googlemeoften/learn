package cn.edu.learn.interview.thread.communication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @USER:hey
 * @Date:2016/3/25
 */
public class Print3 {

    private ReentrantLock lock = new ReentrantLock();
    private Condition isMain = lock.newCondition();
    private Condition isSub = lock.newCondition();
    private Condition isSub2 = lock.newCondition();
    private volatile int flag = 0;

    /**
     * 主线程打印
     */
    public void mainPrint() {
        lock.lock();
        try {
            while (flag != 0)
                try {
                    isMain.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            for (int i = 1; i <= 10; i++) {
                System.out.println("mian thread print " + i);
            }

            flag = 1;
            isSub.signal();
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
            while (flag != 1)
                try {
                    isSub.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            for (int i = 1; i <= 5; i++) {
                System.out.println("sub thread print " + i);
            }
            flag = 2;
            isSub2.signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 子线程打印
     */
    public void sub2Print() {
        lock.lock();
        try {
            while (flag != 2)
                try {
                    isSub2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            for (int i = 1; i <= 15; i++) {
                System.out.println("sub2 thread print " + i);
            }
            flag = 0;
            isMain.signal();
        } finally {
            lock.unlock();
        }
    }
}


