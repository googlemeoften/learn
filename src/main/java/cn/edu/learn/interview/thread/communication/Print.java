package cn.edu.learn.interview.thread.communication;

/**
 * @description:
 * @USER:hey
 * @Date:2016/3/25
 */
public class Print {

    private volatile boolean flag = true;

    /**
     * 主线程打印
     */
    public synchronized void mainPrint()  {
        while (!flag)
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        for (int i = 1; i <= 10; i++) {
            System.out.println("mian thread print " + i);
        }

        flag = false;
        notifyAll();
    }

    /**
     * 子线程打印
     */
    public synchronized void subPrint() {
        while (flag)
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        for (int i = 1; i <= 5; i++) {
            System.out.println("sub thread print " + i);
        }
        flag = true;
        notifyAll();
    }
}


