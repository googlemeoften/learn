package cn.edu.learn.interview.design.listener.interfaces;

/**
 * @description: 被观察者接口
 * @author: hey
 * @date 2016/3/27
 * @version: 1.0
 */
public interface Subject {
    /**
     *
     * @param listener
     */
    void addListener(Listener listener);

    /**
     * 通知监听者
     */
    void notifyListener();

}
