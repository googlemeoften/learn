package cn.edu.learn.interview.thread.aqs;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: hey
 * @date 2016/3/28
 * @version: 1.0
 */
public class CountDownLatchDemo {

    private CountDownLatch latch = new CountDownLatch(100);
    private Inc inc = new Inc();

    public void run() {

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    inc.inc();
                    latch.countDown();
                }
            }).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long time = System.currentTimeMillis() - start;

        System.out.println(time);
    }

    public static void main(String[] args) {
        CountDownLatchDemo demo = new CountDownLatchDemo();
        demo.run();
    }
}

class Inc {
    int i = 0;

    public void inc() {
        synchronized (this) {
            i++;
        }
    }

    public int getI() {
        return i;
    }
}
