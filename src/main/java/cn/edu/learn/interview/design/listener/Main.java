package cn.edu.learn.interview.design.listener;

import cn.edu.learn.interview.design.listener.interfaces.Listener;

/**
 * @description: 测试程序
 * @author: hey
 * @date 2016/3/27
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        final Listener listener = new EventListener();
        subject.addListener(listener);

        new Thread(new Runnable() {

            String conntent = null;

            @Override
            public void run() {
                while (!"stop".equals(conntent)) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println( conntent = (String) listener.getContent());
                }
            }
        }).start();

        subject.notifyListener();
    }
}
