package cn.edu.learn.interview.design.listener.interfaces;

/**
 * @description: 监听接口
 * @author: hey
 * @date 2016/3/27
 * @version: 1.0
 */
public interface Listener<T> {

    /**
     * 事件更新
     * @param e
     */
    void update(Event<T> e);

    /**
     * 获得事件信息
     * @return
     */
    T getContent();
}
