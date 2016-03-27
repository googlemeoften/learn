package cn.edu.learn.interview.design.listener;

import cn.edu.learn.interview.design.listener.interfaces.Listener;
import cn.edu.learn.interview.design.listener.interfaces.Observerable;

/**
 * @description: 被 观察者
 * @author: hey
 * @date 2016/3/27
 * @version: 1.0
 */
public class Subject implements Observerable {
    private Listener listener;

    @Override
    public void addListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public void notifyListener() {
        ComputeEvent<String> event = new ComputeEvent<>();

        for (int i = 0; i <= 100; i++) {

            event.setChange("is the " + i);
            listener.update(event);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        event.setChange("stop");
        listener.update(event);
    }
}
