package cn.edu.learn.interview.thread.aqs;


import cn.edu.learn.interview.thread.pool.ExecutorService;

import java.util.concurrent.CountDownLatch;

/**
 * @description: CountDownLatch使用案例
 * @author: hey
 * @date 2016/3/28
 * @version: 1.0
 */
public class CountDownLatchDemo2 {
    private ExecutorService service = new ExecutorService(10);

    private CountDownLatch order = new CountDownLatch(1);
    private CountDownLatch answer = new CountDownLatch(10);

    public void run() throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程" + Thread.currentThread().getName() + "准备接受命令");
                    try {
                        order.await();
                        Thread.sleep((long) (Math.random() * 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread().getName() + "处理结束");
                    answer.countDown();
                }
            };
            service.execute(runnable);
        }

        Thread.sleep(2000);
        System.out.println("线程" + Thread.currentThread().getName() + "即将发布命令");
        order.countDown();
        System.out.println("线程" + Thread.currentThread().getName() + "已发送命令，正在等待结果");

        answer.await();
        System.out.println("线程" + Thread.currentThread().getName() + "已收到所有响应结果");
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchDemo2 demo = new CountDownLatchDemo2();
        demo.run();
    }
}

